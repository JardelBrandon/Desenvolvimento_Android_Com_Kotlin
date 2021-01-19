package com.loja.lojavirtual.Form

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.loja.lojavirtual.R
import com.loja.lojavirtual.TelaPrincipalActivity
import kotlinx.android.synthetic.main.activity_form_login.*

class FormLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        supportActionBar!!.hide()

        text_tela_cadastro.setOnClickListener {
            var intent = Intent(this, FormCadastroActivity::class.java)
            startActivity(intent)
        }

        bt_entrar.setOnClickListener {

            autenticarUsuario()

        }
    }

    private fun autenticarUsuario() {

        val email = edit_email.text.toString()
        val senha = edit_senha.text.toString()

        if (email.isEmpty() || senha.isEmpty()) {

            var snackbar = Snackbar.make(layout_login, "Coloque um e-mail e uma senha!", Snackbar.LENGTH_INDEFINITE)
                .setBackgroundTint(Color.WHITE)
                .setTextColor(Color.BLACK)
                .setAction("Ok", View.OnClickListener {

                })

            snackbar.show()
        } else {

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener {

                if (it.isSuccessful) {

                    frame_layout.visibility = View.VISIBLE
                    Handler().postDelayed({abrirTelaPrincipal() }, 3000)

                }
            }.addOnFailureListener {

                var snackbar = Snackbar.make(layout_login, "Erro ao logar usuário!", Snackbar.LENGTH_INDEFINITE)
                    .setBackgroundTint(Color.WHITE)
                    .setTextColor(Color.BLACK)
                    .setAction("Ok", View.OnClickListener {

                    })

                snackbar.show()

            }
        }
    }

    private fun abrirTelaPrincipal() {
        var intent = Intent(this, TelaPrincipalActivity::class.java)
        startActivity(intent)
        finish()
    }
}
