package com.poc.network.home.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.poc.network.home.data.model.ListMoviesDTO
import com.poc.network.home.data.usecase.HomeUseCase

class HomeViewModel(private val homeUseCase: HomeUseCase) {

    private val mutableLiveDataMoviesPopular: MutableLiveData<ListMoviesDTO> =
        MutableLiveData<ListMoviesDTO>()
    var liveDataMoviesPopular: LiveData<ListMoviesDTO> = mutableLiveDataMoviesPopular

    fun getMoviesComic() {
        homeUseCase.getMoviesComics(
            params = null,
            onSuccess = {
                mutableLiveDataMoviesPopular.postValue(it)
            }, onFailure = {

            })
    }
}