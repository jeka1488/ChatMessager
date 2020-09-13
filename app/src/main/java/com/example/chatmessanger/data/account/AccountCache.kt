package com.example.chatmessanger.data.account

import com.example.chatmessanger.domain.type.Either
import com.example.chatmessanger.domain.type.None
import com.example.chatmessanger.domain.type.exception.Failure

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>
}