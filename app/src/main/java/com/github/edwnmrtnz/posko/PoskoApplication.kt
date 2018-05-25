package com.github.edwnmrtnz.posko

import android.app.Application
import com.github.edwnmrtnz.posko.data.retrofit.RetrofitHelper

class PoskoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        RetrofitHelper.newInstance().enableLogging(BuildConfig.DEBUG)
    }
}