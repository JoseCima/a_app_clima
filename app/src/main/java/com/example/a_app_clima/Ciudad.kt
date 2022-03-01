package com.example.a_app_clima

class Ciudad (name:String, Weather:ArrayList<Weather>, main:Main){
    var name:String = ""
    var weather:ArrayList<Weather>? = null
    var main:Main? = null
    init {

        this.name = name
        this.weather = weather
        this.main = main
    }
}