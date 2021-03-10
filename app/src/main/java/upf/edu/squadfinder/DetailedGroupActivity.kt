package upf.edu.squadfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton
import upf.edu.squadfinder.ui.chat.ChatActivity

class DetailedGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalls_grup_membre)

        // showing the back button in action bar
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val chatGrupButton = findViewById<FloatingActionButton>(R.id.chatGrupButton)

        chatGrupButton.setOnClickListener {
            //Toast.makeText(this, "Clicked on the item", Toast.LENGTH_SHORT).show()
            val intentChat = Intent(this, ChatActivity::class.java).apply {}
            startActivity(intentChat)
        }

        // Botons per unirse i abandonar un esdeveniment
        val unirseGrupButton = findViewById<FloatingActionButton>(R.id.unirseGrupButton)
        val abandonarGrupButton = findViewById<FloatingActionButton>(R.id.abandonarGrupButton)
        // Layout que conte uns botons o altres
        val buttonsGrupNoMembre =findViewById<LinearLayout>(R.id.grupNoMembreButtons)
        val buttonsGrupMembre =findViewById<LinearLayout>(R.id.grupMembreButtons)

        // Quan l'usuari s'uneix fem desapareixer els button per unir-se i fem apareixer els d'abandonar.
        unirseGrupButton.setOnClickListener {
            // Mostrem els buttons
            buttonsGrupNoMembre.isVisible = false
            buttonsGrupMembre.isVisible = true
        }
        // Quan l'usuari abandona l'esdeveniment fem desapareixer els button per abandonar i fem apareixer els d'unir-se.
        abandonarGrupButton.setOnClickListener {
            buttonsGrupNoMembre.isVisible = true
            buttonsGrupMembre.isVisible = false
        }
    }

    // this event will enable the back function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }
}