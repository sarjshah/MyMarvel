package com.practice.mymarvel.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practice.mymarvel.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHello.text = "Hello from Marvel"
    }
}