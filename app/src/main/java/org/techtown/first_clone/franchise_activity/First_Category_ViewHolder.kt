package org.techtown.first_clone.franchise_activity

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_first_category_layout.view.*
import kotlinx.android.synthetic.main.category_item_layout.view.*
import org.techtown.first_clone.R
import org.techtown.first_clone.app

class First_Category_ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
    private val Name=ItemView.Category_name

    fun bind(item: First_Category_Item_Class){
        Name.text=item.name
    }

}