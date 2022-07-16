package com.poc.network.base

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import androidx.annotation.RequiresApi
import retrofit2.Response


class BaseNetworkTaskImpl(private val context: Context) : BaseNetworkTask {
    @RequiresApi(Build.VERSION_CODES.M)
    fun getNetWorkInfo(): NetworkInfo? {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        connectivityManager?.let { connectivityManager ->
            return connectivityManager.activeNetworkInfo
        } ?: run {
            return null
        }
    }

    override suspend fun <T> safeApiCall(
        request: Response<T>,
        callback: OnBaseNetworkCallBack,
        errorNetWorkNotAvailable: (() -> Unit)?
    ) {

        if (request.isSuccessful) {
            callback.onSuccess(ResultTask.OnSuccess(data = request.body()))
        } else {
            callback.onFailure(ResultTask.OnFailure(data = request.errorBody()))
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun verifyIfHasNetworkAvailable(): Boolean {
        getNetWorkInfo()?.let {
            return it.isConnected && it.isAvailable
        } ?: run {
            return false
        }
    }

}