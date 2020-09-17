package com.example.chatmessanger.remote.friends

import com.example.chatmessanger.domain.friends.FriendEntity
import com.example.chatmessanger.remote.core.BaseResponse

class GetFriendsResponse (
    success: Int,
    message: String,
    val friends: List<FriendEntity>
) : BaseResponse(success, message)