package com.neppplus.todolistpractice_20220717.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.neppplus.todolistpractice_20220717.R
import com.neppplus.todolistpractice_20220717.datas.TodoData
import com.willy.ratingbar.ScaleRatingBar

class TodoListAdapter (
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<TodoData>
        ) : ArrayAdapter<TodoData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(resId, null)
        }

        val row = tempRow!!

        val data = mList[position]

        val ratingBar = row.findViewById<ScaleRatingBar>(R.id.todoRatingBar)
        val todoTitle = row.findViewById<TextView>(R.id.todoTitleTxt)

        ratingBar.rating = data.rating.toFloat()
        todoTitle.text = data.todoTitle

        return row
    }

}