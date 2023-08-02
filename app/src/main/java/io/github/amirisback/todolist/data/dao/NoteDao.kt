package io.github.amirisback.todolist.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.amirisback.todolist.model.Note
import io.github.amirisback.todolist.util.Constant
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

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

@Dao
interface NoteDao {

    @Query("SELECT * FROM ${Constant.RoomDatabase.TABLE_NOTE}")
    fun gets(): Single<List<Note>>

    @Query("DELETE FROM ${Constant.RoomDatabase.TABLE_NOTE}")
    fun nukes(): Completable

    @Query("SELECT * FROM ${Constant.RoomDatabase.TABLE_NOTE} WHERE title LIKE '%' || :search || '%' ORDER BY id DESC")
    fun getsByTitle(search: String): Single<List<Note>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(article: Note): Completable

}