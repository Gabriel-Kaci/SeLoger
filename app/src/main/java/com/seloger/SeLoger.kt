package com.seloger

import android.app.Application
import com.seloger.framework.di.Component
import com.seloger.framework.di.DaggerComponent

class SeLoger : Application() {

    companion object {
        lateinit var dagger: Component
    }

    override fun onCreate() {
        super.onCreate()

        dagger = DaggerComponent.builder().build()
    }
}
