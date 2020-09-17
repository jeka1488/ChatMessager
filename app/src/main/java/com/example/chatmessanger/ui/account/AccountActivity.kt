package com.example.chatmessanger.ui.account

import android.os.Bundle
import com.example.chatmessanger.ui.App
import com.example.chatmessanger.ui.core.BaseActivity
import com.example.chatmessanger.ui.core.BaseFragment

class AccountActivity : BaseActivity() {
    override var fragment: BaseFragment = AccountFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}