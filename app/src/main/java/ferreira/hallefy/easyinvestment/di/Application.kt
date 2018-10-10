package ferreira.hallefy.easyinvestment.di

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class Application : DaggerApplication() {
    lateinit var applicaton: Application

    override fun onCreate() {
        super.onCreate()
        applicaton = this
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerApplicationComponent.builder().application(this).build()
        appComponent.inject(this)

        return appComponent
    }


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    fun getContext(): Application {
        return applicaton
    }
}