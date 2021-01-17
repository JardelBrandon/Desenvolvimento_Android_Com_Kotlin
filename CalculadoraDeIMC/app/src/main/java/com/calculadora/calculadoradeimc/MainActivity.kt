package com.calculadora.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calcular = bt_calcular

        calcular.setOnClickListener {
            var peso = edit_peso.text.toString().toFloat()
            var altura = edit_altura.text.toString().toFloat()
            var resultado = mensagem
            val imc = peso / (altura * altura)

            val mensagem  = when {
                imc <= 18.5 -> "Peso baixo"
                imc <= 24.9 -> "Peso normal"
                imc <= 29.9 -> "Sobrepeso"
                imc <= 34.9 -> "Obesidade (Grau 1)"
                imc <= 39.9 -> "Obesidade (Grau 2)"
                else -> "Obesidade morbida (Grau 3)"
            }

            resultado.text = "IMC: " + imc.toString() + "\n" + mensagem
        }
    }
}
