package com.example.kkalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var textViewInput: TextView
    var calc: String = ""
    var num: Float = 0.0f
    var square: Float = 0.0f
    var squareLength: Number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewInput = findViewById(R.id.alertcalc)
    }

    fun onDigit (view: View) {
        if (textViewInput.text.toString() == "nie wolno") textViewInput.text = ""
        textViewInput.append((view as Button).text)
    }

    fun onAgain (view: View) {
        squareLength = 0
        square = 0.0f
        num = 0.0f
        textViewInput.text = ""
    }

    fun onClear (view: View) {
        textViewInput.text = ""
    }

    private fun funNum (operator: String) {
        if (squareLength != 0) {
            val square2: Int = textViewInput.text.subSequence(Integer.parseInt(squareLength.toString()), textViewInput.text.toString().length).toString().toInt()
            num = (power(square.toInt(), square2)).toFloat()
            squareLength = 0
            square = 0.0f
        } else num = textViewInput.text.toString().toFloat()

        calc = operator
        textViewInput.text = ""
    }

    fun onAdd (view: View) {
        funNum ("adding")
    }

    fun onSub (view: View) {
        if (textViewInput.text.isEmpty()) textViewInput.append("-")
        else funNum ("subtraction")
    }

    fun onMul (view: View) {
        funNum ("multiplication")
    }

    fun onDiv (view: View) {
        funNum ("division")
    }

    private fun power(baseVal: Int, exponentVal: Int): Long {
        if (exponentVal != 0) return baseVal  * power(baseVal, exponentVal - 1)
        else return 1
    }

    fun onExp (view: View) {
        square = textViewInput.text.toString().toFloat()
        squareLength = square.toString().length - 1
        textViewInput.append("^")
    }

    fun onRoot (view: View) {
        num = textViewInput.text.toString().toFloat()
        num = sqrt(num)
        textViewInput.text = num.toString()
    }

    fun onEqual (view: View) {
        val oldTextViewInput: CharSequence = textViewInput.text
        var someNome: Float = 0.0f
        if (squareLength == 0) someNome = textViewInput.text.toString().toFloat()
        textViewInput.text = ""

        if (squareLength != 0){
            textViewInput.text = oldTextViewInput
            val square2: Int = textViewInput.text.subSequence(
                Integer.parseInt(squareLength.toString()),
                textViewInput.text.toString().length
            ).toString().toInt()
            textViewInput.text = (power(square.toInt(), square2)).toString()
        }
        if (calc == "adding") textViewInput.text = (num + someNome).toString()
        else if (calc == "subtraction") textViewInput.text = (num - someNome).toString()
        else if (calc == "multiplication") textViewInput.text = (num * someNome).toString()
        else if (calc == "division") {
            if (someNome == 0.0f) {
                textViewInput.text = "nie wolno"
                return
            }
            textViewInput.text = (num / someNome).toString()
        }
    }
}