package com.poc.network.base

import retrofit2.Response

interface BaseNetworkTask {
    suspend fun <T> safeApiCall(
        request: Response<T>,
        callback: OnBaseNetworkCallBack,
        errorNetWorkNotAvailable: (() -> Unit)? = null,
    )

    fun verifyIfHasNetworkAvailable(): Boolean
}


interface OnBaseNetworkCallBack {
    fun <T> onSuccess(baseData: ResultTask.OnSuccess<T>)
    fun <F> onFailure(baseData: ResultTask.OnFailure<F>)
    fun onError()
}


sealed class ResultTask<out R> {
    data class OnSuccess<out T>(val data: T?) : ResultTask<T?>()
    data class OnFailure<out T>(val data: T?) : ResultTask<T?>()
    data class OnError(val exception: Exception) : ResultTask<Nothing>()
}