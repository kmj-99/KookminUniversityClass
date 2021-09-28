package org.techtown.first_clone.Fragment.Second

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.first_clone.R

class Second_Category_Adapter (val context: Context, var ItemList:ArrayList<Second_Category_Item_Class>): RecyclerView.Adapter<Second_Category_ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Second_Category_ViewHolder {
        return Second_Category_ViewHolder(LayoutInflater.from(context).inflate(R.layout.second_category_layout,parent,false))
    }

    override fun onBindViewHolder(holder: Second_Category_ViewHolder, position: Int) {
        holder.bind(ItemList[position])
    }

    override fun getItemCount(): Int {
        return this.ItemList.size
    }

}