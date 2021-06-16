package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.kategori

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class KategoriModel : ArrayList<KategoriModelItem>()

data class KategoriModelItem(
    @SerializedName("kategoriImg")
    @Expose
    var kategoriImg: String? = null,

    @SerializedName("kategoriAd")
    @Expose
    var kategoriAd: String? = null

)