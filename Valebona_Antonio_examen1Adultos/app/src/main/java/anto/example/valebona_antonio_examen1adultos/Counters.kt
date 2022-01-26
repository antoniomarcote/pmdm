package anto.example.valebona_antonio_examen1adultos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import anto.example.valebona_antonio_examen1adultos.databinding.ActivityCountersBinding

class Counters : AppCompatActivity() {

    var cont1: Int = 0; var cont2: Int = 0; var inc1: Int = 0; var inc2: Int = 0; var contGlobal: Int = 0; var res: Int = 0;

    private lateinit var binding: ActivityCountersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("Examen 1T")
        super.onCreate(savedInstanceState)
        binding = ActivityCountersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.counter1?.setOnClickListener(
            View.OnClickListener {
                inc1 = binding.Increment1?.text.toString().toInt()
                if (inc1.toString().length < 1){
                    val duration = Toast.LENGTH_SHORT
                    val s = "Invalid Number"
                    Toast.makeText(this,s,duration).show()
                }else{
                cont1 += inc1
                contGlobal += inc1
                binding.Counter1res.setText(cont1.toString());
                binding.globalcounter?.setText(contGlobal.toString());
            }
            }
        )

        binding.counter2?.setOnClickListener(
            View.OnClickListener {
                inc2 = binding.Increment2?.text.toString().toInt()
                if (inc2.toString().length < 1){
                    val duration = Toast.LENGTH_SHORT
                    val s = "Invalid Number"
                    Toast.makeText(this,s,duration).show()
                }else{
                    cont2 += inc2
                    contGlobal += inc2
                    binding.Counter2res.setText(cont2.toString());
                    binding.globalcounter?.setText(contGlobal.toString());
                }
            }
        )
        binding.reset?.setOnClickListener(
            View.OnClickListener {
                    cont1 = res
                    cont2 = res
                    contGlobal = res
                    inc1 = res
                    inc2 = res
                    binding.Counter1res.setText(res.toString());
                    binding.Counter2res.setText(res.toString());
                    binding.Increment1.setText(res.toString());
                    binding.Increment2.setText(res.toString());
                    binding.globalcounter?.setText(res.toString());
            }
        )

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("Content1",binding.Counter1res.text.toString())
        outState.putString("Content2",binding.Counter2res.text.toString())
        outState.putString("Content3",binding.globalcounter?.text.toString())
        outState.putString("Content4",binding.Increment1?.text.toString())
        outState.putString("Content5",binding.Increment2?.text.toString())
        outState.putInt("key_contglobal",contGlobal)
        outState.putInt("key_cont1",cont1)
        outState.putInt("key_cont2",cont2)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        binding.Counter1res.setText(savedInstanceState.getString("Content1"))
        binding.Counter2res.setText(savedInstanceState.getString("Content2"))
        binding.globalcounter?.setText(savedInstanceState.getString("Content3"))
        binding.Increment1?.setText(savedInstanceState.getString("Content4"))
        binding.Increment2?.setText(savedInstanceState.getString("Content5"))
        contGlobal = savedInstanceState.getInt("key_contglobal",0)
        cont1 = savedInstanceState.getInt("key_cont1",0)
        cont2 = savedInstanceState.getInt("key_cont2",0)
        super.onRestoreInstanceState(savedInstanceState)
    }
}