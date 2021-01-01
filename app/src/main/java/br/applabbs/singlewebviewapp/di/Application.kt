package br.applabbs.singlewebviewapp.di

import androidx.multidex.MultiDexApplication
import br.applabbs.singlewebviewapp.di.AppComponent.getAllModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin

open class Application : MultiDexApplication(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initDI()
        initUEH()
    }

    private fun initUEH() {
        Thread.setDefaultUncaughtExceptionHandler(
            UncaughtExceptionHandler()
        )
    }

    private fun initDI() {
        startKoin {
            androidLogger(org.koin.core.logger.Level.ERROR)
            androidContext(this@Application)
            koin.loadModules(getAllModules())
            koin.createRootScope()
        }
    }
}