package com.test.core.extension

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

/**
 * @author mories.deo
 * @date 19-Jul-2023
 */

fun View.visible(isShowing: Boolean) {
    visibility = when (isShowing) {
        true -> VISIBLE
        false -> GONE
    }
}

fun View.gone() {
    visibility = View.GONE
}
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun visibleMultipleViews(vararg views: View) {
    views.forEach {
        it.visible()
    }
}

fun goneMultipleViews(vararg views: View) {
    views.forEach {
        it.gone()
    }
}

