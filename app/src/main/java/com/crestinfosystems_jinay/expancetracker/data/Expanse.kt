package com.crestinfosystems_jinay.expancetracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("expanse-table")
data class Expanse(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0,
    @ColumnInfo("title")
    val title:String,
    @ColumnInfo("desc")
    val des:String,
    @ColumnInfo("amount")
    val amount:Float,
    @ColumnInfo("date")
    val date:String,
    @ColumnInfo("category")
    val category: String
)
@Entity(tableName = "Wish-List")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "wishDesc")
    val desc: String = "",
    @ColumnInfo(name = "wishTitle")
    val title: String = "",
    @ColumnInfo(name = "isComplete")
    val isDone :Boolean = false
)
