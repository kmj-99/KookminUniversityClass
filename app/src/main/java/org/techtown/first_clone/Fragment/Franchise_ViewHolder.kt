package org.techtown.first_clone.Fragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.franchise_item_layout.view.*
import org.techtown.first_clone.R
import org.techtown.first_clone.app

class Franchise_ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)  {

    private var Franchise_image=ItemView.Franchise_Image
    private var Franchise_name=ItemView.Franchise_Name
    private var Franchise_information_rating=ItemView.Franchise_Information_Layout_Rating
    private var Franchise_information_raters=ItemView.Franchise_Information_Layout_Raters
    private var Franchise_information_distance=ItemView.Franchise_Information_Layout_Distance



    fun bind(Item: Franchise_Item_Class){
        Glide.with(app.instance).load(Item.Image).placeholder(R.mipmap.ic_launcher).into(Franchise_image)
        Franchise_name.text=Item.Name
        Franchise_information_rating.text=Item.Rating
        Franchise_information_raters.text=Item.RaterNumber
        Franchise_information_distance.text=Item.Distance
    }


}