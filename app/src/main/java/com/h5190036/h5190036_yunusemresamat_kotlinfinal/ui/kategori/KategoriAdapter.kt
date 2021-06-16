package com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.kategori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.data.kategori.KategoriModelItem
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.databinding.CardviewKategoriBinding
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.ItemClickListener
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.util.resimCek

class KategoriAdapter(
        var kategoriler: List<KategoriModelItem>,
        var onItemClickListener: ItemClickListener
) : RecyclerView.Adapter<KategoriAdapter.ViewHolder>() {

        inner class ViewHolder(val binding: CardviewKategoriBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardviewKategoriBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return kategoriler.size
    }

    fun setData(yeniKategoriler: List<KategoriModelItem>){
        kategoriler = yeniKategoriler
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder){

            binding.apply {

                binding.imgCardLogo.resimCek(kategoriler[position].kategoriImg.toString())
                binding.txtCardKategoriAdText.text = kategoriler[position].kategoriAd

                kategoriCard.setOnClickListener{

                    onItemClickListener.onItemClick(position)
                }

            }
        }
    }

}
