package com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.ilan

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.R
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.ilan.model.IlanModelItem
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.databinding.ActivityIlanBinding
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.ItemClickListener
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.detay.DetayActivity
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Constants
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.ObjectUtil

class IlanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIlanBinding

    var siraliIlanlar = arrayListOf<IlanModelItem>()
    var ilanViewModel: IlanViewModel?=null
    private lateinit var ilanAdapter: IlanAdapter
    private lateinit var ilanGridAdapter: IlanGridAdapter
    var listeTur:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init(){
        binding = ActivityIlanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ilanlariAl()
        siralama()

    }


    fun siralama(){

        binding.apply {

            btnListSirala.setOnClickListener {

                val builder = AlertDialog.Builder(this@IlanActivity)
                builder.setTitle(R.string.siralamaAlertTitle)
                val siralamatur = arrayOf(getString(R.string.siralamaIsmeGoreArtan), getString(R.string.siralamaIsmeGoreAzalan))
                builder.setItems(siralamatur) { dialog, pozisyon ->
                    when (pozisyon) {
                        0 -> {
                            siraliIlanlar?.sortBy { it.ilanAdi }
                            initRecycleView(siraliIlanlar)
                            btnListSirala.text = getString(R.string.siralamaIsmeGoreArtan)

                        }
                        1 -> {
                            siraliIlanlar?.sortByDescending { it.ilanAdi }
                            initRecycleView(siraliIlanlar)
                            btnListSirala.text = getString(R.string.siralamaIsmeGoreAzalan)
                        }
                    }
                }
                val dialog = builder.create()
                dialog.show()

            }

            btnListListeTurDegistir.setOnClickListener {

                if(listeTur == 1){
                    listeTur = 2
                    rcvIlanlar.adapter = ilanGridAdapter
                    rcvIlanlar.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    btnListListeTurDegistir.text = getString(R.string.btnListListeTurGrid)
                }
                else{
                    listeTur = 1
                    rcvIlanlar.adapter = ilanAdapter
                    rcvIlanlar.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                    btnListListeTurDegistir.text = getString(R.string.btnListListeTurLinear)
                }

            }
        }

    }


    fun ilanlariAl(){

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage(getString(R.string.progressDialogMessage))
        progressDialog.show()

        ilanViewModel = IlanViewModel()

        ilanViewModel?.apply {

            ilanLiveData?.observe(this@IlanActivity, Observer {

                var ilanlar = it.filter { it.kategoriAd!! == Constants.TIKLANAN_KATEGORI }

                siraliIlanlar.addAll(ilanlar)
                initRecycleView(ilanlar)
                progressDialog.dismiss()

            })

            error?.observe(this@IlanActivity, Observer {

                it.run {
                    Toast.makeText(applicationContext,this.localizedMessage, Toast.LENGTH_LONG).show()
                }
            })

            loading?.observe(this@IlanActivity, Observer {

            })

        }
    }

    fun initRecycleView(ilanliste:List<IlanModelItem>) {

        binding.apply {

            ilanAdapter = IlanAdapter(ilanliste, object : ItemClickListener {
                override fun onItemClick(position: Int) {
                    Constants.TIKLANAN_ILAN = ilanliste.get(position).ilanAdi.toString()
                    val tiklananIlanString: String? = ObjectUtil.objectToString(ilanliste.get(position))
                    startActivity(Intent(this@IlanActivity,DetayActivity::class.java).putExtra(Constants.TIKLANAN_ILAN,tiklananIlanString))
                }
            })

            ilanGridAdapter = IlanGridAdapter(ilanliste, object : ItemClickListener {

                override fun onItemClick(position: Int) {
                    Constants.TIKLANAN_ILAN = ilanliste.get(position).ilanAdi.toString()
                    val tiklananIlanString: String? = ObjectUtil.objectToString(ilanliste.get(position))
                    startActivity(Intent(this@IlanActivity,DetayActivity::class.java).putExtra(Constants.TIKLANAN_ILAN,tiklananIlanString))
                }
            })

            if(listeTur == 1){
                rcvIlanlar.adapter = ilanAdapter
                rcvIlanlar.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

            }
            else{
                rcvIlanlar.adapter = ilanGridAdapter
                rcvIlanlar.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            }

        }
    }

}