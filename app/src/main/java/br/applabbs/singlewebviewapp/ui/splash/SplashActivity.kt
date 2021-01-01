package br.applabbs.singlewebviewapp.ui.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import br.applabbs.singlewebviewapp.SelectorActivity
import br.applabbs.singlewebviewapp.utis.PermissionUtils
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity: Activity() {

    private val PERMISSION_GLOBAL_CODE = 204
    private val viewModel: SplashViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verifyAndInitialize()
    }

    private fun verifyAndInitialize(){
        if(PermissionUtils.verifyPermissions(this, PERMISSION_GLOBAL_CODE)){
            initializeComponents()
        }
    }

    private fun initializeComponents(){
        if(viewModel.isOnline(this)){
            val intent = Intent(this, SelectorActivity::class.java)
            startActivity(intent)
            finish()
        }else {
            Toast.makeText(this, "Connection not available", Toast.LENGTH_SHORT).show()
        }
    }

//    private fun isOnline(): Boolean{
//        var result = false
//        val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
//
//        cm?.run {
//            cm.getNetworkCapabilities(cm.activeNetwork)?.run {
//                if (hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
//                    result = true
//                } else if (hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
//                    result = true
//                }
//            }
//        }
//
//        return result
//    }

}