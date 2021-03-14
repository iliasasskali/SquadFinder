package upf.edu.squadfinder

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import upf.edu.squadfinder.ui.chat.ChatActivity

class HomeActivity : AppCompatActivity() {
    // Animacions create button
    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_botton_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_botton_anim) }
    private var clicked = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // TODO: MIRAR SI FUNCIONA
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        //val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_esdeveniments, R.id.navigation_grups, R.id.navigation_meus_GE))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //get the FRAGMENT_ID
        val intent = intent
        //val intentFragment = intent.getIntExtra("FRAGMENT_ID")
        /*if (intentFragment != null) {
            //transaction.replace(R.id.navigation_meus_GE, appBarConfiguration)
            Toast.makeText(this, intentFragment, Toast.LENGTH_SHORT).show()
        }*/


        val createGroupButton = findViewById<FloatingActionButton>(R.id.create_group_button)
        val createEventButton = findViewById<FloatingActionButton>(R.id.create_event_button)
        val createButton = findViewById<FloatingActionButton>(R.id.create_button)

        createButton.setOnClickListener {
            // Mostrar els butons per crear esdeveniments o grups
            onCreateButtonClicked(createGroupButton, createEventButton, createButton)
        }
        createGroupButton.setOnClickListener {
            // Anar a la pantalla de creacio de grups
            //Toast.makeText(this, "CREACIÓ GRUP", Toast.LENGTH_SHORT).show()
            val intentCreateGroup = Intent(this, CreateGroupActivity::class.java).apply {}
            startActivity(intentCreateGroup)
        }
        createEventButton.setOnClickListener {
            // Anar a la pantalla de creacio d'esdeveniments
            //Toast.makeText(this, "CREACIÓ ESDEVENIMENT", Toast.LENGTH_SHORT).show()
            val intentCreateEvent = Intent(this, CreateEventActivity::class.java).apply {}
            startActivity(intentCreateEvent)
        }
    }

    private fun onCreateButtonClicked(createGroupButton: FloatingActionButton, createEventButton: FloatingActionButton, createButton: FloatingActionButton) {
        setVisibility(this.clicked, createGroupButton, createEventButton)
        setAnimation(this.clicked, createGroupButton, createEventButton, createButton)
        this.clicked = !this.clicked
    }

    private fun setAnimation(clicked: Boolean, createGroupButton: FloatingActionButton, createEventButton: FloatingActionButton, createButton: FloatingActionButton) {
        if(!clicked) {
            createGroupButton.startAnimation(fromBottom)
            createEventButton.startAnimation(fromBottom)
            createButton.startAnimation(rotateOpen)
        }else{
            createGroupButton.startAnimation(toBottom)
            createEventButton.startAnimation(toBottom)
            createButton.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(clicked: Boolean, createGroupButton: FloatingActionButton, createEventButton: FloatingActionButton) {
        if(!clicked) {
            createGroupButton.visibility = View.VISIBLE
            createEventButton.visibility = View.VISIBLE
            createGroupButton.setClickable(true)
            createEventButton.setClickable(true)
        }else{
            createGroupButton.visibility = View.GONE
            createEventButton.visibility = View.GONE
            createGroupButton.setClickable(false)
            createEventButton.setClickable(false)
        }
    }

    private fun setClickable(clicked: Boolean, createGroupButton: FloatingActionButton, createEventButton: FloatingActionButton) {
        if(!clicked) {
            createEventButton.isClickable = true
            createGroupButton.isClickable = true
        } else {
            createEventButton.isClickable = false
            createGroupButton.isClickable = false
        }
    }

    //this function shows the chat button on the toolbar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    //this function checks if the toolbar icons are clicked
    // where i got the imfo from --> https://developer.android.com/training/appbar/actions#kotlin
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_chat -> {
            val intentChats = Intent(this, ChatsActivity::class.java).apply {}
            startActivity(intentChats)
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}