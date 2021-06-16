package com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.login

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.R
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.login.model.KullaniciModelItem
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.databinding.ActivityLoginBinding
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.kategori.KategoriActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    var kullaniciViewModel =KullaniciViewModel()
    var kullanicilar = arrayListOf<KullaniciModelItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init(){
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        kullanicilariAl()

    }

    fun kullanicilariAl(){

        kullaniciViewModel= KullaniciViewModel()

        kullaniciViewModel?.apply {

            kullanicilarLiveData?.observe(this@LoginActivity, Observer {

                kullanicilar.addAll(it)

                girisIslemleri()
            })

            error?.observe(this@LoginActivity, Observer {

                it.run {
                    Toast.makeText(applicationContext,this.localizedMessage,Toast.LENGTH_LONG).show()
                }
            })

            loading?.observe(this@LoginActivity, Observer {

            })
        }

    }


    fun girisIslemleri(){

        binding.apply {

            btnLoginGirisYap.setOnClickListener {

                if (eTxtLoginEposta.text.toString() == ""){
                    txtEpostaBosHata.setText(R.string.alanZorunlu)

                    eTxtLoginEposta.getBackground().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP)
                }
                else{
                    txtEpostaBosHata.setText("")

                    eTxtLoginEposta.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP)
                }

                if (eTxtLoginSifre.text.toString() == ""){
                    txtSifreBosHata.setText(R.string.alanZorunlu)

                    eTxtLoginSifre.getBackground().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP)

                }
                else{
                    txtSifreBosHata.setText("")

                    eTxtLoginSifre.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP)
                }


                if (eTxtLoginEposta.text.toString() != "" && eTxtLoginSifre.text.toString() != ""){

                    if(kullanicilar.any{it.mail == eTxtLoginEposta.text.toString() && it.sifre == eTxtLoginSifre.text.toString()}){

                        startActivity(Intent(this@LoginActivity, KategoriActivity::class.java))
                        finish()

                    }
                    else{
                        Toast.makeText(applicationContext,R.string.kullaniciBilgiHatalı, Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }
    }


}
