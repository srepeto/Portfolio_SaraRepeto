package com.example.quetocapalaboca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val listaPlatos = arrayListOf("Serranito", "Hamburguesa", "Perrito", "Pizza", "Montadito", "Brocheta")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botDecidir.setOnClickListener {
            val aleat = java.util.Random()
            val platoAleat = aleat.nextInt(listaPlatos.count())
            quesepedira.text = listaPlatos[platoAleat]
        }

        botPlato.setOnClickListener {
            if (!cajaNuevo.text.toString().equals("")) {
                val nuevoPlato = cajaNuevo.text.toString()
                listaPlatos.add(nuevoPlato)
                cajaNuevo.text.clear()
            }
        }
    }
}