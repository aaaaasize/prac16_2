package com.example.listofstudents.repositories

import com.example.listofstudents.data.Students

class StudentsRepository private constructor() {
    private var students: MutableList<Students> = createStudents()


    companion object {
        private var INSTANSE: StudentsRepository? = null

        fun initialize() {
            if (INSTANSE == null) INSTANSE = StudentsRepository()
        }

        fun get(): StudentsRepository {
            return INSTANSE ?: throw IllegalAccessException("Repository should be initialized!")
        }
    }

    private fun createStudents(): MutableList<Students> {
        val studentsList: MutableList<Students> = mutableListOf()
        studentsList.run {
            studentsList.add(Students("Цыревникова Анастасия Владимировна", "ПР-23", "увлекается музыкой", "8-982-618-99-56"))
            studentsList.add(Students("Пудова Ксения Сергеевна", "ПР-23", "увлекается кроссовками", "8-919-364-80-38"))
            studentsList.add(Students("Пасечникова Алина Фроловна", "ПР-23", "увлекается рисованием", "8-922-695-80-40"))
            studentsList.add(Students("Михайловна Анастасия Олеговна", "ПР-23", "увлекается прогулками по городу", "8-902-448-11-25"))
            studentsList.add(Students("Харитонов Максим Олегович", "ПР-23", "увлекается аниме", "8-996-171-74-27"))
            studentsList.add(Students("Гагаринов Лев Юрьевич", "ПР-23", "увлекается играми", "8-912-324-32-44"))
            studentsList.add(Students("Клестов Вячеслав Александрович", "ПР-23", "увлекается девочками", "8-999-656-41-86"))
            studentsList.add(Students("Комаров Иван Алексеевич", "ПР-23", "увлекается играми", "8-912-040-35-68"))
            studentsList.add(Students("Бабинов Никита Андреевич", "ПР-23", "увлекается машинами", "8-982-628-39-59"))
            studentsList.add(Students("Шуматбаев Михаил Русланович", "ПР-23", "увлекается спортом", "8-932-429-65-74"))
        }
        return studentsList
    }

    fun getStudents(): MutableList<Students> {
        return students
    }
}