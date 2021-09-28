package org.techtown.first_clone.Fragment.Second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_second__layout_.view.*
import org.techtown.first_clone.R


class Second_Layout_Fragment : Fragment() {
    private var CategoryList=ArrayList<Second_Category_Item_Class>()
    private lateinit var rootView:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView=inflater.inflate(R.layout.fragment_second__layout_,container,false)

        var item1=Second_Category_Item_Class(R.drawable.second_grid_new_shape,"신규맛집")
        var item2=Second_Category_Item_Class(R.drawable.second_grid_one_shape,"1인분")
        var item3=Second_Category_Item_Class(R.drawable.second_grid_korean_shape,"한식")
        var item4=Second_Category_Item_Class(R.drawable.second_grid_chicken_shape,"치킨")
        var item5=Second_Category_Item_Class(R.drawable.second_grid_snack_shape,"분식")
        var item6=Second_Category_Item_Class(R.drawable.second_grid_pork_cutlets_shape,"돈까스")
        var item7=Second_Category_Item_Class(R.drawable.second_grid_pork_feet_shape,"족발")
        var item8=Second_Category_Item_Class(R.drawable.second_grid_soup_shape,"국")
        var item9=Second_Category_Item_Class(R.drawable.second_grid_roast_shape,"구이")
        var item10=Second_Category_Item_Class(R.drawable.second_grid_pizza_shape,"피자")
        var item11=Second_Category_Item_Class(R.drawable.second_grid_chicken_shape,"중식")
        var item12=Second_Category_Item_Class(R.drawable.second_grid_japen_shape,"일본")

        CategoryList.add(item1)
        CategoryList.add(item2)
        CategoryList.add(item3)
        CategoryList.add(item4)
        CategoryList.add(item5)
        CategoryList.add(item6)
        CategoryList.add(item7)
        CategoryList.add(item8)
        CategoryList.add(item9)
        CategoryList.add(item10)
        CategoryList.add(item11)
        CategoryList.add(item12)

        var CategoryAdapter=Second_Category_Adapter(requireContext(),CategoryList)

        rootView.Second_recyclerView.apply {
            layoutManager= GridLayoutManager(requireContext(),3, RecyclerView.VERTICAL,false)
            // spanCount 같은 경우는 RecyclerView.HORIZONTAL,RecyclerView.VERTICAL에 따라서 의미가 달라진다.
            //RecyclerView.HORIZONTAL : 수평이 기준이기 때문에 spanCount는 행을 뜻한다.
            //RecyclerView.VERTICAL : 수직이 기준이기 때문에 spanCount는 열을 뜻한다.
            adapter=CategoryAdapter
        }




//
        //Glide.with(requireContext()).load(R.drawable.second_grid_new_shape).placeholder(R.drawable.bills_icon).into(rootView.Second_Item1)
        //rootView.Second_TextView1.text="신규맛집"
//
        //Glide.with(requireContext()).load(R.drawable.second_grid_one_shape).placeholder(R.drawable.bills_icon).into(rootView.Second_Item2)
        //rootView.Second_TextView2.text="1인분"
//
//
        //Glide.with(requireContext()).load(R.drawable.second_grid_korean_shape).placeholder(R.drawable.bills_icon).into(rootView.Second_Item3)
        //rootView.Second_TextView3.text="한식"
//
//
        //Glide.with(requireContext()).load(R.drawable.second_grid_chicken_shape).placeholder(R.drawable.bills_icon).into(rootView.Second_Item4)
        //rootView.Second_TextView4.text="치킨"
//
//
        //Glide.with(requireContext()).load(R.drawable.second_grid_snack_shape).placeholder(R.drawable.bills_icon).into(rootView.Second_Item5)
        //rootView.Second_TextView5.text="분식"
//
//
        //Glide.with(requireContext()).load(R.drawable.second_grid_pork_cutlets_shape).placeholder(R.drawable.bills_icon).into(rootView.Second_Item6)
        //rootView.Second_TextView6.text="돈가스"
//
//
        //Glide.with(requireContext()).load(R.drawable.second_grid_pork_feet_shape).placeholder(R.drawable.bills_icon).into(rootView.Second_Item7)
        //rootView.Second_TextView7.text="족발/보쌈"
//
//
        //Glide.with(requireContext()).load(R.drawable.second_grid_soup_shape).placeholder(R.drawable.bills_icon).into(rootView.Second_Item8)
        //rootView.Second_TextView8.text="찜/탕"
//
//
        //Glide.with(requireContext()).load(R.drawable.second_grid_roast_shape).placeholder(R.drawable.bills_icon).into(rootView.Second_Item9)
        //rootView.Second_TextView9.text="구이"
//
//
        //Glide.with(requireContext()).load(R.drawable.second_grid_pizza_shape).placeholder(R.drawable.bills_icon).into(rootView.Second_Item10)
        //rootView.Second_TextView10.text="피자"
//
//
        //Glide.with(requireContext()).load(R.drawable.second_grid_china_shape).placeholder(R.drawable.bills_icon).into(rootView.Second_Item11)
        //rootView.Second_TextView11.text="중식"
//
//
        //Glide.with(requireContext()).load(R.drawable.second_grid_japen_shape).placeholder(R.drawable.bills_icon).into(rootView.Second_Item12)
        //rootView.Second_TextView12.text="일식"


        return rootView
    }


}