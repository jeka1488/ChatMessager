package com.example.chatmessanger.cache

import com.example.chatmessanger.data.account.AccountCache
import com.example.chatmessanger.domain.type.Either
import com.example.chatmessanger.domain.type.None
import com.example.chatmessanger.domain.type.exception.Failure
import javax.inject.Inject

class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager) : AccountCache {

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token)
    }

    override fun getToken(): Either<Failure, String> {
        return prefsManager.getToken()
    }
}