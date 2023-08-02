package io.github.amirisback.todolist.common.callback

import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import java.net.SocketTimeoutException
import java.net.UnknownHostException

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

abstract class LocalObserver<M : Any> : SingleObserver<M> {

    companion object {
        val TAG: String = LocalObserver::class.java.simpleName
    }

    abstract fun onLocalFinish()
    abstract fun onLocalFailure(code: Int, errorMessage: String)
    abstract fun onLocalSuccess(data: M)
    abstract fun onLocalStartObserver(disposable: Disposable)

    override fun onSuccess(t: M) {
        onLocalSuccess(t)
        onLocalFinish()
    }

    override fun onSubscribe(d: Disposable) {
        onLocalStartObserver(d)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        when (e) {

            is UnknownHostException -> onLocalFailure(
                -1,
                "Telah terjadi kesalahan ketika koneksi ke server: ${e.message}"
            )

            is SocketTimeoutException -> onLocalFailure(
                -1,
                "Telah terjadi kesalahan ketika koneksi ke server: ${e.message}"
            )

            else -> onLocalFailure(-1, e.message ?: "Unknown error occured")
        }
        onLocalFinish()
    }
}