package com.example.calculatorapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.calculatorapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var resulttv:TextView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resulttv = findViewById(R.id.resulttv)
    }
    fun onClickDigit(view: View){

        if(binding.resulttv.text.toString() == "0"){
            binding.resulttv.text = (view as Button).text
        }else{
            resulttv.append((view as Button).text)
        }

    }

    fun onClickCancel(view: View){
        binding.resulttv.text = binding.resulttv.text.toString().substring(0,binding.resulttv.text.length-1)
        if (binding.resulttv.text.toString() == ""){
            binding.resulttv.text = "0"
        }
    }

    fun onClear(view: View){
        binding.resulttv.text = "0"
    }
}