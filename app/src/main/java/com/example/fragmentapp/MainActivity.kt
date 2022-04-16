package com.example.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    companion object {
        private const val MAIN_ACTIVITY_LOG = "com.example.1.MainAct"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(MAIN_ACTIVITY_LOG, "MA - onCreate starts")

        supportFragmentManager.beginTransaction().run {
            replace(
                R.id.fragment_container,
                ListFragment.newListFragment(),
                ListFragment.LIST_FRAG_TAG
            )
            commit()
        }
        Log.d(MAIN_ACTIVITY_LOG, "MA - onCreate finishes")
    }

    override fun onStart() {
        super.onStart()
        Log.d(MAIN_ACTIVITY_LOG, "MA - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(MAIN_ACTIVITY_LOG, "MA - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(MAIN_ACTIVITY_LOG, "MA - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(MAIN_ACTIVITY_LOG, "MA - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MAIN_ACTIVITY_LOG, "MA - onDestroy")
    }
}