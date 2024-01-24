package com.crestinfosystems_jinay.expancetracker.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Expanse::class],
    version = 2,
    exportSchema = false
)
abstract class ExpanseDatabase : RoomDatabase() {
    abstract fun expanseDao():ExpanseDAO
}