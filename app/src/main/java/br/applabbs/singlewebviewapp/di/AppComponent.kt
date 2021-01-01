package br.applabbs.singlewebviewapp.di

import br.applabbs.singlewebviewapp.di.AppModules.serviceModules
import org.koin.core.module.Module

object AppComponent {

    fun getAllModules(): List<Module> =
        listOf(*getAppModules())

    private fun getAppModules(): Array<Module> {
        return arrayOf(serviceModules)
    }
}
