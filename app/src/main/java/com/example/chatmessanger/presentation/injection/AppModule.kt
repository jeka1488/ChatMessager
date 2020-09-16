package com.example.chatmessanger.presentation.injection

import android.content.Context
import com.example.chatmessanger.data.account.AccountCache
import com.example.chatmessanger.data.account.AccountRemote
import com.example.chatmessanger.data.account.AccountRepositoryImpl
import com.example.chatmessanger.data.friends.FriendsRemote
import com.example.chatmessanger.data.friends.FriendsRepositoryImpl
import com.example.chatmessanger.domain.account.AccountRepository
import com.example.chatmessanger.domain.friends.FriendsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideAppContext(): Context = context

    @Provides
    @Singleton
    fun provideAccountRepository(remote: AccountRemote, cache: AccountCache): AccountRepository {
        return AccountRepositoryImpl(remote, cache)
    }

    @Provides
    @Singleton
    fun provideFriendsRepository(remote: FriendsRemote, accountCache: AccountCache): FriendsRepository {
        return FriendsRepositoryImpl(accountCache, remote)
    }
}