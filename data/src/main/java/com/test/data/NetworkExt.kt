package com.test.data

import com.test.core.data.Resource
import com.test.data.model.base.ErrorUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException

/**
 * @author mories.deo
 * @date 28-Jul-2023
 */

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T?
): Resource<T> {
    return withContext(dispatcher) {
        try {
            Resource.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    val code = throwable.code()
                    val errorBody = throwable.response()
                    errorBody?.let {
                        Resource.Error(Throwable(ErrorUtils.parseError(it)))
                    } ?: Resource.Error(Throwable("Failed in parsing error"))
                }

                else -> Resource.Error(throwable)
            }
        }
    }
}
