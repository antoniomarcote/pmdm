package anto.example.valebona_antonio_examen1adultos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import anto.example.valebona_antonio_examen1adultos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var username: String = "";
    var password: String = "";

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("Examen 1T")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logbutt.setOnClickListener(
            View.OnClickListener {
                username = binding.editTextTextPersonName.text.toString()
                password = binding.editTextTextPassword.text.toString()

                if (username.length < 1) {
                    val duration = Toast.LENGTH_SHORT
                    val s = "Invalid E-mail"
                    Toast.makeText(this,s,duration).show()
                }else if(password.length < 8){
                val duration = Toast.LENGTH_SHORT
                val s = "8 Characters needed"
                Toast.makeText(this,s,duration).show()
                }else{
                    val duration = Toast.LENGTH_SHORT
                    val s = "User loged"
                    Toast.makeText(this,s,duration).show()
                    val countersAct = Intent(this, Counters::class.java)
                    startActivity(countersAct)
                }
            }
        )

        binding.regbutt.setOnClickListener(
            View.OnClickListener {
                   val registerAct = Intent(this, Register::class.java)
                   startActivity(registerAct)
            }
        )


    }
}