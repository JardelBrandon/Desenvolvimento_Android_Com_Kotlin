package com.netflix.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import kotlinx.android.synthetic.main.activity_form_cadastro.*

class FormCadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)

        bt_cadastrar.setOnClickListener {

            cadastrarUsuario()
        }
    }

    private fun cadastrarUsuario() {

        var email = edit_email.text.toString()
        var senha = edit_senha.text.toString()
        var mensagens = mensagem_erro

        if(email.isEmpty() || senha.isEmpty()) {
            mensagens.setText("Coloque o seu e-mail e sua senha!")
        } else {

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener {

                if(it.isSuccessful) {
                    Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {

                var erro = it

                when {
                    erro is FirebaseAuthWeakPasswordException -> mensagens.setText("Digite uma senha com no mínimo 6 caracteres!")
                    erro is FirebaseAuthInvalidCredentialsException -> mensagens.setText("Digite um e-mail válido!")
                    erro is FirebaseAuthUserCollisionException -> mensagens.setText("Esta conta já foi cadastrada!")
                    erro is FirebaseNetworkException -> mensagens.setText("Sem conexão com a internet!")
                    else -> mensagens.setText("Erro ao cadastrar usuário!")
                }
            }
        }
    }
}
