package upf.edu.squadfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
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
    }

    // this event will enable the back function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

}