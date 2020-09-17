package com.example.chatmessanger.domain.account

import com.example.chatmessanger.domain.interactor.UseCase
import com.example.chatmessanger.domain.type.Either
import com.example.chatmessanger.domain.type.Failure
import javax.inject.Inject

class EditAccount @Inject constructor(
    private val repository: AccountRepository
) : UseCase<AccountEntity, AccountEntity>() {

    override suspend fun run(params: AccountEntity): Either<Failure, AccountEntity> {
        return repository.editAccount(params)
    }
}