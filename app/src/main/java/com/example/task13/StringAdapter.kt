package com.example.task13

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task13.databinding.StringPatternBinding

class StringAdapter:RecyclerView.Adapter<StringAdapter.StringHolder>() {
    val stringList = ArrayList<OneString>()
    class StringHolder(item:View):RecyclerView.ViewHolder(item){
        val binding = StringPatternBinding.bind(item)
        fun bind(string:OneString) = with(binding){
            textView.text = string.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.string_pattern, parent, false)
        return StringHolder(view)
    }

    override fun onBindViewHolder(holder: StringHolder, position: Int) {
        holder.bind(stringList[position])
    }

    override fun getItemCount(): Int {
        return stringList.size
    }

    fun addString(string:OneString){
        stringList.add(string)
        notifyDataSetChanged()
    }
}