package com.example.chatmessanger.remote.friends

import com.example.chatmessanger.domain.friends.FriendEntity
import com.example.chatmessanger.remote.core.BaseResponse
import com.google.gson.annotations.SerializedName

class GetFriendRequestsResponse (
    success: Int,
    message: String,
    @SerializedName("friend_requests")
    val friendsRequests: List<FriendEntity>
) : BaseResponse(success, message)