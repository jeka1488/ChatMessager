package com.example.chatmessanger.data.account

import com.example.chatmessanger.domain.account.AccountEntity
import com.example.chatmessanger.domain.type.Either
import com.example.chatmessanger.domain.type.Failure
import com.example.chatmessanger.domain.type.None

interface AccountRemote {
    fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None>

    fun login(email: String, password: String, token: String): Either<Failure, AccountEntity>

    fun updateToken(userId: Long, token: String, oldToken: String): Either<Failure, None>
}