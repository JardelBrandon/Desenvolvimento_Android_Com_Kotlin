package com.calculadora.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calcular = bt_calcular
        var deletar = icone_deletar

        calcular.setOnClickListener {
            var pesoInformado = edit_peso.text.toString()
            var alturaInformada = edit_altura.text.toString()

            if(pesoInformado.isEmpty()) {
                mensagem.setText("Informe o seu peso")
            } else if(alturaInformada.isEmpty()) {
                mensagem.setText("Informe a sua altura")
            } else {
                calculoDeIMC()
            }
        }

        deletar.setOnTouchListener { view, motionEvent ->

            if(motionEvent.action == MotionEvent.ACTION_DOWN) {
                edit_peso.setText("")
                edit_altura.setText("")
                mensagem.setText("")
            }

            false  }
    }

    private fun calculoDeIMC() {
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
