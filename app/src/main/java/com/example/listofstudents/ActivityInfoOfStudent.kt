package com.example.listofstudents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.listofstudents.data.Students
import com.example.listofstudents.repositories.StudentsRepository

class ActivityInfoOfStudent : AppCompatActivity() {
    lateinit var aName:TextView
    lateinit var aGroup:TextView
    lateinit var aHobbies:TextView
    lateinit var aPhoneNumber:TextView

    val repository= StudentsRepository.get()
    var students: MutableList<Students> = repository.getStudents()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_of_student)
        val numberOfStudent=intent.getIntExtra("Число_Студентов",0)
        aName=findViewById(R.id.tvName)
        aGroup=findViewById(R.id.tvGroup)
        aHobbies=findViewById(R.id.tvHobbies)
        aPhoneNumber=findViewById(R.id.tvPhoneNumber)
        aName.text=students[numberOfStudent].name
        aGroup.text=students[numberOfStudent].group
        aHobbies.text=students[numberOfStudent].hobbies
        aPhoneNumber.text=students[numberOfStudent].numberOfTelephone

    }
}