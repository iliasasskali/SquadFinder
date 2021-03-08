package upf.edu.squadfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import upf.edu.squadfinder.data.User
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // showing the back button in action bar
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        //list to save the users in a array of Users
        var usersList = this.getListOfUsers()

        val registerButton = findViewById<Button>(R.id.registerButton2)
        registerButton.setOnClickListener {
            val grupInputField = findViewById<EditText>(R.id.inputGroup)
            val passInputField = findViewById<EditText>(R.id.inputPass)
            val pass2InputField = findViewById<EditText>(R.id.inputPass2)

            //Check if the user can be registered
            var userBoxString: String = grupInputField.text.toString()
            var passBoxString: String = passInputField.text.toString()
            var pass2BoxString: String = pass2InputField.text.toString()

            //Delete white spaces
            userBoxString = userBoxString.filter { !it.isWhitespace() }
            passBoxString = passBoxString.filter { !it.isWhitespace() }
            pass2BoxString = pass2BoxString.filter { !it.isWhitespace() }
            //to lowerCase
            userBoxString = userBoxString.toLowerCase()
            passBoxString = passBoxString.toLowerCase()
            pass2BoxString = pass2BoxString.toLowerCase()

            //check if the two passwards are the same
            if (passBoxString == pass2BoxString) {
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
                        if (userBoxString == u.userName){ //there can be more that one user with the same name
                            exists = true
                            break
                        }
                    }
                    if (exists) Toast.makeText(this,"L'usuari ja existeix", Toast.LENGTH_SHORT).show()
                    else {
                        //If the user is not already created we go to the home screen
                        val intentHome = Intent(this, HomeActivity::class.java).apply {}
                        startActivity(intentHome)
                    }
                }
            }
            else {
                Toast.makeText(this,"La segona contrasenya és diferent a la primera", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // this event will enable the back function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val myIntent = Intent(this, MainActivity::class.java).apply {}
        startActivity(myIntent)
        return true
    }

    //get the list of users from "database" ==> users.txt
    fun getListOfUsers(): List<User> {
        //list to save the users in a array of Users
        var usersList = mutableListOf<User>()
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

            usersList.add(User(string1, string2))  //Saving the class inside userList
        }

        return usersList;
    }
}