package com.poc.network.home.data.repository

import com.poc.network.base.BaseRepository

interface HomeRepository : BaseRepository {

    fun <T> getComics(params: T? = null,callback: BaseRepository.OnCallBackRemoteRequest)
}