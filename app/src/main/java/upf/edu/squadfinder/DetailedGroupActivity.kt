package upf.edu.squadfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
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
    }

    // this event will enable the back function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }
}