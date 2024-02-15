package com.test.core.extension

import android.app.Activity
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun EditText.hideKeyboard(){
    val inputMethodManager = this.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
}

fun EditText.afterTextChanged(
    afterTextChanged: (String) -> Unit,
) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(editable: Editable?) {
            removeTextChangedListener(this)
            afterTextChanged.invoke(editable.toString())
            addTextChangedListener(this)
        }
    })
}

fun String?.convertUTCDateToStringFormat(
    input: String = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
    output: String = "dd MMM yyyy . HH.mm",
    locale: Locale = Locale.getDefault(),
): String {
    val inputFormat = SimpleDateFormat(input, locale)
    val outputFormat = SimpleDateFormat(output, locale)
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")
    val date = try {
        inputFormat.parse(this ?: "")
    } catch (e: ParseException) {
        Date()
    }
    return outputFormat.format(date)
}
