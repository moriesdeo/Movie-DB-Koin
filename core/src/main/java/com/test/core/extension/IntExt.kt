package com.test.core.extension

import android.content.res.Resources
import java.text.DecimalFormat

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Int.convertToRupiah(): String {
    val decimalFormat = DecimalFormat("#,###")
    return if (this < 0) "" else "Rp ${decimalFormat.format(this).replace(",", ".")}"
}
