package org.techtown.first_clone.franchise_activity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.first_clone.R

class First_Category_Content_Adapter (val context: Context, var ItemList:ArrayList<First_Category_Content_Item_Class>,var type:Int?=0): RecyclerView.Adapter<First_Category_Content_ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): First_Category_Content_ViewHolder {
        return First_Category_Content_ViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_first_category_content_layout,parent,false))
    }

    override fun onBindViewHolder(holder: First_Category_Content_ViewHolder, position: Int) {
        holder.bind(ItemList[position])
    }

    override fun getItemCount(): Int {
        return this.ItemList.size
    }

}