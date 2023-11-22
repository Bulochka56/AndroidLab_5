package com.example.lab5

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Button
import android.widget.EditText

class MainActivity2 : AppCompatActivity() {
    private lateinit var text1: TextView
    private lateinit var editTextNumber: EditText
    private lateinit var button: Button
    private lateinit var textRes: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        text1 = findViewById(R.id.textView4)
        editTextNumber = findViewById(R.id.editTextNumber)
        button = findViewById(R.id.buttonNum)
        textRes = findViewById(R.id.textView5)

        button.setOnClickListener(View.OnClickListener {
            val randomNumber = (1..10).random()
            val numberString = editTextNumber.text.toString()
            val number: Int = if (numberString.isNotEmpty()) {
                numberString.toInt()
            } else {

                0 // Здесь мы устанавливаем значение по умолчанию в 0
            }
            if (number >= 1 && number <= 10){
                if (number == randomNumber) {
                    textRes.text = "Молодец! Я загадал именно это число"
                }
                else {
                    textRes.text = "Увы, я загадал не это число. Мое число: $randomNumber"
                }
                textRes.visibility = View.VISIBLE
                text1.visibility = View.GONE
                editTextNumber.visibility = View.GONE
                button.visibility = View.GONE
            }
            else if (numberString.isEmpty())
            {
                editTextNumber.background.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP)
                editTextNumber.setHintTextColor(Color.RED)
                editTextNumber.text.clear()
                editTextNumber.setHint("Введите число")
            }
            else {
                editTextNumber.background.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP)
                editTextNumber.setHintTextColor(Color.RED)
                editTextNumber.text.clear()
                editTextNumber.setHint("Введите верное число")
            }


        })
    }
}