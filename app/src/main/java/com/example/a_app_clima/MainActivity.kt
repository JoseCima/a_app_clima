package com.example.a_app_clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.lang.Exception

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

        //chetumal: 3531023
        //carrillo: 3527639
        //Playa del Carmen: 3521342
        //Cancun: 3531673
        //de72b2851efe338c4ee4cee2a5385a03
        if(Network.hayRed(this)){
            //ejecturar solicitud HTTP
            solicitudHTTPVolley("https://api.openweathermap.org/data/2.5/weather?id="+Ciudad+"&appid=de72b2851efe338c4ee4cee2a5385a03&units=metric&lang=es")

        }else{
            //Mostrar mensaje de error
            Toast.makeText(this, "No hay Red", Toast.LENGTH_SHORT).show()
        }




        /*
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
        }*/

    }


    private fun solicitudHTTPVolley(url:String){
        val queue = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, url , Response.Listener<String>{
            response ->
            try {
                Log.d( "solicitudHTTPVolley", response)

                val gson = Gson()
                val ciudad = gson.fromJson(response, Ciudad::class.java)

                tvCiudad?.text = ciudad.name
                tvGrados?.text= ciudad.main?.temp.toString() + "°"
                tvEstatus?.text=ciudad.weather?.get(0)?.description


            }catch (e: Exception){
            } }, Response.ErrorListener{} )
        queue.add(solicitud)
    }
}