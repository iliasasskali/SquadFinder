package edu.upf.squadFinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import upf.edu.squadfinder.HomeActivity
import upf.edu.squadfinder.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // showing the back button in action bar
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val registerButton = findViewById<Button>(R.id.registerButton2)
        registerButton.setOnClickListener {
            //Toast.makeText(this, "S'ha pressionat el botó de registre", Toast.LENGTH_LONG).show()
            val grupInputField = findViewById<EditText>(R.id.inputGroup)
            val passInputField = findViewById<EditText>(R.id.inputPass)
            val nia1InputField = findViewById<EditText>(R.id.inputNIA1)
            //val nia2InputField = findViewById<EditText>(R.id.inputNIA2)
            val nias = arrayListOf<String>(nia1InputField.text.toString())
            //Toast.makeText(this, "El grup es "+grupInputField.text+", el password es "+passInputField.text+", el nia 1 es "+nia1InputField.text+" i el nia2 es "+nia2InputField.text, Toast.LENGTH_LONG).show()

            //S'ha de fer tota la logica de ifs i elses
            val intentHome = Intent(this, HomeActivity::class.java).apply {}
            startActivity(intentHome)
        }
    }

    // this event will enable the back function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val myIntent = Intent(this, MainActivity::class.java).apply {}
        startActivity(myIntent)
        return true
    }
}