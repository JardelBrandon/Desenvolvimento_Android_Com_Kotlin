package com.loja.lojavirtual.Form

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.loja.lojavirtual.R
import kotlinx.android.synthetic.main.activity_form_cadastro.*

class FormCadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)
        supportActionBar!!.hide()
        
        bt_cadastrar.setOnClickListener { 
            cadastrarUsuario()
        }

    }
    
    private fun cadastrarUsuario() {
        
        val email = edit_email.text.toString()
        val senha = edit_senha.text.toString()
        
        if (email.isEmpty() || senha.isEmpty()) {
            var snackbar = Snackbar.make(layout_cadastro, "Coloque o seu e-mail e sua senha!", Snackbar.LENGTH_INDEFINITE)
                .setBackgroundTint(Color.WHITE)
                .setTextColor(Color.BLACK)
                .setAction("Ok", View.OnClickListener {

                })
            snackbar.show()

        } else {
            
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener { 
                
                if (it.isSuccessful) {
                    var snackbar = Snackbar.make(layout_cadastro, "Cadastro realizado com sucesso!", Snackbar.LENGTH_INDEFINITE)
                        .setBackgroundTint(Color.WHITE)
                        .setTextColor(Color.BLACK)
                        .setAction("Ok", View.OnClickListener {

                            FirebaseAuth.getInstance().signOut()
                            voltarParaFormLogin()

                        })
                    snackbar.show()
                }
            }.addOnFailureListener {

                var snackbar = Snackbar.make(layout_cadastro, "Erro ao cadastrar usuário", Snackbar.LENGTH_INDEFINITE)
                    .setBackgroundTint(Color.WHITE)
                    .setTextColor(Color.BLACK)
                    .setAction("Ok", View.OnClickListener {

                    })
                snackbar.show()

            }
        }
        
    }

    private fun voltarParaFormLogin() {

        var intent = Intent(this, FormLoginActivity::class.java)
        startActivity(intent)
        finish()

    }
}
