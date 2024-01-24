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
    val date:String
)
