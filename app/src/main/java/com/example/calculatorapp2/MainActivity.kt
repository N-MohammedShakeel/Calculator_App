package com.example.calculatorapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.calculatorapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var tvResult: TextView? = null
    private lateinit var binding: ActivityMainBinding
    lateinit var CalculatorOperations: CalculatorOperations
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvResult = findViewById(R.id.resulttv)
        CalculatorOperations = CalculatorOperations(tvResult!!)

        val buttons = arrayOf<Button>(
            findViewById(R.id.btac),
            findViewById(R.id.btleft),
            findViewById(R.id.btright),
            findViewById(R.id.btdivide),
            findViewById(R.id.seven),
            findViewById(R.id.eight),
            findViewById(R.id.nine),
            findViewById(R.id.btmulti),
            findViewById(R.id.btfour),
            findViewById(R.id.btfive),
            findViewById(R.id.btsix),
            findViewById(R.id.sub),
            findViewById(R.id.btone),
            findViewById(R.id.bttwo),
            findViewById(R.id.btthree),
            findViewById(R.id.add),
            findViewById(R.id.zero),
            findViewById(R.id.dot),
            findViewById(R.id.btspace),
            findViewById(R.id.btequal)
        )
        for (button in buttons) {
            button.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btac -> {
                CalculatorOperations.onClear()
            }

            R.id.btleft -> {
                CalculatorOperations.onClickDigit("(")
            }

            R.id.btright -> {
                CalculatorOperations.onClickDigit(")")
            }

            R.id.add -> {
                CalculatorOperations.onEqual()
                CalculatorOperations.onClickDigit("+")

            }

            R.id.sub -> {
                CalculatorOperations.onEqual()
                CalculatorOperations.onClickDigit("-")

            }

            R.id.btmulti -> {
                CalculatorOperations.onEqual()
                CalculatorOperations.onClickDigit("*")

            }

            R.id.btdivide -> {
                CalculatorOperations.onEqual()
                CalculatorOperations.onClickDigit("/")

            }

            R.id.btone -> {

                CalculatorOperations.onClickDigit("1")
            }

            R.id.bttwo -> {

                CalculatorOperations.onClickDigit("2")
            }

            R.id.btthree -> {

                CalculatorOperations.onClickDigit("3")
            }

            R.id.btfour -> {

                CalculatorOperations.onClickDigit("4")
            }

            R.id.btfive -> {

                CalculatorOperations.onClickDigit("5")
            }

            R.id.btsix -> {

                CalculatorOperations.onClickDigit("6")
            }

            R.id.seven -> {

                CalculatorOperations.onClickDigit("7")
            }

            R.id.eight -> {

                CalculatorOperations.onClickDigit("8")
            }

            R.id.nine -> {

                CalculatorOperations.onClickDigit("9")
            }

            R.id.zero -> {

                CalculatorOperations.onClickDigit("0")
            }

            R.id.dot -> {

                CalculatorOperations.onClickDigit(".")
            }

            R.id.btspace -> {

                if (tvResult?.text.toString() != "")
                    tvResult?.text = tvResult?.text.toString().substring(0,tvResult?.text.toString().length - 1)
            }

            R.id.btequal -> {
                CalculatorOperations.onEqual()
            }

            else -> {

                Log.d("Error", "Invalid Operation")

            }

        }
    }
}



//constraint layout is used for XML


