package com.example.entregaclasedi_tema2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CalendarView
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class Ejercicio3 : AppCompatActivity() {
    lateinit var correo: TextInputEditText
    lateinit var contrasena: TextInputEditText
    lateinit var nombre: TextInputEditText
    lateinit var cp: TextInputEditText
    lateinit var fecha_nacimiento:TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        correo = findViewById<TextInputEditText>(R.id.correo)
        contrasena = findViewById<TextInputEditText>(R.id.contrasena)
        nombre = findViewById(R.id.nombre)
        cp= findViewById(R.id.cp)
        fecha_nacimiento= findViewById(R.id.fecha_nacimiento)

        correo.addTextChangedListener {
            if (it.isNullOrBlank() || !it.contains("@") || !it.contains(".")) {
                correo.error = "Correo no completado con exito"
            } else {
                contrasena.isFocusable = true
            }
        }

            contrasena.addTextChangedListener {
                println(it)
                if (it != null) {
                    if (it.length < 7) {
                        contrasena.error = "La contraseña es demasiado corta"
                    }
                    val regex = Regex("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).+\$")

                    if (it.matches(regex)) {
                        println("entra")
                        nombre.isFocusable = true

                    } else {
                        contrasena.error =
                            ("La contraseña debe contener mayusc. minusc. y numeros ")
                    }
                } else {
                    contrasena.error = "La contraseña no puede estar vacia"
                }


            }
            nombre.addTextChangedListener{
                if(it.isNullOrBlank()){
                    nombre.error="Esque no tienes nombre? Gilipollas"
                    cp.isFocusable=false
                    Log.v("focusable",cp.focusable.toString())

                }else{
                    cp.isFocusable=true
                    Log.v("focusable",cp.focusable.toString())
                }
            }

            cp.addTextChangedListener {
                if (it.toString().length < 5 && it.toString().length>0) {
                    cp.error = "El CP es incorrecto"
                } else {
                    fecha_nacimiento.isFocusable = true
                }
            }

            fecha_nacimiento.addTextChangedListener{
                var ano_actual = Calendar.YEAR

            }

            fun botonE3(view: View) {

            }
        }
    }
