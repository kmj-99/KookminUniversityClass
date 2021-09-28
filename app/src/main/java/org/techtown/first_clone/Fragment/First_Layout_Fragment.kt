package org.techtown.first_clone.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first__layout_.*
import kotlinx.android.synthetic.main.fragment_first__layout_.view.*
import kotlinx.android.synthetic.main.franchise_item_layout.view.*
import kotlinx.coroutines.*
import org.techtown.first_clone.*
import org.techtown.first_clone.databinding.ActivityMainBinding
import org.techtown.first_clone.databinding.FragmentFirstLayoutBinding
import org.techtown.first_clone.franchise_activity.*
import java.lang.Exception


class First_Layout_Fragment : Fragment() {

    private lateinit var binding: FragmentFirstLayoutBinding
    private lateinit var rootView:View

    private lateinit var Ad_stop:Job
    private lateinit var Ad_ing:Job
    //Job은 코루틴의 상태를 가지고 있는 인터페이스다. 따라서 코루틴의 상태를 담기 위해서는 자료형을 Job으로 해야한다.

    private lateinit var thread1:Thread
    private var Ad_All_Number=0

    private var Ad_ItemList=ArrayList<Ad_Item_Class>()
    private var Category_ItemList=ArrayList<Category_Item_Class>()
    private var Franchise_ItemList=ArrayList<Franchise_Item_Class>()


    private var count=0


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentFirstLayoutBinding.inflate(layoutInflater)
        //일반적으로 Fragment에서 context에 접근하면 null이 아닌 값을 반환하지만,
        //Fragment가 Activity에 attach 되지 않은 경우 등의 예외가 발생할 수 있으므로 Fragment.getContext()가 항상 NonNull인 것은 아니다.
        // 그러므로 attach가 되었다는 걸 보장하기위헤 requireContext()를 쓴다.

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_first__layout_, container, false)

        val ItemArray=resources.getStringArray(R.array.my_array)
        val ItemArrayAdapter= ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item,ItemArray)

        //spinner
        rootView.spinner.adapter=ItemArrayAdapter



        for(i in 1..100) {
            val Item1 = Ad_Item_Class(image = R.drawable.ad_image1)
            val Item2 = Ad_Item_Class(image = R.drawable.ad_image2)
            val Item3 = Ad_Item_Class(image = R.drawable.ad_image3)
            val Item4 = Ad_Item_Class(image = R.drawable.ad_image4)
            val Item5 = Ad_Item_Class(image = R.drawable.ad_image5)

            this.Ad_ItemList.add(Item1)
            this.Ad_ItemList.add(Item2)
            this.Ad_ItemList.add(Item3)
            this.Ad_ItemList.add(Item4)
            this.Ad_ItemList.add(Item5)

            if(i==1){
                Ad_All_Number=Ad_ItemList.size
                binding.AdAllNumber.text=" /${Ad_All_Number}"
            }

        }
        rootView.ViewPager.adapter=Ad_Adapter(requireContext(),Ad_ItemList)

       // thread1=Thread(){
       //     try{
       //         while(true) {
       //             Thread.sleep(2000)
       //             var msg = Message()
       //             var bundle = Bundle()
       //             count += 1
       //             Log.d("hohohoho","Thread")
       //             bundle.putInt("Count", count % 500)
       //             msg.data = bundle
       //             Ad_handler.sendMessage(msg)
       //         }
       //     }catch (e: Exception){
       //         e.printStackTrace()
       //     }
       // }



        val Category_Item1= Category_Item_Class("치킨",R.drawable.category_icon_chicken,null)
        val Category_Item2= Category_Item_Class("한식",R.drawable.category_icon_korean_food,null)
        val Category_Item3= Category_Item_Class("새로운음식",R.drawable.category_icon_new,null)
        val Category_Item4= Category_Item_Class("1인분",R.drawable.category_icon_one_serving,null)
        val Category_Item5= Category_Item_Class("피자",R.drawable.category_icon_pizza,null)
        val Category_Item6= Category_Item_Class("구이",R.drawable.category_icon_roast,null)
        val Category_Item7= Category_Item_Class("분식",R.drawable.category_icon_snack_bar,null)

        this.Category_ItemList.add(Category_Item1)
        this.Category_ItemList.add(Category_Item2)
        this.Category_ItemList.add(Category_Item3)
        this.Category_ItemList.add(Category_Item4)
        this.Category_ItemList.add(Category_Item5)
        this.Category_ItemList.add(Category_Item6)
        this.Category_ItemList.add(Category_Item7)

        var recycerView1=rootView.findViewById(R.id.RecyclerView1) as RecyclerView
        recycerView1.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,true)
        recycerView1.adapter=Category_Adapter(requireContext(),Category_ItemList)


        val Franchise_Item1= Franchise_Item_Class(R.drawable.franchise_hamburger_shape,"록키네 크레이지 수제 햄버거","4.5","(157)","1.5km","Free")
        val Franchise_Item2= Franchise_Item_Class(R.drawable.franchise_korean_food_shape,"록키네 언빌리버블 한식","4.8","(1,571)","2.5km","Free")
        val Franchise_Item3= Franchise_Item_Class(R.drawable.franchise_pizza_shape,"록키네 제일 맛있는 피자","4.9","(1,041)","0.3km","Free")
        val Franchise_Item4= Franchise_Item_Class(R.drawable.franchise_snack_shape,"록키네 판타스틱한 분식","4.5","(1,482)","0.7km","Free")

        this.Franchise_ItemList.add(Franchise_Item1)
        this.Franchise_ItemList.add(Franchise_Item2)
        this.Franchise_ItemList.add(Franchise_Item3)
        this.Franchise_ItemList.add(Franchise_Item4)

        var recyclerView2=rootView.findViewById(R.id.RecyclerView2) as RecyclerView
        var franchise_adapter=Franchise_Adapter(requireContext(),Franchise_ItemList)

        recyclerView2.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        recyclerView2.adapter=franchise_adapter


        var intent1= Intent(activity,Franchise_First::class.java)
        var intent2= Intent(activity,Franchise_Second::class.java)
        var intent3= Intent(activity,Franchise_Third::class.java)
        var intent4= Intent(activity,Franchise_Fourth::class.java)

        // fragment에서 activity로 intent를 전달할 때
        // fragment는 액티비티위에 있으므로  this가 아니라 activity(getActivity())를 파라미터로 넣어야 한다.

        franchise_adapter.setItemClickListener(object:Franchise_Adapter.OnItemClickListener{
            override fun onClick(v:View,position:Int){

                when(position){
                    0->{

                        intent1.putExtra("name","록키네 크레이지 수제 햄버거")
                        intent1.putExtra("rating",v.Franchise_Information_Layout_Rating.text.toString())
                        intent1.putExtra("raters",v.Franchise_Information_Layout_Raters.text.toString())

                        startActivity(intent1)
                    }

                    1->{
                        intent2.putExtra("name","록키네 언빌리버블 한식")
                        intent2.putExtra("rating",v.Franchise_Information_Layout_Rating.text.toString())
                        intent2.putExtra("raters",v.Franchise_Information_Layout_Raters.text.toString())
                        startActivity(intent2)
                    }

                    2->{
                        intent3.putExtra("name","록키네 제일 맛있는 피자")
                        intent3.putExtra("rating",v.Franchise_Information_Layout_Rating.text.toString())
                        intent3.putExtra("raters",v.Franchise_Information_Layout_Raters.text.toString())
                        startActivity(intent3)
                    }

                    3->{
                        intent4.putExtra("name","록키네 판타스틱한 분식")
                        intent4.putExtra("rating",v.Franchise_Information_Layout_Rating.text.toString())
                        intent4.putExtra("raters",v.Franchise_Information_Layout_Raters.text.toString())
                        startActivity(intent4)
                    }

                }

            }
        })




        return rootView
    }


    suspend fun Ad_Temp_stop(){

        Ad_stop= CoroutineScope(Dispatchers.Main).launch{
            try {
                    delay(500000)
                    Log.d("Frist_Layout_Fragment","Ad_stop")
            }catch (e:Exception){
                e.printStackTrace()
            }

        }
    }

    suspend fun Ad_start(){

        Ad_ing=CoroutineScope(Dispatchers.Main).launch {
            try {
                while (true) {
                    Ad_stop.join() //Ad_stop이 끝날 때까지 일시정지
                    delay(2000)
                    var msg = Message()
                    var bundle = Bundle()
                    count += 1
                    Log.d("hohohoho", "Thread")
                    bundle.putInt("Count", count % 500)
                    msg.data = bundle
                    Ad_handler.sendMessage(msg)
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onStart() {
        super.onStart()

    }

    override fun onResume() {
        super.onResume()

        CoroutineScope(Dispatchers.Main).launch {
            launch {
                Ad_start()
            }
            launch {
                Ad_Temp_stop()
                Ad_stop.cancel(null)

            }

        }
    }


    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()

        //코루틴을 이용해서 현재 레이아웃에서 포커스가 떠났을 때 자동으로 넘어가는 광고배너를 백그라운드에서 잠시 멈추게하는 코드
        CoroutineScope(Dispatchers.Main).launch { //Dispatchers.Main은 CoroutineScope을 Main UI Thread에서 동작시키도록 한다.
            launch {
                Ad_start()
            }
            launch {
                Ad_Temp_stop()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }








    var Ad_handler : Handler =object: Handler(){
        override fun handleMessage(msg: Message){
            var data=msg.data
            rootView.Ad_Current_Count.text=((count%Ad_All_Number)+1).toString()

            rootView.ViewPager.setCurrentItem(data.getInt("Count"))
        }
    }


}