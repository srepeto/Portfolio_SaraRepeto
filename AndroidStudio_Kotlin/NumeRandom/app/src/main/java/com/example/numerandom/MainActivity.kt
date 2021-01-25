package com.example.numerandom

import android.graphics.Color
import android.graphics.Color.WHITE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botGenera.setOnClickListener {
            val aleat = java.util.Random()
            val numAleat = aleat.nextInt(barra.progress+1)
            labelNum.text = numAleat.toString()
        }

    }

}