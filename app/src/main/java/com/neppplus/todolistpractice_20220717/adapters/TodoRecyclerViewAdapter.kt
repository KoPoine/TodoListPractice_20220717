package com.neppplus.todolistpractice_20220717.adapters

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neppplus.todolistpractice_20220717.R
import com.neppplus.todolistpractice_20220717.datas.TodoData
import com.willy.ratingbar.ScaleRatingBar
import kotlinx.android.synthetic.main.todo_list_item.view.*

class TodoRecyclerViewAdapter(
    val mContext : Context,
    val mList : ArrayList<TodoData>
) : RecyclerView.Adapter<TodoRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun bind(item : TodoData) {
//            실제적으로 한칸의 xml(itemView > MyViewHolder의 생성자로 만든 view)과 한칸의 데이터(item: TodoData)를 연결
            val todoRatingBar = itemView.findViewById<ScaleRatingBar>(R.id.todoRatingBar)
            val todoTitleTxt = itemView.findViewById<TextView>(R.id.todoTitleTxt)
            val todoCb = itemView.findViewById<CheckBox>(R.id.todoCb)

            todoRatingBar.rating = item.rating.toFloat()
            todoTitleTxt.text = item.todoTitle
            todoCb.isChecked = item.isFinished

//            1) 체크 박스가 체크되어있다면 > 완료되었기에 TextView에 취소선 긋기
            if (item.isFinished) {
                todoTitleTxt.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }
            else {
                todoTitleTxt.paintFlags = 0
            }

//            2) 체크 박스가 클릭되었을때 (체크 박스 여부 변경 감지 이벤트) > TextView에 취소선 긋기
            todoCb.setOnCheckedChangeListener { compoundButton, isChecked ->
                if (isChecked) {
//                    체크 박스가 체크 되었을때의 로직
                    todoTitleTxt.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                }
                else {
//                    체크 박스가 체크 해제되었을때의 로직
                    todoTitleTxt.paintFlags = 0
                }
            }
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