package com.example.chatmessanger.domain.account

import com.example.chatmessanger.domain.interactor.UseCase
import com.example.chatmessanger.domain.type.None
import javax.inject.Inject

class UpdateToken @Inject constructor(
    private val accountRepository: AccountRepository) : UseCase<None, UpdateToken.Params>() {

    override suspend fun run(params: Params) = accountRepository.updateAccountToken(params.token)

    data class Params(val token: String)
}