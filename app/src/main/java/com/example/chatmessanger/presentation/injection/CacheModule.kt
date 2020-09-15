package com.example.chatmessanger.presentation.injection

import android.content.Context
import android.content.SharedPreferences
import com.example.chatmessanger.cache.AccountCacheImpl
import com.example.chatmessanger.cache.SharedPrefsManager
import com.example.chatmessanger.data.account.AccountCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideAccountCache(prefsManager: SharedPrefsManager): AccountCache = AccountCacheImpl(prefsManager)
}