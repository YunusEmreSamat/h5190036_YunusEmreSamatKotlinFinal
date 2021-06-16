package com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.ilan.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class IlanModel : ArrayList<IlanModelItem>()

data class IlanModelItem(
    @SerializedName("kategoriAd")
    @Expose
    var kategoriAd: String? = null,

    @SerializedName("ilanImg")
    @Expose
    var ilanImg: String? = null,

    @SerializedName("ilanNumarasi")
    @Expose
    var ilanNumarasi: String? = null,

    @SerializedName("ilanAdi")
    @Expose
    var ilanAdi: String? = null,

    @SerializedName("ilanFiyati")
    @Expose
    var ilanFiyati: String? = null,

    @SerializedName("ilanAdresi")
    @Expose
    var ilanAdresi: String? = null,

    @SerializedName("ilanTarihi")
    @Expose
    var ilanTarihi: String? = null,

    @SerializedName("ilanIsitmaTipi")
    @Expose
    var ilanIsitmaTipi: String? = null,

    @SerializedName("ilanOdaSayisi")
    @Expose
    var ilanOdaSayisi: String? = null,

    @SerializedName("ilanBinaYasi")
    @Expose
    var ilanBinaYasi: String? = null,

    @SerializedName("ilanMetrekaresi")
    @Expose
    var ilanMetrekaresi: String? = null,

    @SerializedName("ilanBalkonDurumu")
    @Expose
    var ilanBalkonDurumu: String? = null

)