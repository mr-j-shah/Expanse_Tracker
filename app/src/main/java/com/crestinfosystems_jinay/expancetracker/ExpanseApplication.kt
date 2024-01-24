package com.crestinfosystems_jinay.expancetracker

import android.app.Application

class ExpanseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}