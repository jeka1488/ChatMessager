package com.example.chatmessanger.domain.account

import com.example.chatmessanger.domain.interactor.UseCase
import com.example.chatmessanger.domain.type.Either
import com.example.chatmessanger.domain.type.Failure
import com.example.chatmessanger.domain.type.None
import javax.inject.Inject

class Logout @Inject constructor(
    private val accountRepository: AccountRepository
): UseCase<None, None>() {
    override suspend fun run(params: None): Either<Failure, None> = accountRepository.logout()
}