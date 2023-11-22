package com.example.lab5

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var textGuess:TextView
    private lateinit var buttonGuess:Button
    private lateinit var buttonYes:Button
    private lateinit var buttonNo:Button
    private lateinit var textResult:TextView
    private lateinit var text1:TextView
    private lateinit var text2:TextView
    private lateinit var button_next:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text1 = findViewById(R.id.textView)
        text2 = findViewById(R.id.textView2)
        textGuess = findViewById(R.id.textView_g)
        buttonGuess = findViewById(R.id.button)
        buttonYes = findViewById(R.id.buttonYes)
        buttonNo = findViewById(R.id.buttonNo)
        textResult = findViewById(R.id.textViewRes)
        button_next = findViewById(R.id.button_next)
        var result = 0
        buttonGuess.setOnClickListener(View.OnClickListener {
            result = (1..10).random()
            textGuess.visibility = View.VISIBLE
            textGuess.text = "Это число $result! Я угадал?"
            buttonYes.visibility = View.VISIBLE
            buttonNo.visibility = View.VISIBLE
            text1.visibility = View.GONE
            text2.visibility = View.GONE
            buttonGuess.visibility = View.GONE
        })
        buttonYes.setOnClickListener(View.OnClickListener {
            textResult.visibility = View.VISIBLE
            textResult.text = "Ура! Теперь попробуй угадать число, которое я загадал"
            button_next.visibility = View.VISIBLE
            textGuess.visibility = View.GONE
            buttonYes.visibility = View.GONE
            buttonNo.visibility = View.GONE
        })
        buttonNo.setOnClickListener(View.OnClickListener {
            textResult.visibility = View.VISIBLE
            textResult.text = "Жаль :( Теперь попробуй угадать число, которое я загадал"
            button_next.visibility = View.VISIBLE
            textGuess.visibility = View.GONE
            buttonYes.visibility = View.GONE
            buttonNo.visibility = View.GONE
        })
        button_next.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        })
    }
}