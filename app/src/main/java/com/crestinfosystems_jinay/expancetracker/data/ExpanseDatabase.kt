package com.crestinfosystems_jinay.expancetracker.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Expanse::class, Wish::class],
    version = 3,
    exportSchema = false
)
abstract class ExpanseDatabase : RoomDatabase() {
    abstract fun expanseDao(): ExpanseDAO
}