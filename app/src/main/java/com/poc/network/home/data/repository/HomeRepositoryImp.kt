package com.poc.network.home.data.repository

import com.poc.network.base.BaseNetworkTask
import com.poc.network.base.BaseRepository
import com.poc.network.base.OnBaseNetworkCallBack
import com.poc.network.base.ResultTask
import com.poc.network.base.retrofit.RetrofitBuilder
import com.poc.network.home.data.api.HomeAPI
import com.poc.network.home.data.model.MovieDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeRepositoryImp(private val baseNetworkTask: BaseNetworkTask, private val homeAPI: HomeAPI) : HomeRepository {


    override fun <T> getComics(params: T?, callback: BaseRepository.OnCallBackRemoteRequest) {
        CoroutineScope(Dispatchers.IO).launch {
            if (baseNetworkTask.verifyIfHasNetworkAvailable()) {
                baseNetworkTask.safeApiCall(
                    request = homeAPI.getMoviesPopular(RetrofitBuilder.KEY,1),
                    callback = object : OnBaseNetworkCallBack {
                        override fun <T> onSuccess(baseData: ResultTask.OnSuccess<T>) {
                            callback.onSuccess(baseData.data)
                        }

                        override fun <F> onFailure(baseData: ResultTask.OnFailure<F>) {
                            callback.onFailure(baseData.data)
                        }

                        override fun onError() {

                        }
                    })
            } else {

            }
        }
    }


}