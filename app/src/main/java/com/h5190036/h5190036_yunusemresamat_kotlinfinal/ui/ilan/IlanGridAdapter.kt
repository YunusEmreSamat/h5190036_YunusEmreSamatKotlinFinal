package com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.ilan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.ilan.model.IlanModelItem
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.databinding.CardviewIlangridBinding
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.ItemClickListener
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.resimCek

class IlanGridAdapter(
        var ilanlar: List<IlanModelItem>,
        var onItemClickListener: ItemClickListener ) : RecyclerView.Adapter<IlanGridAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CardviewIlangridBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardviewIlangridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ilanlar.size
    }

    fun setData(yeniIlanlar: List<IlanModelItem>){
        ilanlar = yeniIlanlar
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder){

            binding.apply {

                binding.imgCardIlanLogo.resimCek(ilanlar[position].ilanImg.toString())
                binding.txtCardIlanAd.text = ilanlar[position].ilanAdi
                binding.txtCardIlanFiyat.text = ilanlar[position].ilanFiyati
                binding.txtCardIlanAdres.text = ilanlar[position].ilanAdresi
                binding.txtCardIlanTarih.text = ilanlar[position].ilanTarihi


                listeCard.setOnClickListener{
                    onItemClickListener.onItemClick(position)
                }

            }
        }
    }

}
