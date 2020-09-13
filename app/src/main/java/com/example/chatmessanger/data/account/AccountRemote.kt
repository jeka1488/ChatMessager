package com.example.chatmessanger.data.account

import com.example.chatmessanger.domain.type.Either
import com.example.chatmessanger.domain.type.None
import com.example.chatmessanger.domain.type.exception.Failure

interface AccountRemote {
    fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None>
}