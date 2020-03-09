package com.fawwad.otakuwaza.application

import android.app.Application

class Otakuwaza : Application() {

    companion object {
        var instance: Otakuwaza? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}