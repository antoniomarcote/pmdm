package anto.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import anto.example.calculator.databinding.ActivityTest1Binding
import anto.example.calculator.databinding.ActivityTestBinding

class Test1 : AppCompatActivity() {

    private lateinit var binding: ActivityTest1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.regbutt?.setOnClickListener(
            View.OnClickListener {
                val intent1 = Intent(this, Register::class.java)
                startActivity(intent1)
            }
        )

        binding.logbutt?.setOnClickListener(
            View.OnClickListener {
                val intent2 = Intent(this, Login::class.java)
                startActivity(intent2)
            }
        )
    }
}