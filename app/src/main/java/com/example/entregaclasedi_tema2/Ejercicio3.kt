package com.example.entregaclasedi_tema2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CalendarView
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Ejercicio3 : AppCompatActivity() {
    lateinit var correo: TextInputEditText
    lateinit var contrasena: TextInputEditText
    lateinit var nombre: TextInputEditText
    lateinit var cp: TextInputEditText
    lateinit var fecha_nacimiento:TextInputEditText
    lateinit var texto:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        correo = findViewById<TextInputEditText>(R.id.correo)
        contrasena = findViewById<TextInputEditText>(R.id.contrasena)
        nombre = findViewById(R.id.nombre)
        cp= findViewById(R.id.cp)
        fecha_nacimiento= findViewById(R.id.fecha_nacimiento)
        texto=findViewById<TextView>(R.id.textviewFinal)




        correo.addTextChangedListener {
            if (it.isNullOrBlank() || !it.contains("@") || !it.contains(".")) {
                correo.error = "Correo no completado con exito"
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

                }
            }

            cp.addTextChangedListener {
                if (it.toString().length < 5 && it.toString().length>0) {
                    cp.error = "El CP es incorrecto"
                }
            }

         fun isAdult(dateOfBirth: String): Boolean {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val currentDate = Calendar.getInstance().time

            try {
                val birthDate = dateFormat.parse(dateOfBirth)
                val calendarBirth = Calendar.getInstance().apply {
                    time = birthDate
                }

               val age = Calendar.getInstance().get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR)

                 calendarBirth.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR))

                return if (calendarBirth.time.before(currentDate)) {
                     age >= 18
                } else {
                    age - 1 >= 18
                }
            } catch (e: Exception) {
                e.printStackTrace()
                return false
            }
        }

// Dentro del bloque donde configuras el addTextChangedListener para fecha_nacimiento
        fecha_nacimiento.addTextChangedListener {
            if (!isAdult(it.toString())) {
                fecha_nacimiento.error="Debes ser mayor de edad"
            }else{

            }
        }


        }

    fun botonE3(view: View) {


    }
}
