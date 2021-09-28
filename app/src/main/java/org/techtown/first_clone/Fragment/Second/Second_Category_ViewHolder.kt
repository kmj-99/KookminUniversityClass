package org.techtown.first_clone.Fragment.Second

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.ad_item_layout.view.*
import kotlinx.android.synthetic.main.second_category_layout.view.*
import org.techtown.first_clone.R
import org.techtown.first_clone.app

class Second_Category_ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
    private var image_name=ItemView.Second_Image_Name
    private var name=ItemView.Second_Text_Name

    fun bind(Item: Second_Category_Item_Class) {
        Glide.with(app.instance).load(Item.image).placeholder(R.mipmap.ic_launcher).into(image_name)
        name.text=Item.name
    }



}