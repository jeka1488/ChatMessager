package com.example.chatmessanger.data.friends

import com.example.chatmessanger.data.account.AccountCache
import com.example.chatmessanger.domain.friends.FriendEntity
import com.example.chatmessanger.domain.friends.FriendsRepository
import com.example.chatmessanger.domain.type.Either
import com.example.chatmessanger.domain.type.Failure
import com.example.chatmessanger.domain.type.None
import com.example.chatmessanger.domain.type.flatMap

class FriendsRepositoryImpl(
    private val accountCache: AccountCache,
    private val friendsRemote: FriendsRemote
) : FriendsRepository {

    override fun getFriends(): Either<Failure, List<FriendEntity>> {
        return accountCache.getCurrentAccount()
            .flatMap { friendsRemote.getFriends(it.id, it.token) }
    }

    override fun getFriendRequests(): Either<Failure, List<FriendEntity>> {
        return accountCache.getCurrentAccount()
            .flatMap { friendsRemote.getFriendRequests(it.id, it.token) }
    }

    override fun approveFriendRequest(friendEntity: FriendEntity): Either<Failure, None> {
        return accountCache.getCurrentAccount()
            .flatMap { friendsRemote.approveFriendRequest(it.id, friendEntity.id, friendEntity.friendsId, it.token) }
    }

    override fun cancelFriendRequest(friendEntity: FriendEntity): Either<Failure, None> {
        return accountCache.getCurrentAccount()
            .flatMap { friendsRemote.cancelFriendRequest(it.id, friendEntity.id, friendEntity.friendsId, it.token) }
    }

    override fun addFriend(email: String): Either<Failure, None> {
        return accountCache.getCurrentAccount()
            .flatMap { friendsRemote.addFriend(email, it.id, it.token) }
    }

    override fun deleteFriend(friendEntity: FriendEntity): Either<Failure, None> {
        return accountCache.getCurrentAccount()
            .flatMap { friendsRemote.deleteFriend(it.id, friendEntity.id, friendEntity.friendsId, it.token) }
    }
}