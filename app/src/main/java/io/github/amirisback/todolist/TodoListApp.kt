package io.github.amirisback.todolist

import android.app.Application
import android.content.Context
import io.github.amirisback.todolist.common.ext.APP_IS_DEBUG
import io.github.amirisback.todolist.di.repositoryModule
import io.github.amirisback.todolist.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

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

class TodoListApp: Application() {

    companion object {
        val TAG: String = TodoListApp::class.java.simpleName

        lateinit var instance: TodoListApp

        fun getContext(): Context = instance.applicationContext

    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TodoListApp)
            androidLogger(
                if (APP_IS_DEBUG) {
                    Level.DEBUG
                } else {
                    Level.ERROR
                }
            )
            setupKoinModule(this)
        }
        instance = this
    }

    private fun setupKoinModule(koinApplication: KoinApplication) {
        koinApplication.modules(listOf(repositoryModule, viewModelModule))
    }

}