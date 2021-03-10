package upf.edu.squadfinder

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import upf.edu.squadfinder.data.User
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
            val emailInputField = findViewById<EditText>(R.id.inputEmail)
            val passInputField = findViewById<EditText>(R.id.inputPass)
            val pass2InputField = findViewById<EditText>(R.id.inputPass2)

            //Check if the user can be registered
            var userBoxString: String = grupInputField.text.toString()
            var emailBoxString: String = emailInputField.text.toString()
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
                    Toast.makeText(this, "Error amb les dades", Toast.LENGTH_SHORT).show()
                }
                else if (userBoxString.length<=0){
                    Toast.makeText(this, "Problema amb el nom d'usuari", Toast.LENGTH_SHORT).show()
                }
                else if (!this.isValidEmail(emailBoxString)){
                    Toast.makeText(this, "El format de l'email és incorrecte", Toast.LENGTH_SHORT).show()
                }
                else if (passBoxString.length<=0){
                    Toast.makeText(this, "Problema amb la contrasenya", Toast.LENGTH_SHORT).show()
                }
                else {
                    var exists : Boolean = false
                    for (u in usersList){
                        if (userBoxString == u.userName){ //there can be more that one user with the same name
                            exists = true
                            break
                        }
                    }
                    if (exists) Toast.makeText(this, "L'usuari ja existeix", Toast.LENGTH_SHORT).show()
                    else {
                        //If the user is not already created we go to the home screen
                        val intentHome = Intent(this, HomeActivity::class.java).apply {}
                        startActivity(intentHome)
                    }
                }
            }
            else {
                Toast.makeText(this, "La segona contrasenya és diferent a la primera", Toast.LENGTH_SHORT).show()
            }
        }
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
            var (string1, string2, string3) = it.split(" ");
            string1 = string1.filter { !it.isWhitespace() } //for the name
            string2 = string2.filter { !it.isWhitespace() } //for the email
            string3 = string3.filter { !it.isWhitespace() } //for the password

            string1 = string1.toLowerCase()
            string2 = string2.toLowerCase()
            //string3 = string2.toLowerCase() the passward can be in lower or uppercase

            usersList.add(User(string1, string2, string3))  //Saving the class inside userList
        }

        return usersList;
    }

    //check if the email provided is correct ==> is in email format
    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    // this event will enable the back function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //val myIntent = Intent(this, MainActivity::class.java).apply {}
        //startActivity(myIntent)
        finish()
        return true
    }
}