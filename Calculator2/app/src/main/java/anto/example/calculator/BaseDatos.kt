package anto.example.calculator

import android.widget.Toast
import java.security.AccessControlContext
import kotlin.collections.MutableMap as MutableMap1

object BaseDatos{

    val userpass: MutableMap1<String, String> = mutableMapOf()

    fun useradd(username: String, password: String){
        userpass.put(username,password)
    }
    //Arreglar esto anto
    fun finduser(username: String,password: String): Boolean {
        var flag: Boolean = false

        if (username.equals(userpass) ){
            userpass.containsValue(password)
            flag = true
        }

        return flag
    }

}