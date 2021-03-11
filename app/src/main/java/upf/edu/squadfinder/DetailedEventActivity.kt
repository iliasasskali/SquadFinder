package upf.edu.squadfinder

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton
import upf.edu.squadfinder.ui.chat.ChatActivity

class DetailedEventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalls_esdeveniment_participant)

        // showing the back button in action bar
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val chatEsdevenimentButton = findViewById<FloatingActionButton>(R.id.chatEsdevenimentButton)
        chatEsdevenimentButton.setOnClickListener {
            //Toast.makeText(this, "Clicked on the item", Toast.LENGTH_SHORT).show()
            val intentChat = Intent(this, ChatActivity::class.java).apply {}
            startActivity(intentChat)
        }

        // Botons per unirse i abandonar un esdeveniment
        val unirseEsdevenimentButton = findViewById<FloatingActionButton>(R.id.unirseEsdevenimentButton)
        val abandonarEsdevenimentButton = findViewById<FloatingActionButton>(R.id.abandonarEsdevenimentButton)
        // Layout que conte uns botons o altres
        val buttonsEsdevenimentNoParticipant =findViewById<LinearLayout>(R.id.esdevenimentNoParticipantButtons)
        val buttonsEsdevenimentParticipant =findViewById<LinearLayout>(R.id.esdevenimentParticipantButtons)

        // Quan l'usuari s'uneix fem desapareixer els button per unir-se i fem apareixer els d'abandonar.
        unirseEsdevenimentButton.setOnClickListener {
            // Mostrem els buttons
            buttonsEsdevenimentNoParticipant.isVisible = false
            buttonsEsdevenimentParticipant.isVisible = true
            /* TODO: MIRAR SI CAL
            for (i in 0 until buttonsEsdevenimentNoParticipant.childCount) {
                val child: FloatingActionButton = buttonsEsdevenimentNoParticipant.getChildAt(i) as FloatingActionButton
                child.isEnabled = false
            }
            for (i in 0 until buttonsEsdevenimentParticipant.childCount) {
                val child: FloatingActionButton = buttonsEsdevenimentParticipant.getChildAt(i) as FloatingActionButton
                child.isEnabled = true
            }*/
        }
        // Quan l'usuari abandona l'esdeveniment fem desapareixer els button per abandonar i fem apareixer els d'unir-se.
        abandonarEsdevenimentButton.setOnClickListener {
            buttonsEsdevenimentNoParticipant.isVisible = true
            buttonsEsdevenimentParticipant.isVisible = false
            /* TODO: MIRAR SI CAL
            for (i in 0 until buttonsEsdevenimentNoParticipant.childCount) {
                val child: FloatingActionButton = buttonsEsdevenimentNoParticipant.getChildAt(i) as FloatingActionButton
                child.isEnabled = true
            }
            for (i in 0 until buttonsEsdevenimentParticipant.childCount) {
                val child: FloatingActionButton = buttonsEsdevenimentParticipant.getChildAt(i) as FloatingActionButton
                child.isEnabled = false
            }*/
        }

    }

    // this event will enable the back function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

}