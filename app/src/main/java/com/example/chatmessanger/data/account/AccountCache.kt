package com.example.chatmessanger.data.account

import com.example.chatmessanger.domain.account.AccountEntity
import com.example.chatmessanger.domain.type.Either
import com.example.chatmessanger.domain.type.Failure
import com.example.chatmessanger.domain.type.None

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>

    fun logout(): Either<Failure, None>

    fun getCurrentAccount(): Either<Failure, AccountEntity>
    fun saveAccount(account: AccountEntity): Either<Failure, None>
}