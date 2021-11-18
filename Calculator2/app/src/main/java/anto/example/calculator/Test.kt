package anto.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import anto.example.calculator.databinding.ActivityMainBinding
import anto.example.calculator.databinding.ActivityTestBinding

class Test : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding

    var num1: Int = 0; var num2: Int = 0; var resultado: Int = 0;

    var operador: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun capturenum1() {
            //Log.d(":::", )
            num1 = binding.tV.text.toString().toInt()
            binding.tV.setText("");
        }

        binding.button0.setOnClickListener(
            View.OnClickListener {
                //binding.tV.text = (it as Button).text
                binding.tV.setText(binding.tV.text.toString() + "0");
            }
        )

        binding.button1.setOnClickListener(
            View.OnClickListener {
                //binding.tV.text = (it as Button).text
                binding.tV.setText(binding.tV.text.toString() + "1");
            }
        )
        binding.button2.setOnClickListener(
            View.OnClickListener {
                binding.tV.setText(binding.tV.text.toString() + "2");
            }
        )
        binding.button3.setOnClickListener(
            View.OnClickListener {
                binding.tV.setText(binding.tV.text.toString() + "3");
            }
        )
        binding.button4.setOnClickListener(
            View.OnClickListener {
                binding.tV.setText(binding.tV.text.toString() + "4");
            }
        )
        binding.button5.setOnClickListener(
            View.OnClickListener {
                binding.tV.setText(binding.tV.text.toString() + "5");
            }
        )
        binding.button6.setOnClickListener(
            View.OnClickListener {
                binding.tV.setText(binding.tV.text.toString() + "6");
            }
        )
        binding.button7.setOnClickListener(
            View.OnClickListener {
                binding.tV.setText(binding.tV.text.toString() + "7");
            }
        )
        binding.button8.setOnClickListener(
            View.OnClickListener {
                binding.tV.setText(binding.tV.text.toString() + "8");
            }
        )
        binding.button9.setOnClickListener(
            View.OnClickListener {
                binding.tV.setText(binding.tV.text.toString() + "9");
            }
        )
        binding.button10.setOnClickListener(
            View.OnClickListener {
                operador = "+";
                capturenum1();
            }
        )
        binding.button11.setOnClickListener(
            View.OnClickListener {
                operador = "-";
                capturenum1();
            }
        )
        binding.button12.setOnClickListener(
            View.OnClickListener {
                operador = "*";
                capturenum1();
            }
        )
        binding.button13.setOnClickListener(
            View.OnClickListener {
                operador = "/";
                capturenum1();
            }
        )

        binding.button14.setOnClickListener(
            View.OnClickListener {

                num2 = binding.tV.text.toString().toInt()

                if (operador.equals("+")) {
                    resultado = num1 + num2
                } else if (operador.equals("-")) {
                    resultado = num1 - num2
                } else if (operador.equals("*")) {
                    resultado = num1 * num2
                } else if (operador.equals("/")) {
                    resultado = num1 / num2
                }
                binding.tV.setText(resultado.toString());

            }
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("Content",binding.tV.text.toString())
        outState.putString("key_op",operador)
        outState.putInt("key_num1",num1)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        binding.tV.setText(savedInstanceState.getString("Content"))
        num1 = savedInstanceState.getInt("key_num1",0)
        operador = savedInstanceState.getString("key_op").toString()
        super.onRestoreInstanceState(savedInstanceState)
    }
}
