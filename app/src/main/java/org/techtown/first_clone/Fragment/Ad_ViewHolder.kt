package org.techtown.first_clone.Fragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.ad_item_layout.view.*
import org.techtown.first_clone.R
import org.techtown.first_clone.app

class Ad_ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
    private var image_name=ItemView.Ad_Image

    fun bind(Item: Ad_Item_Class) {
        Glide.with(app.instance).load(Item.image).placeholder(R.mipmap.ic_launcher).into(image_name)
    }



}