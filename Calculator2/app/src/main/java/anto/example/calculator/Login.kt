package anto.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import anto.example.calculator.databinding.ActivityLoginBinding
import anto.example.calculator.databinding.ActivityRegisterBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}