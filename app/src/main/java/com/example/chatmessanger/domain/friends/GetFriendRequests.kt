package com.example.chatmessanger.domain.friends

import com.example.chatmessanger.domain.interactor.UseCase
import com.example.chatmessanger.domain.type.None
import javax.inject.Inject

class GetFriendRequests @Inject constructor(
    private val friendsRepository: FriendsRepository
) : UseCase<List<FriendEntity>, None>() {

    override suspend fun run(params: None) = friendsRepository.getFriendRequests()
}