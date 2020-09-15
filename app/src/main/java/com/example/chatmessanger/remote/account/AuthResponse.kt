package com.example.chatmessanger.remote.account

import com.example.chatmessanger.domain.account.AccountEntity
import com.example.chatmessanger.remote.core.BaseResponse

class AuthResponse (
    success: Int,
    message: String,
    val user: AccountEntity
) : BaseResponse(success, message)