package upf.edu.squadfinder

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.textfield.TextInputLayout
import upf.edu.squadfinder.data.Event
import upf.edu.squadfinder.ui.meusGrupsEsdeveniments.MeusGEFragment
import upf.edu.squadfinder.ui.meusGrupsEsdeveniments.MeusGERecyclerViewAdapter


class CreateEventActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        // showing the back button in action bar
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)

        //Saving the data into a class
        val inputTitle = findViewById<EditText>(R.id.titol)
        val inputnumParticipants = findViewById<EditText>(R.id.numParticipants)
        val switchPrivatePublic = findViewById<Switch>(R.id.switchPrivatePublic)
        val inputDescription = findViewById<TextInputLayout>(R.id.description)

        var titleString: String = inputTitle.text.toString()
        var participantsString: String = inputnumParticipants.text.toString()
        var switchString: Boolean = switchPrivatePublic.isChecked()
        var descriptionString: String = switchPrivatePublic.text.toString()

        //creating an Event to store the data
        val event : Event = this.createEvent(titleString, participantsString, switchString, descriptionString)

        val intent = Intent(baseContext, MeusGERecyclerViewAdapter::class.java)
        intent.putExtra("ADD_EVENT", event)
        startActivity(intent)
    }

    //create a class Event
    fun createEvent(title: String, participants: String, switch: Boolean, description: String): Event {
        val participantsInt = participants.toInt()
        return Event(title, participantsInt, switch, description, null);
    }

    // this event will enable the back function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

    //funtion to show to map
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