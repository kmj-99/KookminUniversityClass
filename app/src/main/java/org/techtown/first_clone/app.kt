package org.techtown.first_clone

import android.app.Application

class app : Application() {
    companion object{
        lateinit var instance:app
        private set
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
    }
}