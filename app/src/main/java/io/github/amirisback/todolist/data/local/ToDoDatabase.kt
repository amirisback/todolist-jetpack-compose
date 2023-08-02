package io.github.amirisback.todolist.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.amirisback.todolist.common.ext.APP_IS_DEBUG
import io.github.amirisback.todolist.common.ext.APP_ROOM_DB
import io.github.amirisback.todolist.data.dao.NoteDao
import io.github.amirisback.todolist.model.Note

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

@Database(
    entities = [
        (Note::class)
    ], version = 1,
    exportSchema = true
)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {

        fun newInstance(context: Context): ToDoDatabase {
            return buildDatabase(context)
        }

        private fun buildDatabase(context: Context): ToDoDatabase {
            return if (APP_IS_DEBUG) {
                Room.databaseBuilder(context, ToDoDatabase::class.java, APP_ROOM_DB)
                    .fallbackToDestructiveMigration() // FOR DEVELOPMENT ONLY !!!!
                    .build()
            } else {
                Room.databaseBuilder(context, ToDoDatabase::class.java, APP_ROOM_DB)
                    .build()
            }
        }

    }
}