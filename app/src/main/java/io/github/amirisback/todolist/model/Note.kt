package io.github.amirisback.todolist.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.amirisback.todolist.util.Constant

/**
 * Created by Amir on 08/02/23
 * todolist Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2023 FrogoBox Inc.
 * All rights reserved
 *
 */

@Keep
@Entity(tableName = Constant.RoomDatabase.TABLE_NOTE)
data class Note(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constant.RoomDatabase.ATTR_TABLE_ID)
    var table_id: Int = 0,

    @ColumnInfo(name = Constant.RoomDatabase.ATTR_ID)
    val id: Int,

    @ColumnInfo(name = Constant.RoomDatabase.ATTR_TITLE)
    val title: String,

    @ColumnInfo(name = Constant.RoomDatabase.ATTR_DESCRIPTION)
    val description: String,

    @ColumnInfo(name = Constant.RoomDatabase.ATTR_DATE)
    val date: String,

    @ColumnInfo(name = Constant.RoomDatabase.ATTR_TIME)
    val time: String

)