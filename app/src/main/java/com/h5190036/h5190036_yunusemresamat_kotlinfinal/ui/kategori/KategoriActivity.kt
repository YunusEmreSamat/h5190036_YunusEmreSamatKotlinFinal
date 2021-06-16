package com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.kategori

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.R
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.kategori.KategoriModelItem
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.databinding.ActivityKategoriBinding
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.ItemClickListener
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.ilan.IlanActivity
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.AlertDialogUtil
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Constants

class KategoriActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKategoriBinding

    var kategoriViewModel: KategoriViewModel?=null
    var kategoriList: List<KategoriModelItem>? = null
    private lateinit var kategoriAdapter: KategoriAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }

    fun init(){
        binding = ActivityKategoriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        kategorileriAl()
        filtre()
    }

    fun filtre(){

        binding.apply {

            searchVwKategori.setOnQueryTextListener(object : SearchView.OnQueryTextListener
            {
                override fun onQueryTextSubmit(query: String?): Boolean {

                    return false
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    kategoriFiltreleme(newText)
                    return false
                }
            })
        }
    }


    fun kategoriFiltreleme(text: String?){

        text?.let {
            kategoriList?.let {
                var filtreliKategoriListe = it.filter { it.kategoriAd!!.toLowerCase().contains(text.toLowerCase()) }
                initRecycleView(filtreliKategoriListe)
            }
        }

    }


    fun kategorileriAl(){

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage(getString(R.string.progressDialogMessage))
        progressDialog.show()

        kategoriViewModel = KategoriViewModel()

        kategoriViewModel?.apply {

            kategorilerLiveData?.observe(this@KategoriActivity, Observer {

                kategoriList = it
                initRecycleView(it)
                progressDialog.dismiss()

            })

            error?.observe(this@KategoriActivity, Observer {

                it.run {
                    Toast.makeText(applicationContext,this.localizedMessage, Toast.LENGTH_LONG).show()
                }
            })

            loading?.observe(this@KategoriActivity, Observer {

            })

        }
    }

    fun initRecycleView(kategoriliste:List<KategoriModelItem>) {

        binding.apply {

            kategoriAdapter = KategoriAdapter(kategoriliste, object : ItemClickListener {

                override fun onItemClick(position: Int) {

                   Constants.TIKLANAN_KATEGORI = kategoriliste.get(position).kategoriAd.toString()
                   startActivity(Intent(this@KategoriActivity,IlanActivity::class.java))

                }
            })

            rcwKategoriler.adapter = kategoriAdapter
            rcwKategoriler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        }
    }



    override fun onBackPressed() {
        val alertUtil = AlertDialogUtil()
        alertUtil.alertDialog(
            this,
            KategoriActivity::class.java,
            getString(R.string.alertTitle2),
            getString(R.string.alertMessage2),
            getString(R.string.alertPositive2),
            getString(R.string.alertNegative2))
    }
}