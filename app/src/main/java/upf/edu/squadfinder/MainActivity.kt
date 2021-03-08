package upf.edu.squadfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import upf.edu.squadfinder.ui.chat.ChatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            //Toast.makeText(this, "S'ha pressionat el botó de login", Toast.LENGTH_LONG).show()
            val intentLogin = Intent(this, LoginActivity::class.java).apply {}
            startActivity(intentLogin)
        }

        val registerButton = findViewById<Button>(R.id.registerButton)
        registerButton.setOnClickListener {
            //Toast.makeText(this, "S'ha pressionat el botó de registre", Toast.LENGTH_SHORT).show()
            val intentRegister = Intent(this, RegisterActivity::class.java).apply {}
            startActivity(intentRegister)
        }

        val chatButton = findViewById<Button>(R.id.chatButton)
        chatButton.setOnClickListener {
            val intentChat = Intent(this, ChatActivity::class.java).apply {}
            startActivity(intentChat)
        }
    }
}