package com.example.calculatorapp2

import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

interface CalcOp {
    fun onEqual()
    fun onClear()
    fun onClickDigit(text: String)
}

class CalculatorOperations(
    private var tvResult: TextView
) : CalcOp {

    private var lastInputWasOperator = false

    override fun onEqual() {
        val text = tvResult.text.toString()

        try {
            // Build the expression using exp4j
            val expression = ExpressionBuilder(text).build()
            val result = expression.evaluate()

            // Check for infinity or NaN
            if (result.isInfinite() || result.isNaN()) {
                tvResult.text = "Error"
            } else {
                tvResult.text = result.toString()
            }

        } catch (e: ArithmeticException) {
            tvResult.text = "Error"
        } catch (e: Exception) {
            tvResult.text = "Error"
        }
    }

    override fun onClear() {
        tvResult.text = ""
        lastInputWasOperator = false
    }

    override fun onClickDigit(text: String) {
        // Remove "Error" message if a number is typed
        if (tvResult.text.toString() == "Error" && text in "0123456789") {
            tvResult.text = ""
        }

        if (text in arrayOf("+", "-", "*", "/")) {
            if (tvResult.text.isEmpty() || lastInputWasOperator) {
                // Prevent consecutive operators or starting with an operator
                return
            }
            lastInputWasOperator = true
        } else {
            lastInputWasOperator = false
        }

        tvResult.append(text)
    }
}
