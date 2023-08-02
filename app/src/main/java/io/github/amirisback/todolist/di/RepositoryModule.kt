package io.github.amirisback.todolist.di

import io.github.amirisback.todolist.data.local.ToDoDatabase
import io.github.amirisback.todolist.repository.note.NoteRepositoryImpl
import io.github.amirisback.todolist.repository.note.NoteSourceLocal
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

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

val repositoryModule = module {

    single {
        ToDoDatabase.newInstance(androidContext()).noteDao()
    }

    single {
        NoteSourceLocal(get())
    }

    single {
        NoteRepositoryImpl(get())
    }

}