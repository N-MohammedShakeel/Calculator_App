package com.example.calculatorapp2

import android.widget.TextView
import com.example.calculatorapp2.databinding.ActivityMainBinding

interface CalcOp {
    fun onEqual()
    fun onClear()
fun onClickDigit(text: String)
}

class CalculatorOperations(
    private var tvResult: TextView
) : CalcOp {

    override fun onEqual() {
        val text = tvResult.text.toString()
        val numbers = text.split("+", "-", "/", "*")

        if (numbers.size >= 2) {
            var sum = 0.0

            when {
                text.contains("+") -> {
                    for (num in numbers) {
                        sum += num.toDouble()
                    }
                }
                text.contains("-") -> {
                    sum = numbers[0].toDouble()
                    for (i in 1 until numbers.size) {
                        sum -= numbers[i].toDouble()
                    }
                }
                text.contains("/") -> {
                    sum = numbers[0].toDouble()
                    for (i in 1 until numbers.size) {
                        sum /= numbers[i].toDouble()
                    }
                }
                text.contains("*") -> {
                    sum = 1.0
                    for (num in numbers) {
                        sum *= num.toDouble()
                    }
                }
            }

            tvResult.text = sum.toString()
        }
    }

    override fun onClear() {
        tvResult.text = "0"
    }

    override fun onClickDigit(text: String) {
        tvResult.append(text)
    }
}
