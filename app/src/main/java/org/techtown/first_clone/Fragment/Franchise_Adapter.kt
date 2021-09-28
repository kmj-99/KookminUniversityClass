package org.techtown.first_clone.Fragment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.first_clone.R

class Franchise_Adapter(val context: Context, var ItemList:ArrayList<Franchise_Item_Class> ): RecyclerView.Adapter<Franchise_ViewHolder>() {
    private lateinit var itemClickListener:OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Franchise_ViewHolder {
        return Franchise_ViewHolder(LayoutInflater.from(context).inflate(R.layout.franchise_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: Franchise_ViewHolder, position: Int) {
        holder.bind(ItemList[position])

        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it,position)
        }
    }

    interface OnItemClickListener{
        fun onClick(v: View, position:Int)
    }


    fun setItemClickListener(onItemClickListener:OnItemClickListener){
        this.itemClickListener=onItemClickListener
    }



    override fun getItemCount(): Int {
        return ItemList.size
    }




}