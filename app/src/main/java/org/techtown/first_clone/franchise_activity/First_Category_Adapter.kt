package org.techtown.first_clone.franchise_activity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.first_clone.Fragment.Franchise_Adapter
import org.techtown.first_clone.R

class First_Category_Adapter(val context: Context, private var ItemList:ArrayList<First_Category_Item_Class>) : RecyclerView.Adapter<First_Category_ViewHolder>() {
    private lateinit var itemClickListener: First_Category_Adapter.OnItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): First_Category_ViewHolder {
        return First_Category_ViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_first_category_layout,parent,false))

    }

    override fun onBindViewHolder(holder: First_Category_ViewHolder, position: Int) {
        holder.bind(ItemList[position])

        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it,position)
        }
    }

    override fun getItemCount(): Int {
        return this.ItemList.size
    }


    interface OnItemClickListener{
        fun onClick(v: View, position:Int)
    }


    fun setItemClickListener(onItemClickListener:OnItemClickListener){
        this.itemClickListener=onItemClickListener
    }


}