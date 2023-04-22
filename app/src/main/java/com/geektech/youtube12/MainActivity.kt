package com.geektech.youtube12

import android.annotation.SuppressLint
import android.content.Context
import android.net.*
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.findNavController
import com.geektech.youtube12.databinding.ActivityMainBinding
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val networkConnection=NetworkConnection(this)
        networkConnection.observe(this) {
            if (it) {
                binding!!.included.root.visibility = View.GONE
            } else {
                binding!!.included.root.visibility = View.VISIBLE
                binding!!.included.btnTryAgain.setOnClickListener {
                    networkConnection.observe(this) {
                        if (it) {
                            binding!!.included.root.visibility = View.GONE

                        }
                    }
                }
            }
        }




    }
}