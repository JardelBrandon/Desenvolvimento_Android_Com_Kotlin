package com.loja.lojavirtual

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.google.firebase.auth.FirebaseAuth
import com.loja.lojavirtual.Form.FormLoginActivity
import com.loja.lojavirtual.Fragments.CadastroProdutosActivity
import com.loja.lojavirtual.Fragments.ProdutosFragment
import kotlinx.android.synthetic.main.activity_form_login.*

class TelaPrincipalActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val produtosFragment = ProdutosFragment()
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.frame_container, produtosFragment)
        fragment.commit()

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(

            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close

        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.nav_produtos) {

            val produtosFragment = ProdutosFragment()
            val fragment = supportFragmentManager.beginTransaction()
            fragment.replace(R.id.frame_container, produtosFragment)
            fragment.commit()


        } else if (id == R.id.nav_cadastrar_produtos) {

            var intent = Intent(this, CadastroProdutosActivity::class.java)
            startActivity(intent)

        } else if (id == R.id.nav_contato) {

            enviarEmail()

        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.tela_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        val id = item!!.itemId
        if (id == R.id.action_settings) {

            FirebaseAuth.getInstance().signOut()
            voltarParaFormLogin()

        }

        return super.onOptionsItemSelected(item)
    }

    private fun voltarParaFormLogin() {

        var intent = Intent(this, FormLoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun enviarEmail() {

        val PACKAGEM_GOOGLEMAIL = "com.google.android.gm"
        val email = Intent(Intent.ACTION_SEND)
        email.putExtra(Intent.EXTRA_EMAIL, arrayOf("")) //Enviar e-mail
        email.putExtra(Intent.EXTRA_SUBJECT, "") // Enviar um assunto de e-mail
        email.putExtra(Intent.EXTRA_TEXT, "") // Definir um texto para o nosso e-mail

        // Configurações de apps de envio de e-mail
        email.type = "message/rec822"
        email.setPackage(PACKAGEM_GOOGLEMAIL)
        startActivity(Intent.createChooser(email, "Escolha o app de e-mail"))

    }

}
