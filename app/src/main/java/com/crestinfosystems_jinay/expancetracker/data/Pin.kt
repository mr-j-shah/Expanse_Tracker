package com.crestinfosystems_jinay.expancetracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("pin-table")
data class Pin(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("pin")
    val pin:Int = 1234
)

