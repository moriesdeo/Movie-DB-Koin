package com.test.core.extension

import android.content.res.Resources
import android.graphics.Rect
import android.net.Uri
import android.os.Environment
import android.provider.OpenableColumns
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.permissionx.guolindev.PermissionX
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.Date


/**
 * @author mories.deo
 * @date 01-Aug-2023
 */

fun <T> Fragment.observeData(data: LiveData<T>, observer: Observer<T>) {
    data.observe(this, observer)
}

fun <T> Fragment.observeData(data: LiveData<T>, onChanged: (T?) -> Unit) {
    observeData(data, Observer { onChanged(it) })
}

fun Fragment.toast(msg: String?) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.getFile(uri: Uri): File? {
    return try {
        getRealPathFromURI(uri)?.let { File(it) }
    } catch (e: Exception) {
        return null
    }
}

fun Fragment.createImageFile(): File {
    val timeStamp = SimpleDateFormat.getDateTimeInstance().format(Date())
    val storageDir = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)

    return File.createTempFile(
        "JPEG_${timeStamp}_",
        ".jpg",
        storageDir
    )
}

fun Fragment.setPermissions(permissions: List<String>, onGranted: () -> Unit) {
    PermissionX.init(this)
        .permissions(permissions)
        .request { allGranted, _, deniedList ->
            if (allGranted) {
                onGranted.invoke()
            } else toast("These permissions are denied: $deniedList")
        }
}

fun Fragment.setPermissions(permission: String, onGranted: () -> Unit) {
    PermissionX.init(this)
        .permissions(permission)
        .request { allGranted, _, deniedList ->
            if (allGranted) {
                onGranted.invoke()
            } else toast("These permissions are denied: $deniedList")
        }
}

fun Fragment.getMimeType(uri: Uri): String? {
    val cR = context!!.contentResolver
    return cR.getType(uri)
}

fun Fragment.getRealPathFromURI(uri: Uri): String? {
    val returnCursor = requireContext().contentResolver.query(uri, null, null, null, null)
    val nameIndex =  returnCursor!!.getColumnIndex(OpenableColumns.DISPLAY_NAME)
    val sizeIndex = returnCursor.getColumnIndex(OpenableColumns.SIZE)
    returnCursor.moveToFirst()
    val name = returnCursor.getString(nameIndex)
    val size = returnCursor.getLong(sizeIndex).toString()
    val file = File(requireContext().filesDir, name)
    try {
        val inputStream: InputStream? = requireContext().contentResolver.openInputStream(uri)
        val outputStream = FileOutputStream(file)
        var read = 0
        val maxBufferSize = 1 * 1024 * 1024
        val bytesAvailable: Int = inputStream?.available() ?: 0
        //int bufferSize = 1024;
        val bufferSize = Math.min(bytesAvailable, maxBufferSize)
        val buffers = ByteArray(bufferSize)
        while (inputStream?.read(buffers).also {
                if (it != null) {
                    read = it
                }
            } != -1) {
            outputStream.write(buffers, 0, read)
        }
        //Log.e("File Size", "Size " + file.length())
        inputStream?.close()
        outputStream.close()
        //Log.e("File Path", "Path " + file.path)

    } catch (e: java.lang.Exception) {
        //Log.e("Exception", e.message!!)
    }
    return file.path
}

fun DialogFragment.setFullscreen() {
    dialog?.let {
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        it.window?.setLayout(width, height)
    }
}

fun DialogFragment.setWidthPercentFullHeight(percentage: Int) {
    val percent = percentage.toFloat() / 100
    val dm = Resources.getSystem().displayMetrics
    val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
    val percentWidth = rect.width() * percent
    dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.MATCH_PARENT)
}


