package com.crestinfosystems_jinay.expancetracker

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.crestinfosystems_jinay.expancetracker.data.ExpanseDatabase
import com.crestinfosystems_jinay.expancetracker.data.ExpanseRepo

object Graph {
    lateinit var database: ExpanseDatabase
    val wishRepository by lazy{
           ExpanseRepo(expanseDAO = database.expanseDao())
    }
    fun provide(context: Context){
        database = Room.databaseBuilder(context,ExpanseDatabase::class.java,"expanse.db").addMigrations(migration_1_2).build()
    }
    val migration_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {

            database.execSQL("ALTER TABLE \"expanse-table\" ADD COLUMN category VARCHAR(100) NOT NULL")
        }
    }
}