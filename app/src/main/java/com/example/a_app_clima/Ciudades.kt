package com.example.a_app_clima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Button

class Ciudades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val bPlaya = findViewById<Button>(R.id.btn_playa)
        val bChetumal = findViewById<Button>(R.id.btn_chetumal)
        val bCarrillo = findViewById<Button>(R.id.btn_carrillo)
        val bCancun = findViewById<Button>(R.id.btn_cancun)

        bPlaya.setOnClickListener(View.OnClickListener {
            //hacia donde queremos ir
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

        bChetumal.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

        bCarrillo.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

        bCancun.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}