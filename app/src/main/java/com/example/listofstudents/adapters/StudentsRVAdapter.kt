package com.example.listofstudents.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listofstudents.R
import com.example.listofstudents.data.Students

class StudentsRVAdapter(context: Context?, val students : MutableList<Students>):
    RecyclerView.Adapter<StudentsRVAdapter.StudentsViewHolder?>() {
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    private var iClickListener: ItemClickListener? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        val view: View = layoutInflater.inflate(R.layout.list_student, parent, false)
        return StudentsViewHolder(view)
    }

    override fun getItemCount(): Int = students.size

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        val item = students[position]
        holder.nameTextView.text = item.name
        holder.groupTextView.text = item.group
    }

    inner class StudentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var nameTextView: TextView = itemView.findViewById(R.id.tvName)
        var groupTextView: TextView = itemView.findViewById(R.id.tvGroup)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            iClickListener?.onItemClick(view,adapterPosition)
        }
    }

    fun setClickListener(itemClickListener:ItemClickListener){
        iClickListener=itemClickListener
    }

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}