package com.example.a_app_clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView ?=null
    var tvGrados:TextView?=null
    var tvEstatus:TextView?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstatus)

        val Ciudad = intent.getStringExtra("com.example.a_app_clima.ciudades.CIUDAD")

        Toast.makeText(this, Ciudad, Toast.LENGTH_SHORT).show()

        val ciudadPlaya = Ciudad(nombre ="Playa del Carmen", grados = 15, estatus = "Soleado")
        val ciudadChetumal = Ciudad(nombre ="Chetumal", grados = 30, estatus = "Cielo Despejado")
        val ciudadCarrillo = Ciudad(nombre ="Felipe Carrillo Puerto", grados = 24, estatus = "Nublado")
        val ciudadCancun = Ciudad(nombre ="Cancún", grados = 18, estatus = "Día Lluvioso")

        if(Ciudad == "Ciudad de Playa del Carmen"){
            //Mostrar info de playa
            tvCiudad?.text = ciudadPlaya.nombre
            tvGrados?.text= ciudadPlaya.grados.toString() + "°"
            tvEstatus?.text=ciudadPlaya.estatus

        }else if(Ciudad =="Ciudad de Chetumal"){
            //Mostrar info de chetumal
            tvCiudad?.text = ciudadChetumal.nombre
            tvGrados?.text= ciudadChetumal.grados.toString() + "°"
            tvEstatus?.text=ciudadChetumal.estatus
        }else if(Ciudad == "Ciudad de Felipe Carrillo Puerto"){

            tvCiudad?.text = ciudadCarrillo.nombre
            tvGrados?.text= ciudadCarrillo.grados.toString() + "°"
            tvEstatus?.text=ciudadCarrillo.estatus
        }else if(Ciudad == "Ciudad de Cancún"){

            tvCiudad?.text = ciudadCancun.nombre
            tvGrados?.text= ciudadCancun.grados.toString() + "°"
            tvEstatus?.text=ciudadCancun.estatus
        }else{
            Toast.makeText(this, "No se encuentra la información", Toast.LENGTH_SHORT).show()
        }

    }
}