package edu.upf.squadFinder

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.upf.squadFinder.data.Message
import kotlinx.android.synthetic.main.activity_register.*
import upf.edu.squadfinder.HomeActivity
import upf.edu.squadfinder.R
import java.io.BufferedReader
import java.io.File
import java.io.InputStream


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // showing the back button in action bar
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val inputGroup = findViewById<EditText>(R.id.userField)
        val inputPass = findViewById<EditText>(R.id.passField)
        val sendButton = findViewById<Button>(R.id.sendButton)

        //list to save the users in a array of Users
        var usersList = mutableListOf<Users>()
        //get the users.txt from the assets folder
        val assetInStream : InputStream = getAssets().open("users.txt")
        //reading the file line to line
        assetInStream.bufferedReader().forEachLine {
            //Splitting the line by one space
            var (string1, string2) = it.split(" ");
            string1 = string1.filter { !it.isWhitespace() } //for the name
            string2 = string2.filter { !it.isWhitespace() } //for the password

            string1 = string1.toLowerCase()
            string2 = string2.toLowerCase()

            usersList.add(Users(string1, string2))  //Saving the class inside userList
        }
        //

        sendButton.setOnClickListener {
            var userBoxString: String = inputGroup.text.toString()
            var passBoxString: String = inputPass.text.toString()

            //Delete white spaces
            userBoxString = userBoxString.filter { !it.isWhitespace() }
            passBoxString = passBoxString.filter { !it.isWhitespace() }
            //to lowerCase
            userBoxString = userBoxString.toLowerCase()
            passBoxString = passBoxString.toLowerCase()

            //logic --> in order to know if the boxes are filled
            if ((userBoxString.length<=0) && (passBoxString.length<=0)){
                Toast.makeText(this,"Error amb les dades", Toast.LENGTH_SHORT).show()
            }
            else if (userBoxString.length<=0){
                Toast.makeText(this,"Problema amb el nom d'usuari", Toast.LENGTH_SHORT).show()
            }
            else if (passBoxString.length<=0){
                Toast.makeText(this,"Problema amb la contrasenya", Toast.LENGTH_SHORT).show()
            }
            else {
                var exists : Boolean = false
                for (u in usersList){
                    if ((userBoxString == u.userName) && (passBoxString == u.userPassword)){
                        val intentHome = Intent(this, HomeActivity::class.java).apply {}
                        startActivity(intentHome)
                        exists = true
                        break
                    }
                }
                if (!exists) Toast.makeText(this,"L'usuari no existeix", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // this event will enable the back function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val myIntent = Intent(this, MainActivity::class.java).apply {}
        startActivity(myIntent)
        return true
    }
}

data class Users(val userName: String, val userPassword: String) {}