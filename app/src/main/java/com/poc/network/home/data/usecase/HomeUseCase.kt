package com.poc.network.home.data.usecase

import com.poc.network.base.BaseRepository
import com.poc.network.home.data.model.ErrorDTO
import com.poc.network.home.data.model.ListMoviesDTO
import com.poc.network.home.data.model.MovieDTO
import com.poc.network.home.data.repository.HomeRepository

class HomeUseCase(private val homeRepository: HomeRepository) {


    fun <T> getMoviesComics(
        params: T? = null,
        onSuccess: (ListMoviesDTO) -> Unit,
        onFailure: (ErrorDTO) -> Unit,
    ) {
        homeRepository.getComics(
            params,
            callback = object : BaseRepository.OnCallBackRemoteRequest {
                override fun <T> onSuccess(data: T) {
                    onSuccess.invoke(data as ListMoviesDTO)
                }

                override fun <E> onFailure(data: E) {
                    onFailure.invoke(data as ErrorDTO)
                }

            })
    }
}