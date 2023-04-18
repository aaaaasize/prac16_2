package com.example.listofstudents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listofstudents.adapters.StudentsRVAdapter
import com.example.listofstudents.data.Students
import com.example.listofstudents.repositories.StudentsRepository

class MainActivity : AppCompatActivity() {
    lateinit var aStudents: RecyclerView

    private val repository= StudentsRepository.get()
    var students: MutableList<Students> = repository.getStudents()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter= StudentsRVAdapter(this,students)
        aStudents=findViewById(R.id.rvStudents)
        aStudents.adapter=adapter
        aStudents.layoutManager=LinearLayoutManager(this)
        val rvListener = object: StudentsRVAdapter.ItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity,ActivityInfoOfStudent::class.java)
                intent.putExtra("Число_Студентов",position)
                startActivity(intent)
            }
        }
        adapter.setClickListener(rvListener)

    }
}