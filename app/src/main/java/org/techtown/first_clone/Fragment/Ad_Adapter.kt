package org.techtown.first_clone.Fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.first_clone.R

class Ad_Adapter (val context: Context,var ItemList:ArrayList<Ad_Item_Class>): RecyclerView.Adapter<Ad_ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Ad_ViewHolder {
        return Ad_ViewHolder(LayoutInflater.from(context).inflate(R.layout.ad_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: Ad_ViewHolder, position: Int) {
        holder.bind(ItemList[position])
    }

    override fun getItemCount(): Int {
        return this.ItemList.size
    }

}