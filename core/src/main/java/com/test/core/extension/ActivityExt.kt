package com.test.core.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * @author mories.deo
 * @date 01-Aug-2023
 */

fun <T> AppCompatActivity.observeData(data: LiveData<T>, observer: Observer<T>) {
    data.observe(this, observer)
}

fun <T> AppCompatActivity.observeData(data: LiveData<T>, onChanged: (T?) -> Unit) {
    observeData(data, Observer { onChanged(it) })
}
