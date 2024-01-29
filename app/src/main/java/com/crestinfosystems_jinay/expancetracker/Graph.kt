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
    val migration_1_2 = object : Migration(3, 4) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Add SQL commands for migrating from version 1 to version 2
            // For example, alter table, add new table, etc.
            database.execSQL("ALTER TABLE \"expanse-table\" ADD COLUMN mode TEXT NOT NULL DEFAULT 'Cash'")
        }
    }
}