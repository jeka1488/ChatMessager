package com.example.chatmessanger.ui

import android.app.Application
import com.example.chatmessanger.presentation.injection.AppModule
import com.example.chatmessanger.presentation.injection.CacheModule
import com.example.chatmessanger.presentation.injection.RemoteModule
import com.example.chatmessanger.presentation.injection.ViewModelModule
import com.example.chatmessanger.ui.core.navigation.RouteActivity
import com.example.chatmessanger.ui.firebase.FirebaseService
import com.example.chatmessanger.ui.friends.FriendRequestsFragment
import com.example.chatmessanger.ui.friends.FriendsFragment
import com.example.chatmessanger.ui.home.ChatsFragment
import com.example.chatmessanger.ui.home.HomeActivity
import com.example.chatmessanger.ui.login.LoginFragment
import com.example.chatmessanger.ui.register.RegisterActivity
import com.example.chatmessanger.ui.register.RegisterFragment
import dagger.Component
import javax.inject.Singleton

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {

    //activities
    fun inject(activity: RegisterActivity)

    fun inject(activity: RouteActivity)
    fun inject(activity: HomeActivity)

    //fragments
    fun inject(fragment: RegisterFragment)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: ChatsFragment)
    fun inject(fragment: FriendsFragment)
    fun inject(fragment: FriendRequestsFragment)

    //services
    fun inject(service: FirebaseService)
}