package com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.AlertDialogUtil
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.NetworkUtil
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.R
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.databinding.ActivitySplashBinding
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }

    fun init(){

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        timer()
    }

    private fun timer() {
        val countDownTimer: CountDownTimer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                internetControlAndNextPage()
            }
        }
        countDownTimer.start()
    }

    private fun internetControlAndNextPage() {

        if (NetworkUtil().networkKontrol(applicationContext)) {
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        } else {
            noInternetErrorDialog()
        }
    }

    private fun noInternetErrorDialog() {
        val alertUtil = AlertDialogUtil()
        alertUtil.alertDialog(
            this,
            SplashActivity::class.java,
            getString(R.string.alertTitle),
            getString(R.string.alertMessage),
            getString(R.string.alertPositive),
            getString(R.string.alertNegative)
        )
    }
}