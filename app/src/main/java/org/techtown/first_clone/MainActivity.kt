package org.techtown.first_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.techtown.first_clone.Fragment.*
import org.techtown.first_clone.Fragment.Second.Second_Layout_Fragment
import org.techtown.first_clone.Fragment.Third.Third_Layout_Fragment
import org.techtown.first_clone.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val Pop_Up_Text="개!"
    private val random = Random()
    private var num:Int?=0


    private var count=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setMajorFragment(First_Layout_Fragment())



    }


    override fun onStart() {
        super.onStart()
        num = random.nextInt(60)

        binding.PopUpTextView2.text="${num}분 내 도착하는 맛집"
    }


    override fun onResume() {
        super.onResume()


        binding.BottomBar.apply{setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.Home_Item->{
                    setMajorFragment(First_Layout_Fragment())
                }
                R.id.Chat_Item->{
                    setMajorFragment(Second_Layout_Fragment())
                }
                R.id.Heart_Item->{
                    setMajorFragment(Third_Layout_Fragment())
                }
                R.id.Bills_Item->{
                    setSubFragment(Fourth_Layout_Fragment())
                }
                R.id.Profile_Item->{
                    setSubFragment(Fifth_Layout_Fragment())
                }
                else->{
                    null
                }
            }
            true
        }
        }

        binding.ClosePopUp.setOnClickListener{
            binding.PopUpLayout.removeAllViews()
        }
    }



    override fun onRestart() {
        super.onRestart()
        binding.PopUpTextView3.text= " $num$Pop_Up_Text"

    }

    override fun onPause() {
        super.onPause()
        num = random.nextInt(1000)
    }

    override fun onStop() {
        super.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"앱이 종료되었습니다.",Toast.LENGTH_LONG).show()
    }


    fun setMajorFragment(target_fragment: Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        if(sub_number){
            Log.d("BottomView","setMajorFragment - true")
            binding.subLayout.removeAllViews()
            binding.subLayout.visibility= View.INVISIBLE
            binding.majorLayout.setBackgroundColor(resources.getColor(R.color.white))

            sub_number=false
        }
        transaction.replace(R.id.major_layout, target_fragment)
        transaction.commit()

    }
    fun setSubFragment(target_fragment:Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        if(sub_number){
            Log.d("BottomView","setSubFragment - true")
            binding.subLayout.removeAllViews()
            binding.subLayout.visibility= View.INVISIBLE
            binding.majorLayout.setBackgroundColor(resources.getColor(R.color.white))
            sub_number=false
        }else{
            Log.d("BottomView","setSubFragment - false")
            transaction.replace(R.id.sub_layout,target_fragment)
            transaction.commit()
            binding.subLayout.visibility= View.VISIBLE
            binding.majorLayout.setBackgroundColor(resources.getColor(R.color.transparent))
            sub_number=true
        }
    }


    companion object{
        var sub_number:Boolean=false
    }


}