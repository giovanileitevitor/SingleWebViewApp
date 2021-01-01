package br.applabbs.singlewebviewapp.di

import android.util.Log

class UncaughtExceptionHandler : Thread.UncaughtExceptionHandler {

    private var defaultUEH: Thread.UncaughtExceptionHandler? = null

    init {
        defaultUEH = Thread.getDefaultUncaughtExceptionHandler()
    }

    override fun uncaughtException(thread: Thread, ex: Throwable) {
        logAndReport(thread, ex)
        //cleanupBeforeExitingApp()

        //sharedPreferencesCrashRestore.setCrash()

        defaultUEH?.uncaughtException(thread, ex)
    }

    private fun logAndReport(thread: Thread, ex: Throwable) {
        val stackTrace: Array<StackTraceElement> = ex.stackTrace
        var traceString = ""

        for (trace in stackTrace) {
            traceString += "$trace\n "
        }

        //appEventHandler.onAppCrash(thread, ex)
        Log.d("application", "Passei por LogAndReport ${ex.message} / $traceString")
    }
}