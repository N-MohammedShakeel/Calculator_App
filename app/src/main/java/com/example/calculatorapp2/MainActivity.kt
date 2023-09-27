package com.example.calculatorapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.calculatorapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var resulttv: TextView? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val one = findViewById<Button>(R.id.btone)
        val two = findViewById<Button>(R.id.bttwo)
        val three = findViewById<Button>(R.id.btthree)
        val four = findViewById<Button>(R.id.btfour)
        val five = findViewById<Button>(R.id.btfive)
        val six = findViewById<Button>(R.id.btsix)
        val seven = findViewById<Button>(R.id.seven)
        val eight = findViewById<Button>(R.id.eight)
        val nine = findViewById<Button>(R.id.nine)
        val zero = findViewById<Button>(R.id.zero)
        val dot = findViewById<Button>(R.id.dot)
        val space = findViewById<Button>(R.id.btspace)
        var result = findViewById<TextView>(R.id.resulttv)
        val count = findViewById<TextView>(R.id.count)
        val add = findViewById<Button>(R.id.add)
        val sub = findViewById<Button>(R.id.sub)
        val multi = findViewById<Button>(R.id.btmulti)
        val divide = findViewById<Button>(R.id.btdivide)


        var timesclicked = 0

        count.setOnClickListener {
            timesclicked += 1
            count.text = timesclicked.toString()
        }
        one.setOnClickListener {
            result.append("1").toString()

        }
        two.setOnClickListener {
            result.append("2").toString()

        }
        three.setOnClickListener {
            result.append("3").toString()

        }
        four.setOnClickListener {
            result.append("4").toString()

        }
        five.setOnClickListener {
            result.append("5").toString()

        }
        six.setOnClickListener {
            result.append("6").toString()

        }
        seven.setOnClickListener {
            result.append("7").toString()

        }
        eight.setOnClickListener {
            result.append("8").toString()

        }
        nine.setOnClickListener {
            result.append("9").toString()

        }
        zero.setOnClickListener {
            result.append("0").toString()

        }
        dot.setOnClickListener {
            result.append(".").toString()

        }
        add.setOnClickListener {
            result.append("+").toString()

        }
        sub.setOnClickListener {
            result.append("-").toString()

        }
        multi.setOnClickListener {
            result.append("*").toString()

        }
        divide.setOnClickListener {
            result.append("/").toString()

        }
        space.setOnClickListener {
            val rip: Any = result?.text!!.removeSuffix((-1).toString())
            result = rip as TextView?

        }

        stringdataIntoCalc()

    }

    private fun stringdataIntoCalc() {
        val equal = findViewById<Button>(R.id.btequal)

        equal.setOnClickListener {
            val stringList: String = resulttv.toString()
            val ans: MutableList<String> = stringList.split(" ").toMutableList()

            if (ans.size != 4) {
                println("enter num_op-num")
            }
            val first: String = ans[0]
            val second: String = ans[2]
            val sign: String = ans[1]
            var result: Int? = null


            when (sign) {
                "+" -> result = first.toInt() + second.toInt()
                "-" -> result = first.toInt() - second.toInt()
                "*" -> result = first.toInt() * second.toInt()
                "/" -> result = first.toInt() / second.toInt()
            }
            if (result != null) {
                return@setOnClickListener

            }


        }

    }
}

//constraint layout is used for XML


