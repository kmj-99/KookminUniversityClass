package org.techtown.first_clone.franchise_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.first_clone.R
import org.techtown.first_clone.databinding.ActivityFranchiseFirstBinding

class Franchise_Fourth : AppCompatActivity() {private lateinit var binding: ActivityFranchiseFirstBinding

    private lateinit var CategoryAdapter:First_Category_Adapter
    private lateinit var Category_Content_Adapter:First_Category_Content_Adapter

    private var CategoryList=ArrayList<First_Category_Item_Class>()
    private var CategoryContentList=ArrayList<First_Category_Content_Item_Class>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFranchiseFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var Name=intent.getStringExtra("name")
        var Rating=intent.getStringExtra("rating")
        var Raters=intent.getStringExtra("raters")

        binding.ToolBarTextView.text=Name
        binding.NameText.text=Name
        binding.RatingText.text=Rating
        binding.RatersText.text=Raters


        var item1=First_Category_Item_Class("추천 메뉴")
        var item2=First_Category_Item_Class("메인 메뉴")
        var item3=First_Category_Item_Class("1인 세트메뉴")
        var item4=First_Category_Item_Class("특별 메뉴")
        var item5=First_Category_Item_Class("토핑 메뉴")

        CategoryList.add(item1)
        CategoryList.add(item2)
        CategoryList.add(item3)
        CategoryList.add(item4)
        CategoryList.add(item5)





        var content_item1=First_Category_Content_Item_Class("추천메뉴",R.drawable.franchise_snack_shape,"주문많음","리뷰적음","추천 메뉴","1억",
            "머니 언빌리버블(치즈 곱창/불막창/캐비어 1숟갈)소주+맥주")

        var content_item2=First_Category_Content_Item_Class("메인메뉴",R.drawable.franchise_pizza_shape,"주문없음","리뷰최고","메인메뉴","2천만원",
            "바삭한김치천+스페셜한모듬구성(떡,비엔나소세지,오뎅,팝만두,계란,모짜치즈,체다치즈)")

        var content_item3=First_Category_Content_Item_Class("1인 세트 메뉴",R.drawable.franchise_korean_food_shape,"주문많음","리뷰최고","1인 세트A","1억",
            "머니 크레이지(치즈 감자전/치즈 돈까스/우삼겹+파채)떡볶이+날치알주먹밥")

        var content_item4=First_Category_Content_Item_Class("서울 성북구 특별메뉴",R.drawable.franchise_hamburger_shape,"주문많음","리뷰최고","머니 크레이지 짜장 떡볶이","3억",
            "짜장소스+떡+오뎅+우동사리")

        var content_item5=First_Category_Content_Item_Class("토핑메뉴",R.drawable.franchise_korean_food_shape,"주문많음","리뷰최고","치즈","5백만원",
            "모짜렐라&체다, 모짜렐라, 체다")


        CategoryContentList.add(content_item1)
        CategoryContentList.add(content_item2)
        CategoryContentList.add(content_item3)
        CategoryContentList.add(content_item4)
        CategoryContentList.add(content_item5)



    }
    //Adapter를 계속해서 초기화 시켜서 실시간 정보를 쉽게 갱신할 수 있도록 하기위함
    override fun onStart() {
        super.onStart()
        Category_Content_Adapter=First_Category_Content_Adapter(this,CategoryContentList)
        CategoryAdapter= First_Category_Adapter(this,CategoryList)

    }

    //본격적으로 사용자와 상호작용을 하는 코드를 여기다 적음
    override fun onResume() {
        super.onResume()

        binding.FirstRecyclerView.apply {
            layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter=CategoryAdapter
        }


        binding.FirstContentRecyclerview.apply {
            layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter=Category_Content_Adapter
        }

        CategoryAdapter.setItemClickListener(object: First_Category_Adapter.OnItemClickListener{
            override fun onClick(v: View, position:Int){
                binding.FirstContentRecyclerview.smoothScrollToPosition(position)
                binding.FirstRecyclerView.smoothScrollToPosition(position)
            }
        })

        binding.finishButton.setOnClickListener{
            finish()
        }

    }


    override fun onRestart() {
        super.onRestart()

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}