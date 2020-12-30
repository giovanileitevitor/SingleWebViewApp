package br.applabbs.singlewebviewapp.utis

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import kotlin.collections.ArrayList


class PermissionUtils {

    companion object{

        private fun hasPermission(activity: Activity, permission: String) : Boolean{
            return ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED
        }

        private fun hasPermission(context: Context, permission: String) : Boolean {
            return ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
        }

        fun verifyPermissions(activity: Activity, requestCode: Int) : Boolean {

            var permissions: ArrayList<String> = ArrayList()

            if(!hasPermission(activity, Manifest.permission.CAMERA)){
                permissions.add(Manifest.permission.CAMERA)
            }

            if(!hasPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION))
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION)

            /*
            Added all permissions conditions here
             */

            if (!permissions.isEmpty()) {
                ActivityCompat.requestPermissions(
                    activity,
                    permissions.toArray(arrayOfNulls<String>(permissions.size)),
                    requestCode
                )
                return false
            }

            return true
        }
    }

}