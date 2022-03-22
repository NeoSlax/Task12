package com.example.task13

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task13.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), View.OnClickListener {
    private var adapter = StringAdapter()
    lateinit var str: OneString
    var index: Int = 1;
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcView.adapter = adapter
        binding.addButton.setOnClickListener {
            onClick()
        }


    }


    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private fun onClick() {

        val str = OneString("Новая строка $index")
        adapter.addString(str)
        index += 1
    }

    override fun onClick(p0: View?) {


        str = OneString("Новая строка $index")
        adapter.addString(str)
        index += 1
    }
}