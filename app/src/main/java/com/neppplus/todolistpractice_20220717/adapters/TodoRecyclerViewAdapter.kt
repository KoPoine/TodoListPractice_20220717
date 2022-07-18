package com.neppplus.todolistpractice_20220717.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neppplus.todolistpractice_20220717.R
import com.neppplus.todolistpractice_20220717.datas.TodoData

class TodoRecyclerViewAdapter(
    val mContext : Context,
    val mList : ArrayList<TodoData>
) : RecyclerView.Adapter<TodoRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun bind(item : TodoData) {
//            실제적으로 한칸의 xml(itemView > MyViewHolder의 생성자로 만든 view)과 한칸의 데이터(item: TodoData)를 연결

        }
    }

//    한 칸의 xml을 연결하는 부분
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.todo_list_item, parent, false)
        return MyViewHolder(row)
    }

//    ViewHolder(우리가 만든 inner class인 MyViewHolder)에 한 칸의 데이터를 연결해주는 함수
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }

//    총 몇 개의 아이템이 필요한가?
    override fun getItemCount(): Int {
        return mList.size
    }

}