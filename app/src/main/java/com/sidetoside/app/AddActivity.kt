package com.sidetoside.app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        supportActionBar?.title = "Add Compare"
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, AddActivity::class.java)
    }
}
