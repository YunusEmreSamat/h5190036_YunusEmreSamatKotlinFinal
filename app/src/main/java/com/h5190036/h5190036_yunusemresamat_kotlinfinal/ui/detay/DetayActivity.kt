package com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.detay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.ilan.model.IlanModelItem
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.databinding.ActivityDetayBinding
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.Constants
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.ObjectUtil
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.resimCek

class DetayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetayBinding

    var tiklananIlanString:String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }

    fun init(){
        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tiklananIlanString = intent.getStringExtra(Constants.TIKLANAN_ILAN)
        var ilanModel : IlanModelItem? = ObjectUtil.jsonStringToObject(tiklananIlanString.toString())

        binding.apply {

            imgIlanLogo.resimCek(ilanModel?.ilanImg.toString())
            txtIlanAdi.text = ilanModel?.ilanAdi.toString()
            txtIlanAdresi.text = ilanModel?.ilanAdresi.toString()
            txtIlanFiyati.text = ilanModel?.ilanFiyati.toString()
            txtIlanTarih.text = ilanModel?.ilanTarihi.toString()

            txtIlanTarihi.text = ilanModel?.ilanTarihi.toString()
            txtIlanNumarasi.text = ilanModel?.ilanNumarasi.toString()
            txtIlanMetrekaresi.text = ilanModel?.ilanMetrekaresi.toString()
            txtIlanOdaSayisi.text = ilanModel?.ilanOdaSayisi.toString()
            txtIlanBinaYasi.text = ilanModel?.ilanBinaYasi.toString()
            txtIlanIsitmaTipi.text = ilanModel?.ilanIsitmaTipi.toString()
            txtIlanBalkonDurum.text = ilanModel?.ilanBalkonDurumu.toString()

        }

    }

}