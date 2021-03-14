package upf.edu.squadfinder

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class CreateGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_group)

        // showing the back button in action bar
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        //Saving the data into a class
        val inputTitle = findViewById<EditText>(R.id.titol)
        val inputnumParticipants = findViewById<EditText>(R.id.numParticipants)
        val switchPrivatePublic = findViewById<Switch>(R.id.switchPrivatePublic)
        val inputDescription = findViewById<TextInputLayout>(R.id.description)
        val buttonSave = findViewById<Button>(R.id.saveButton)

        var titleString: String = inputTitle.text.toString()
        var participantsString: String = inputnumParticipants.text.toString()
        var switchString: Boolean = switchPrivatePublic.isChecked()
        var descriptionString: String = inputDescription.toString()

        buttonSave.setOnClickListener {
            //creating an Event to store the data

            val intentHome = Intent(this, HomeActivity::class.java).apply {}
            intentHome.putExtra("FRAGMENT_ID", 1);
            startActivity(intentHome)
        }
    }

    // this event will enable the back function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }
}