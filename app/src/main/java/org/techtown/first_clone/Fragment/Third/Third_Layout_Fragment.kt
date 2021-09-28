package org.techtown.first_clone.Fragment.Third

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_third__layout_.view.*
import org.techtown.first_clone.R
import org.techtown.first_clone.databinding.FragmentThirdLayoutBinding


class Third_Layout_Fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView=inflater.inflate(R.layout.fragment_third__layout_, container, false)

        rootView.Back_Button.setOnClickListener{

        }
        return rootView
    }

}