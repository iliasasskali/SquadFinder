package upf.edu.squadfinder

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import upf.edu.squadfinder.ui.chat.ChatActivity


class DetailedEventActivity : OnMapReadyCallback, AppCompatActivity() {

    private lateinit var mMap: GoogleMap

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalls_esdeveniment_participant)

        // showing the back button in action bar
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val scroll = findViewById<NestedScrollView>(R.id.NestedScrollView)
        val transparent = findViewById<ImageView>(R.id.transparent_image)

        transparent.setOnTouchListener { v, event ->
            val action = event.action
            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    // Disallow ScrollView to intercept touch events.
                    scroll.requestDisallowInterceptTouchEvent(true)
                    // Disable touch on transparent view
                    false
                }
                MotionEvent.ACTION_UP -> {
                    // Allow ScrollView to intercept touch events.
                    scroll.requestDisallowInterceptTouchEvent(false)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    scroll.requestDisallowInterceptTouchEvent(true)
                    false
                }
                else -> true
            }
        }


        val chatEsdevenimentButton = findViewById<FloatingActionButton>(R.id.chatEsdevenimentButton)
        chatEsdevenimentButton.setOnClickListener {
            //Toast.makeText(this, "Clicked on the item", Toast.LENGTH_SHORT).show()
            val intentChat = Intent(this, ChatActivity::class.java).apply {}
            startActivity(intentChat)
        }

        /*val mapEsdevenimentButton = findViewById<ImageView>(R.id.mapView)
        mapEsdevenimentButton.setOnClickListener {
            //Toast.makeText(this, "Clicked on the item", Toast.LENGTH_SHORT).show()
            val intentMaps = Intent(this, MapsActivity::class.java).apply {}
            startActivity(intentMaps)
        }*/

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

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val location = LatLng(41.391050, 2.185880)
        // Move the camera instantly to Sydney with a zoom of 15.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))

        mMap.addMarker(MarkerOptions().position(location).title("Barcelona"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location))
    }

}