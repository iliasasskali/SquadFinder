package upf.edu.squadfinder

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    // Animacions create button
    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_botton_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_botton_anim) }
    private var clicked = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val createGroupButton = findViewById<FloatingActionButton>(R.id.create_group_button)
        val createEventButton = findViewById<FloatingActionButton>(R.id.create_event_button)
        val createButton = findViewById<FloatingActionButton>(R.id.create_button)

        createButton.setOnClickListener {
            // Mostrar els butons per crear esdeveniments o grups
            onCreateButtonClicked(createGroupButton, createEventButton, createButton)
        }
        createGroupButton.setOnClickListener {
            // Anar a la pantalla de creacio de grups
            Toast.makeText(this, "CREACIÓ GRUP", Toast.LENGTH_SHORT).show()
        }
        createEventButton.setOnClickListener {
            // Anar a la pantalla de creacio d'esdeveniments
            Toast.makeText(this, "CREACIÓ ESDEVENIMENT", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onCreateButtonClicked(createGroupButton: FloatingActionButton, createEventButton: FloatingActionButton, createButton: FloatingActionButton) {
        setVisibility(clicked, createGroupButton, createEventButton)
        setAnimation(clicked, createGroupButton, createEventButton, createButton)
        clicked = !clicked
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
        }else{
            createGroupButton.visibility = View.INVISIBLE
            createEventButton.visibility = View.INVISIBLE
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
}