package anto.example.valebona_antonio_examen1adultos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import anto.example.valebona_antonio_examen1adultos.databinding.ActivityCountersBinding
import anto.example.valebona_antonio_examen1adultos.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {

    var username: String = "";
    var password: String = "";
    var confirm: String = "";

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("Examen 1T")
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save?.setOnClickListener(
            View.OnClickListener {
                username = binding.editTextTextPersonName.text.toString()
                password = binding.editTextTextPassword.text.toString()
                confirm = binding.confirm.text.toString()

                if (username.length < 1) {
                    val duration = Toast.LENGTH_SHORT
                    val s = "Invalid E-mail"
                    Toast.makeText(this,s,duration).show()
                }else if(password.length < 8){
                    val duration = Toast.LENGTH_SHORT
                    val s = "8 Characters needed"
                    Toast.makeText(this,s,duration).show()
                }else if(!password.equals(confirm) or !confirm.equals(password)){
                    val duration = Toast.LENGTH_SHORT
                    val s = "Passwords doesnt match"
                    Toast.makeText(this,s,duration).show()
                }else{
                    val duration = Toast.LENGTH_SHORT
                    val s = "Succesfully registered"
                    Toast.makeText(this,s,duration).show()
                    val mainAct = Intent(this, MainActivity::class.java)
                    startActivity(mainAct)
                }
            }
        )

    }
}