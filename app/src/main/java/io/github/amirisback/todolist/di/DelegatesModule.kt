package io.github.amirisback.todolist.di

import io.github.amirisback.todolist.common.delegates.PreferenceDelegatesImpl
import io.github.amirisback.todolist.common.ext.APP_PREF_NAME
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

val delegateModule = module {

    single {
        PreferenceDelegatesImpl(androidContext(), APP_PREF_NAME)
    }

}