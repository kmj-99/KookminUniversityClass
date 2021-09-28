package org.techtown.first_clone.franchise_activity

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_first_category_content_layout.view.*
import kotlinx.android.synthetic.main.ad_item_layout.view.*
import org.techtown.first_clone.R
import org.techtown.first_clone.app

class First_Category_Content_ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
    private var image_name=ItemView.Image
    private var title=ItemView.TitleTextView
    private var text1=ItemView.TextView1
    private var text2=ItemView.TextView2
    private var set=ItemView.SetTextView
    private var price=ItemView.PriceTextView
    private var content=ItemView.ContentTextView

    fun bind(Item: First_Category_Content_Item_Class) {
        title.text=Item.title
        text1.text=Item.text1
        text2.text=Item.text2
        set.text=Item.set
        price.text=Item.price
        content.text=Item.content

        Glide.with(app.instance).load(Item.image).placeholder(R.mipmap.ic_launcher).into(image_name)
    }

}
