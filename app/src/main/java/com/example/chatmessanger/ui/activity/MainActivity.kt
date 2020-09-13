package com.example.chatmessanger.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chatmessanger.R
import com.example.chatmessanger.cache.AccountCacheImpl
import com.example.chatmessanger.cache.SharedPrefsManager
import com.example.chatmessanger.data.account.AccountRepositoryImpl
import com.example.chatmessanger.domain.account.AccountRepository
import com.example.chatmessanger.domain.account.Register
import com.example.chatmessanger.remote.account.AccountRemoteImpl
import com.example.chatmessanger.remote.core.NetworkHandler
import com.example.chatmessanger.remote.core.Request
import com.example.chatmessanger.remote.service.ServiceFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)

        val accountCache = AccountCacheImpl(SharedPrefsManager(sharedPrefs))
        val accountRemote = AccountRemoteImpl(Request(NetworkHandler(this)), ServiceFactory.makeService(true))

        val accountRepository: AccountRepository = AccountRepositoryImpl(accountRemote, accountCache)

        accountCache.saveToken("12345")

        val register = Register(accountRepository)
        register(Register.Params("abcd@m.com", "abcd", "123")) {
            it.either({
                Toast.makeText(this, it.javaClass.simpleName, Toast.LENGTH_SHORT).show()
            }, {
                Toast.makeText(this, "Аккаунт создан", Toast.LENGTH_SHORT).show()
            })
        }
    }
}