package com.example.kkalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textViewInput: TextView
    var num: Float = 0.0f
    lateinit var calc: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewInput = findViewById(R.id.alertcalc)
    }

    fun onDigit (view: View) {
        textViewInput.append((view as Button).text)
    }

    fun onClear (view: View) {
        textViewInput.text = ""
    }

    private fun funNum (operator: String) {
        num = textViewInput.text.toString().toFloat()
        calc = operator
        textViewInput.text = ""
    }

    fun onAdd (view: View) {
        funNum ("adding")
    }

    fun onSub (view: View) {
        funNum ("subtraction")
    }

    fun onMul (view: View) {
        funNum ("multiplication")
    }

    fun onDiv (view: View) {
        funNum ("division")
    }

    fun onEqual (view: View) {
        val someNome: Float = textViewInput.text.toString().toFloat()
        val adding: Float = num + someNome
        val subtraction: Float = num - someNome
        val multiplication: Float = num * someNome
        val division: Float = num / someNome
        textViewInput.text = ""

        if (calc == "adding") textViewInput.text = adding.toString()
        else if (calc == "subtraction") textViewInput.text = subtraction.toString()
        else if (calc == "multiplication") textViewInput.text = multiplication.toString()
        else if (calc == "division") textViewInput.text = division.toString()
    }
}