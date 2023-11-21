package com.example.entregaclasedi_tema2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputEditText

class Ejercicio3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        var correo = findViewById<TextInputEditText>(R.id.correo)

    }

    fun botonE3(view: View) {

    }
}