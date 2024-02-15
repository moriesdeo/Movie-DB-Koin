package com.test.data.extensions

import com.google.gson.Gson
import java.lang.reflect.Type

object ValueExt {
    /**
     * Setting null Int value to by default is 0
     * */
    fun Int?.orZero(): Int = this ?: 0

    /**
     * Setting null Double value to by default is 0.0
     * */
    fun Double?.orZero(): Double = this ?: 0.0

    /**
     * Setting null Float value to by default is 0F
     * */
    fun Float?.orZero(): Float = this ?: 0F

    /**
     * Setting null Long value to by default is 0L
     * */
    fun Long?.orZero(): Long = this ?: 0L

    /**
     * Setting null boolean value to by default is false
     * */
    fun Boolean?.orFalse(): Boolean = this ?: false

    fun Boolean?.orTrue(): Boolean = this ?: true

    fun <T> String.mapJsonToObject(cls: Class<T>): T? {
        return try {
            Gson().fromJson(this, cls)
        } catch (ex: Exception) {
            null
        }
    }

    fun <T> String.mapJsonToList(type: Type): T? {
        return try {
            Gson().fromJson<T>(this, type)
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
    }
}