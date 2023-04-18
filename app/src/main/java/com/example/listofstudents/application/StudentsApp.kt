package com.example.listofstudents.application

import android.app.Application
import com.example.listofstudents.repositories.StudentsRepository

class StudentsApp:Application() {
    override fun onCreate() {
        super.onCreate()
        StudentsRepository.initialize()
    }
}