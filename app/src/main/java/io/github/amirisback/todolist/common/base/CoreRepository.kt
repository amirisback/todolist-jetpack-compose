package io.github.amirisback.todolist.common.base

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

interface CoreRepository {

    fun onClearDisposables()

    fun addSubscribe(disposable: Disposable)

}