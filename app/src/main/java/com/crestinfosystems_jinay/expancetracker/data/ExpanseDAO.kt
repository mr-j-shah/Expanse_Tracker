package com.crestinfosystems_jinay.expancetracker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ExpanseDAO{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addExpanse(expanseEntity:Expanse)

    // Loads all wishes from Table
    @Query("Select * FROM `expanse-table`")
    abstract fun getAllExpanse() : Flow<List<Expanse>>

    @Delete()
    abstract suspend fun deleteExpanse(wishEntity: Expanse)

    @Update
    abstract suspend fun updateAExpanse(wishEntity: Expanse)

    @Query("Select * FROM `expanse-table` where id=:id")
    abstract fun getAExpanseById(id:Long): Flow<Expanse>

    @Query("DELETE FROM `expanse-table`")
    abstract suspend fun deleteAll()
}