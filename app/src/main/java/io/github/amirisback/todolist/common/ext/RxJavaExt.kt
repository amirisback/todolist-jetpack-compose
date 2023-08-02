package io.github.amirisback.todolist.common.ext

import io.github.amirisback.todolist.common.callback.DataResponseCallback
import io.github.amirisback.todolist.common.callback.LocalObserver
import io.github.amirisback.todolist.common.callback.StateResponseCallback
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
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

fun Completable.executeRoomDB(callback: StateResponseCallback) {
    callback.onShowProgress()
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            callback.onSuccess()
            callback.onHideProgress()
            callback.onFinish()
        }) {
            it.message?.let { it1 -> callback.onFailed(200, it1) }
            callback.onHideProgress()
            callback.onFinish()
        }
}

fun <T : Any> Single<T>.fetchRoomDB(
    callback: DataResponseCallback<T>,
    addCallbackSubscribe: (d: Disposable) -> Unit
) {
    subscribeOn(Schedulers.io())
        .doOnSubscribe {
            callback.onShowProgress()
        }
        .doAfterTerminate {
            callback.onHideProgress()
        }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(object : LocalObserver<T>() {

            override fun onLocalFinish() {
                callback.onFinish()
            }

            override fun onLocalFailure(code: Int, errorMessage: String) {
                callback.onFailed(code, errorMessage)
            }

            override fun onLocalSuccess(data: T) {
                callback.onSuccess(data)
            }

            override fun onLocalStartObserver(disposable: Disposable) {
                addCallbackSubscribe(disposable)
            }

        })
}

fun <T : Any> Observable<T>.fetchPreference(callback: DataResponseCallback<T>) {
    subscribeOn(Schedulers.io())
        .doOnSubscribe {
            callback.onShowProgress()
        }
        .doAfterTerminate {
            callback.onHideProgress()
        }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            callback.onSuccess(it)
            callback.onFinish()
        }, {
            it.message?.let { it1 -> callback.onFailed(200, it1) }
            callback.onFinish()
        })
}

fun Completable.executePreference(callback: StateResponseCallback) {
    callback.onShowProgress()
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            callback.onSuccess()
            callback.onHideProgress()
            callback.onFinish()
        }) {
            it.message?.let { it1 -> callback.onFailed(200, it1) }
            callback.onHideProgress()
            callback.onFinish()
        }
}

