package anto.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import anto.example.calculator.databinding.ActivityMainBinding
import android.R
import android.util.Log

import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("Main Menu")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1?.setOnClickListener(
            View.OnClickListener {
                val intent = Intent(this, Test::class.java)
                startActivity(intent)
            }
        )
        binding.button2?.setOnClickListener(
            View.OnClickListener {
                val intent1 = Intent(this, Test1::class.java)
                startActivity(intent1)
            }
        )

        binding.button3?.setOnClickListener(
            View.OnClickListener {
                //binding.tV.text = (it as Button).text
                val duration = Toast.LENGTH_SHORT
                val s = "Coming soon..."
                Toast.makeText(this,s,duration).show()
            }
        )
    }

}