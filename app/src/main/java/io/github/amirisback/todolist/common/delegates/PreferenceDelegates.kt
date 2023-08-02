package io.github.amirisback.todolist.common.delegates

import io.github.amirisback.todolist.common.callback.DataResponseCallback
import io.github.amirisback.todolist.common.callback.StateResponseCallback

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

interface PreferenceDelegates {

    fun savePrefFloat(key: String, value: Float)

    fun savePrefInt(key: String, value: Int)

    fun savePrefString(key: String, value: String)

    fun savePrefBoolean(key: String, value: Boolean)

    fun savePrefLong(key: String, value: Long)

    fun savePrefString(key: String, value: String, callback: StateResponseCallback)

    fun savePrefLong(key: String, value: Long, callback: StateResponseCallback)

    fun savePrefFloat(key: String, value: Float, callback: StateResponseCallback)

    fun savePrefInt(key: String, value: Int, callback: StateResponseCallback)

    fun savePrefBoolean(key: String, value: Boolean, callback: StateResponseCallback)

    fun deletePref(key: String)

    fun nukePref()

    fun loadPrefFloat(key: String): Float

    fun loadPrefFloat(key: String, defaultValue: Float): Float

    fun loadPrefString(key: String): String

    fun loadPrefString(key: String, defaultValue: String): String

    fun loadPrefInt(key: String): Int

    fun loadPrefInt(key: String, defaultValue: Int): Int

    fun loadPrefLong(key: String): Long

    fun loadPrefLong(key: String, defaultValue: Long): Long

    fun loadPrefBoolean(key: String): Boolean

    fun loadPrefBoolean(key: String, defaultValue: Boolean): Boolean

    fun loadPrefString(key: String, callback: DataResponseCallback<String>)

    fun loadPrefLong(key: String, callback: DataResponseCallback<Long>)

    fun loadPrefFloat(key: String, callback: DataResponseCallback<Float>)

    fun loadPrefInt(key: String, callback: DataResponseCallback<Int>)

    fun loadPrefBoolean(key: String, callback: DataResponseCallback<Boolean>)

}