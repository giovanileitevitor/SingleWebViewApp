package br.applabbs.singlewebviewapp

import android.net.ConnectivityManager
import org.koin.core.KoinComponent
import androidx.multidex.MultiDexApplication

open class Application : MultiDexApplication(), KoinComponent {

    override fun onCreate(){
        super.onCreate()
        initDI()
        initUEH()
    }

    private fun initDI(){}

    private fun initUEH(){}

}