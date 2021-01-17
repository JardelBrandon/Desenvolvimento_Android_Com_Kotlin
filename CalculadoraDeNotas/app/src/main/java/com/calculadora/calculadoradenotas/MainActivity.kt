package com.calculadora.calculadoradenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoCalcular = bt_calcular
        val resultado = resultado

        botaoCalcular.setOnClickListener {

            val nota1 = (nota1.text.toString()).toFloat()
            val nota2 = (nota2.text.toString()).toFloat()
            val media = (nota1 + nota2) / 2
            val faltas = Integer.parseInt(faltas.text.toString())

            if(media >= 6 && faltas <= 10) {
                resultado.setText("Aluno aprovado!" + "\nNota final: " + media + "\nFaltas: " + faltas)
                resultado.setTextColor(Color.GREEN)
            } else {
                resultado.setText("Aluno reprovado!" + "\nNota final: " + media + "\nFaltas: " + faltas)
                resultado.setTextColor(Color.RED)
            }

        }
    }
}
