package com.crestinfosystems_jinay.expancetracker

import android.content.Context
import androidx.room.Room
import com.crestinfosystems_jinay.expancetracker.data.ExpanseDatabase
import com.crestinfosystems_jinay.expancetracker.data.ExpanseRepo

object Graph {
    lateinit var database: ExpanseDatabase
    val wishRepository by lazy{
           ExpanseRepo(expanseDAO = database.expanseDao())
    }
    fun provide(context: Context){
        database = Room.databaseBuilder(context,ExpanseDatabase::class.java,"expanse.db").build()
    }
}