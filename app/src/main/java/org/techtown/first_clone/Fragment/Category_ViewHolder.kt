package org.techtown.first_clone.Fragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.category_item_layout.view.*
import org.techtown.first_clone.R
import org.techtown.first_clone.app

class Category_ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
    private val Image=ItemView.Category_ItemImage_MajorImage
    private val Name=ItemView.Category_TextView

    fun bind(item: Category_Item_Class){
        Name.text=item.Nmae
        Glide.with(app.instance).load(item.Image).placeholder(R.mipmap.ic_launcher).into(Image)
    }

}