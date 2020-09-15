package com.example.chatmessanger.presentation.injection

import com.example.chatmessanger.BuildConfig
import com.example.chatmessanger.data.account.AccountRemote
import com.example.chatmessanger.remote.account.AccountRemoteImpl
import com.example.chatmessanger.remote.core.Request
import com.example.chatmessanger.remote.service.ApiService
import com.example.chatmessanger.remote.service.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Singleton
    @Provides
    fun provideAccountRemote(request: Request, apiService: ApiService): AccountRemote {
        return AccountRemoteImpl(request, apiService)
    }
}