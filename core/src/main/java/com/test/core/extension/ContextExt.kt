package com.test.core.extension

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.datastore.preferences.preferencesDataStore
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

/**
 * @author mories.deo
 * @date 26-Jul-2023
 */

val Context.dataStore by preferencesDataStore(
    name = "com.test.core"
)

fun Context.toast(msg: String?) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.getRealPath(uri: Uri): String? {
    var path = getPathFromLocalUri(uri)
    if (path == null) {
        path = getPathFromRemoteUri(uri)
    }
    return path
}

private fun getPathFromLocalUri(uri: Uri): String? {
    // DocumentProvider
    if ("file".equals(uri.scheme!!, ignoreCase = true)) {
        return uri.path
    }
    return null
}

private fun Context.getPathFromRemoteUri(uri: Uri): String? {
    // The code below is why Java now has try-with-resources and the Files utility.
    var file: File? = null
    var inputStream: InputStream? = null
    var outputStream: OutputStream? = null
    var success = false
    try {
        val extension = FileUtil.getImageExtension(uri)
        inputStream = this.contentResolver.openInputStream(uri)
        file = FileUtil.getImageFile(this.cacheDir, extension)
        if (file == null) return null
        outputStream = FileOutputStream(file)
        if (inputStream != null) {
            inputStream.copyTo(outputStream, bufferSize = 4 * 1024)
            success = true
        }
    } catch (ignored: IOException) {
    } finally {
        try {
            inputStream?.close()
        } catch (ignored: IOException) {
        }

        try {
            outputStream?.close()
        } catch (ignored: IOException) {
            // If closing the output stream fails, we cannot be sure that the
            // target file was written in full. Flushing the stream merely moves
            // the bytes into the OS, not necessarily to the file.
            success = false
        }
    }
    return if (success) file!!.path else null
}
