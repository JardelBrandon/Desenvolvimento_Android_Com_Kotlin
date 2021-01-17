package com.bloco.blocodenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var preferencia = PreferenciaAnotacao(applicationContext)
        var editAnotacao = editAnotacao
        var botaoFlutuante = floatingActionButton

        botaoFlutuante.setOnClickListener {

            val anotacaoRecuperado = editAnotacao.text.toString()

            if (anotacaoRecuperado == "") {
                Toast.makeText(this, "Digite alguma coisa...", Toast.LENGTH_SHORT).show()
            } else {
                preferencia.salvarAnotacao(anotacaoRecuperado)
                Toast.makeText(this, "Anotação salva com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }

        val anotacao = preferencia.recuperarAnotacao()
        if (anotacao != "") {
            editAnotacao.setText(anotacao)
        }
    }
}
