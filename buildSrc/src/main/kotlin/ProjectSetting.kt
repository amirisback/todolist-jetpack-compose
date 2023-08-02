/**
 * Created by faisalamir on 19/09/21
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.
 * All rights reserved
 *
 */

object ProjectSetting {

    // Project settings
    const val NAME_APP = "To Do List"

    // Version App
    const val VERSION_MAJOR = 1
    const val VERSION_MINOR = 0
    const val VERSION_PATCH = 0

    // ---------------------------------------------------------------------------------------------
    // Default Setting - Do Not Change
    // ---------------------------------------------------------------------------------------------

    const val PROJECT_MIN_SDK = 24
    const val PROJECT_COMPILE_SDK = 33
    const val PROJECT_TARGET_SDK = PROJECT_COMPILE_SDK

    // ---------------------------------------------------------------------------------------------

    const val PROJECT_NAME_SPACE = "io.github.amirisback.todolist"
    const val PROJECT_APP_ID = "io.github.amirisback.todolist"

    // ---------------------------------------------------------------------------------------------

    const val PROJECT_VERSION_CODE = (VERSION_MAJOR * 100) + (VERSION_MINOR * 10) + (VERSION_PATCH * 1)
    const val PROJECT_VERSION_NAME = "$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH"

    // ---------------------------------------------------------------------------------------------

    // Declaration apps name debug mode
    const val DEBUG_ATTRIBUTE = "DEV"
    const val NAME_APP_DEBUG = "$NAME_APP $DEBUG_ATTRIBUTE"

    // Constant Variable
    val NAME_APK = NAME_APP.lowercase().replace(" ", "-")
    val NAME_SETTING_LOWERCASE = NAME_APP.lowercase().replace(" ", "_")
    val NAME_SETTING_UPERCASE = NAME_APP.uppercase().replace(" ", "_")

}