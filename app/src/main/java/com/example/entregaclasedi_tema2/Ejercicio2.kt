package com.example.entregaclasedi_tema2

import android.icu.text.CompactDecimalFormat.CompactStyle
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Ejercicio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)
    }

    fun boton(view: View):Boolean {
        var validar = true

        val usuario = findViewById<TextInputEditText>(R.id.layoutUsuarioText)
        val usuario2 = usuario.text ?: ""
        val contrasena = findViewById<TextInputEditText>(R.id.layoutContrasenaText)
        val gmail = findViewById<TextInputEditText>(R.id.layoutEmailText)
        val gmail2 = gmail.text ?: ""


        if(usuario2.isEmpty()){
            usuario.error="Error al introducir usuario"
            usuario.setBackgroundColor(getColor(R.color.rojoclaro))
            usuario.setTextColor(getColor(R.color.white))
            usuario.setText("GAY69")
            validar=false
        }else if(contrasena.length()<6) {
            contrasena.error="Contraseña incorrecta."
            contrasena.setBackgroundColor(getColor(R.color.rojoclaro))
            contrasena.setTextColor(getColor(R.color.white))
            validar=false
        }else if(!gmail2.contains("@") && !gmail2.contains(".")){
            gmail.error="Correo electronico no valido."
            gmail.setBackgroundColor(getColor(R.color.rojoclaro))
            gmail.setTextColor(getColor(R.color.white))
            gmail.setText("GAY69ChupaPitos@gmail.com")
            validar=false
        }
        return validar
    }
}