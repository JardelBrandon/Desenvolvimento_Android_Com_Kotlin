package com.loja.lojavirtual.Form

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            //Toast.makeText(this, "Coloque o seu e-mail e sua senha!", Toast.LENGTH_SHORT).show()

            var snackbar = Snackbar.make(layout_cadastro, "Coloque o seu e-mail e sua senha!", Snackbar.LENGTH_SHORT)
                .setBackgroundTint(Color.WHITE)
                .setTextColor(Color.BLACK)
            snackbar.show()

        } else {
            
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener { 
                
                if (it.isSuccessful) {
                    Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {

                Toast.makeText(this, "Erro ao cadastrar usuário", Toast.LENGTH_SHORT).show()

            }
        }
        
    }
}
