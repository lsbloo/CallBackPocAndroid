package com.poc.network.home.data.di

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.poc.network.base.BaseNetworkTask
import com.poc.network.base.BaseNetworkTaskImpl
import com.poc.network.base.retrofit.RetrofitBuilder.provideRetrofitBuild
import com.poc.network.home.data.api.HomeAPI
import com.poc.network.home.data.repository.HomeRepository
import com.poc.network.home.data.repository.HomeRepositoryImp
import com.poc.network.home.data.usecase.HomeUseCase
import com.poc.network.home.presentation.HomeViewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object HomeSetup {

    private fun provideBaseTask(context: Context): BaseNetworkTask = BaseNetworkTaskImpl(context) as BaseNetworkTask

    private fun provideHomeAPI(retrofit: Retrofit): HomeAPI = retrofit.create(HomeAPI::class.java)

    private fun provideHomeRepository(
        baseNetworkTask: BaseNetworkTask,
        homeAPI: HomeAPI
    ): HomeRepository = HomeRepositoryImp(baseNetworkTask,homeAPI) as HomeRepository


    private fun provideHomeUseCase(homeRepository: HomeRepository): HomeUseCase =
        HomeUseCase(homeRepository)

    private fun provideHomeViewModel(
        homeUseCase: HomeUseCase,
    ): HomeViewModel = HomeViewModel(homeUseCase)

    fun setupHome() = module {
        single { provideHomeAPI(provideRetrofitBuild()) }
        single { provideBaseTask(get()) }
        single { provideHomeRepository(get(),get()) }
        single { provideHomeUseCase(get()) }
        single { provideHomeViewModel(get()) }
    }

}