package anto.example.calculator

import kotlin.collections.MutableMap as MutableMap1

object BaseDatos : MutableMap1{

    val userpass: MutableMap1<String, String> = mutableMapOf()

    fun useradd(username: String, password: String){
        userpass.put(username,password)
    }

    fun showdata(){
        println("Username: ${userpass.keys} --- Password: ${userpass.values}")
    }

}