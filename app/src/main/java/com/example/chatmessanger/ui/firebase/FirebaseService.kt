package com.example.chatmessanger.ui.firebase

import android.util.Log
import com.example.chatmessanger.domain.account.UpdateToken
import com.example.chatmessanger.ui.App
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import javax.inject.Inject

class FirebaseService : FirebaseMessagingService() {

    @Inject
    lateinit var updateToken: UpdateToken

    override fun onCreate() {
        super.onCreate()
        App.appComponent.inject(this)
    }

    override fun onMessageReceived(p0: RemoteMessage) {

    }


    override fun onNewToken(token: String) {
        Log.e("fb token", ": $token")
    }
}