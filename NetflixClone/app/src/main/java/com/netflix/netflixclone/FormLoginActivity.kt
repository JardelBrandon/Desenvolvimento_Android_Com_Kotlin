package com.netflix.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.android.synthetic.main.activity_form_login.*

class FormLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        var textoCadastrar = text_cadastrar

        textoCadastrar.setOnClickListener {
            abrirTelaDeCadastro()
        }

        bt_entrar.setOnClickListener {

            autenticarUsuario()
        }
    }

    private fun autenticarUsuario() {

        var email = edit_email.text.toString()
        var senha = edit_senha.text.toString()
        var mensagens = mensagem_erro

        if(email.isEmpty() || senha.isEmpty()) {
            mensagens.setText("Coloque o seu e-mail e sua senha!")
        } else {

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener {

                    if (it.isSuccessful) {
                        Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT)
                            .show()
                        abrirTelaPrincipal()
                    }
                }.addOnFailureListener {

                    var erro = it

                    when {
                        erro is FirebaseAuthInvalidCredentialsException -> mensagens.setText("E-mail ou Senha estão incorretos!")
                        erro is FirebaseNetworkException -> mensagens.setText("Sem conexão com a internet!")
                        else -> mensagens.setText("Erro ao logar usuário")
                    }
                }
        }
    }

    private fun abrirTelaPrincipal() {

        var intent = Intent(this, TelaPrincipalActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun abrirTelaDeCadastro() {
        var intent = Intent(this, FormCadastroActivity::class.java)
        startActivity(intent)
    }

}
