package com.example.chatmessanger.ui

import android.app.Application
import com.example.chatmessanger.presentation.injection.AppModule
import com.example.chatmessanger.presentation.injection.CacheModule
import com.example.chatmessanger.presentation.injection.RemoteModule
import com.example.chatmessanger.presentation.injection.ViewModelModule
import com.example.chatmessanger.ui.activity.RegisterActivity
import com.example.chatmessanger.ui.fragment.RegisterFragment
import com.example.chatmessanger.ui.service.FirebaseService
import dagger.Component
import javax.inject.Singleton

class App: Application() {
    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    fun initAppComponent(){
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {

    //activities
    fun inject(activity: RegisterActivity)

    //fragments
    fun inject(fragment: RegisterFragment)

    //services
    fun inject(service: FirebaseService)

}