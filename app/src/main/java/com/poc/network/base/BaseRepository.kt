package com.poc.network.base

interface BaseRepository {
    interface OnCallBackRemoteRequest {
        fun <T> onSuccess(data: T)
        fun <E> onFailure(data: E)
    }
}