package com.example.chatmessanger.domain.account

import com.example.chatmessanger.domain.interactor.UseCase
import com.example.chatmessanger.domain.type.None
import com.example.chatmessanger.domain.type.Either
import com.example.chatmessanger.domain.type.Failure
import javax.inject.Inject

class Register @Inject constructor(
    private val repository: AccountRepository): UseCase<None, Register.Params>(){
        override suspend fun run(params: Params): Either<Failure, None> {
            return repository.register(params.email, params.name, params.password)
    }

    data class Params(val email: String, val name: String, val password: String)
}