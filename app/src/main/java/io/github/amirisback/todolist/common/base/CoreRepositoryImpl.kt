package io.github.amirisback.todolist.common.base

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

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

abstract class CoreRepositoryImpl : CoreRepository {

    companion object {
        const val TIME_OUT_LOAD_SERVER: Long = 10
    }

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    override fun onClearDisposables() {
        compositeDisposable.clear()
    }

    override fun addSubscribe(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

}