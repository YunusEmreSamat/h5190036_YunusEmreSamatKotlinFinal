package com.h5190036.h5190036_yunusemresamat_kotlinfinal.util

import com.google.gson.Gson

object ObjectUtil {

    fun <T> objectToString(objectData: T): String {
        val gson = Gson()
        return gson.toJson(objectData)
    }

    inline fun <reified T> jsonStringToObject(jsonString: String): T {
        val gson = Gson()
        return gson.fromJson(jsonString, T::class.java)
    }

}