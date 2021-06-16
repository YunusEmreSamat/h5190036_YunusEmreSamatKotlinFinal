package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.login.model

import com.google.gson.annotations.SerializedName

class KullaniciModel : ArrayList<KullaniciModelItem>()

data class KullaniciModelItem(
    @SerializedName("adSoyad")
    val adSoyad: String,
    @SerializedName("mail")
    val mail: String,
    @SerializedName("sifre")
    val sifre: String


)