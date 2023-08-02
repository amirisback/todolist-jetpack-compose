package io.github.amirisback.todolist.repository.note

import io.github.amirisback.todolist.common.base.CoreRepositoryImpl
import io.github.amirisback.todolist.common.callback.DataResponseCallback
import io.github.amirisback.todolist.common.callback.StateResponseCallback
import io.github.amirisback.todolist.common.ext.executeRoomDB
import io.github.amirisback.todolist.common.ext.fetchRoomDB
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

class NoteSourceLocal(
    private val noteDao: NoteDao
) : CoreRepositoryImpl(), NoteRepository {

    override fun insertNote(data: Note, callback: StateResponseCallback) {
        noteDao.insert(data).executeRoomDB(callback)
    }

    override fun searchNotes(query: String, callback: DataResponseCallback<List<Note>>) {
        noteDao.getsByTitle(query).fetchRoomDB(callback) {
            addSubscribe(it)
        }
    }

    override fun nukeNotes(callback: StateResponseCallback) {
        noteDao.nukes().executeRoomDB(callback)
    }

}