package com.example.entregaclasedi_tema2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun boton(view: View) {
        var color = findViewById<TextInputEditText>(R.id.colorPiel)
        var color2 = color.text ?: ""
        var tamanoPene = findViewById<TextInputEditText>(R.id.tamanoPene)
        var tamanoPene2 = tamanoPene.text.toString() ?: ""
        if(color2.length<2){
            color.error="Escribe un color correcto"
        }else if (color2.isEmpty()){
            color.error="No se puede dejar el correo en blanco"
        }else if (tamanoPene2.toInt() < 18){
            tamanoPene.error = "Tienes el pito chico"
        }else{
            recreate()
        }

    }
}