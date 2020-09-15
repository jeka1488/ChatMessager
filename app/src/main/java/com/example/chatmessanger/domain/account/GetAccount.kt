package com.example.chatmessanger.domain.account

import com.example.chatmessanger.domain.interactor.UseCase
import com.example.chatmessanger.domain.type.None
import javax.inject.Inject

class GetAccount @Inject constructor(
    private val accountRepository: AccountRepository
): UseCase<AccountEntity, None>() {

    override suspend fun run(params: None) = accountRepository.getCurrentAccount()
}