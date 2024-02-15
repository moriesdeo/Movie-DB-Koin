package com.test.data.model.base

import org.json.JSONObject
import retrofit2.Response

/**
 * @author mories.deo
 * @date 25-Aug-2023
 */

object ErrorUtils {
    fun parseError(response: Response<*>): String {
        var bodyObj: JSONObject? = null
        var message: String

        try {
            val errorBody: String? = response.errorBody()?.string()
            if (!errorBody.isNullOrEmpty()) {
                bodyObj = JSONObject(errorBody)
                message = when {
                    bodyObj.has("error_description") -> bodyObj.getString("error_description")
                    bodyObj.has("message") -> bodyObj.getString("message")
                    bodyObj.has("error") -> bodyObj.getJSONObject("error").getString("message")
                    else -> "Unable to parse error"
                }
            } else message = "Unable to parse error"
        } catch (e: Exception) {
            e.printStackTrace()
            message = "Unable to parse error"
        }

        return message
    }
}