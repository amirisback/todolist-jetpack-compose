package io.github.amirisback.todolist.repository.note

import io.github.amirisback.todolist.common.callback.DataResponseCallback
import io.github.amirisback.todolist.common.callback.StateResponseCallback
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

class NoteRepositoryImpl : NoteRepository {
    
    override fun insertNotes(data: List<Note>, callback: StateResponseCallback) {
        
    }

    override fun insertNote(data: Note, callback: StateResponseCallback) {
        
    }

    override fun searchNotes(query: String, callback: DataResponseCallback<List<Note>>) {
        
    }

    override fun nukeNotes(callback: StateResponseCallback) {
        
    }

}