package com.diksh.androidtv

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {   //replaced AppcompatActivity with the FragmentActivity because action bar is not used
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}