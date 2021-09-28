package org.techtown.first_clone.Fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.first_clone.R

class Category_Adapter(val context: Context, private var ItemList:ArrayList<Category_Item_Class>) : RecyclerView.Adapter<Category_ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Category_ViewHolder {
        return Category_ViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item_layout,parent,false))
        // 프래그먼트와 액티비티의 다른점은 바로 context다. 액티비티에서는 액티비티의 context룰 그냥 가져오면 되기에 parent.context라고 하면 되지만
        // 프래그먼트에서는 액티비티와 attach가 안 될수도 있으므로 그냥 context를 가져오진 못한다. 따라서 액티비티와 attach가 된다는 보장하에 가져와야한다.
        // 그 보장을 하기위새 requireContext()를 이용해 하는 것이고 그걸 위 코드처럼 파라미터로 따로 받아야 한다는 점이 액티비티와 차이점이다.
    }

    override fun onBindViewHolder(holder: Category_ViewHolder, position: Int) {
        holder.bind(ItemList[position])
    }

    override fun getItemCount(): Int {
        return this.ItemList.size
    }

}