package com.geektech.youtube12

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.browse.MediaBrowser.ConnectionCallback
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.os.Build
import android.os.Build.VERSION_CODES.N
import androidx.lifecycle.LiveData
import java.net.NetworkInterface

class NetworkConnection (private val context: Context):LiveData<Boolean>(){


    private val connectivityManager:ConnectivityManager=
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private lateinit var netWorkConnectionCallback:ConnectivityManager.NetworkCallback

    private val networkReceiver= object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            updateNetworkConnection()
        }

    }

    override fun onActive() {
        super.onActive()
        updateNetworkConnection()
        when{
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ->{
                connectivityManager.registerDefaultNetworkCallback(connectionCallback())
            }
            else ->{
                context.registerReceiver(networkReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
            }
        }
    }


    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(connectionCallback())
    }

    private fun connectionCallback():ConnectivityManager.NetworkCallback{

        netWorkConnectionCallback = object:ConnectivityManager.NetworkCallback(){

            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                postValue(true)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                postValue(false)
            }

            override fun onUnavailable() {
                super.onUnavailable()
                postValue(false)
            }
        }
        return netWorkConnectionCallback

    }
    private fun updateNetworkConnection() {
        val networkConnection: NetworkInfo?=connectivityManager.activeNetworkInfo
        postValue(networkConnection?.isConnected==true)
    }
}