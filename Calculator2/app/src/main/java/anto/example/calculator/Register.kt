package anto.example.calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import anto.example.calculator.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    var username: String = ""
    var password: String = ""

    val userpass: MutableMap<String, String> = mutableMapOf(username to password)


        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.exitbutt?.setOnClickListener(
            View.OnClickListener {
                val intent1 = Intent(this, Test1::class.java)
                startActivity(intent1)
            }
        )

        binding.savebutt?.setOnClickListener(
            View.OnClickListener {
                username = binding.nameReg?.text.toString()
                password = binding.passReg?.text.toString()

                BaseDatos.useradd(username,password)
                val duration = Toast.LENGTH_SHORT
                val s = "Username: ${BaseDatos.userpass.keys} --- Password: ${BaseDatos.userpass.values}"
                Toast.makeText(this,s,duration).show()
                val intent2 = Intent(this, Test1::class.java)
                startActivity(intent2)
            }
        )


    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("Name_Reg",binding.nameReg?.text.toString())
        outState.putString("Pass_Reg",binding.passReg?.text.toString())
        outState.putString("key_pass",userpass.keys.toString())
        outState.putString("key_user",userpass.values.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        binding.nameReg?.setText(savedInstanceState.getString("Name_Reg"))
        binding.passReg?.setText(savedInstanceState.getString("Pass_Reg"))
        super.onRestoreInstanceState(savedInstanceState)
    }
}