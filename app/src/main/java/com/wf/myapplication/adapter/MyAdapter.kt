package com.wf.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wf.myapplication.R
import com.wf.myapplication.bean.NewsBean
import com.wf.myapplication.bean.T1348647909107
import kotlinx.android.synthetic.main.item_recycleview.view.*

class MyAdapter(var  list: MutableList<T1348647909107>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_recycleview,parent,false)

    return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        holder.itemView.title_text.setT
        holder.itemView.title_text.text = list[position].title
    }

    class MyViewHolder(item : View) : RecyclerView.ViewHolder(item)


}