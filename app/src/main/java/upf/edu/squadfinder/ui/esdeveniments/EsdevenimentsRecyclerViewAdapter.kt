package upf.edu.squadfinder.ui.esdeveniments

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import upf.edu.squadfinder.DetailedEventActivity
import upf.edu.squadfinder.DetailedGroupActivity
import upf.edu.squadfinder.R

class EsdevenimentsRecyclerViewAdapter : RecyclerView.Adapter<EsdevenimentsRecyclerViewAdapter.ViewHolder>() {

    private val eventTitles = arrayOf(
            "Ruta Cicloturista",
            "Torneig CS GO",
            "Concert solidari BCN",
            "Aula Esport: Nutrició",
            "Protesta per ...",
            "Mitja Marató de Barcelona")

    private val eventDates = arrayOf(
        "25/03/2021, 17:00",
        "04/04/2021, 23:00",
        "04/04/2021, 20:00",
        "15/04/2021, 11:00",
        "25/04/2021, 09:00",
        "17/10/2021, 10:00")

    private val eventParticipants = arrayOf(
            "380/1000",
            "6/40",
            "120/8000",
            "10/50",
            "403/19",
            "650/8000")

    private val eventUbications = arrayOf(
        "Vic",
        "Online",
        "Barcelona",
        "Online",
        "Girona",
        "Barcelona")


    private val eventImages = arrayOf(
        R.drawable.cycling,
        R.drawable.gaming,
        R.drawable.concert,
        R.drawable.upf,
        R.drawable.protest,
        R.drawable.runnning_event
    )

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var eventImage : ImageView
        var eventTitle : TextView
        //var eventDetail : TextView
        var eventDate : TextView
        var eventUbication : TextView
        var eventParticipants : TextView

        init {
            eventImage = itemView.findViewById(R.id.event_image)
            eventTitle = itemView.findViewById(R.id.event_title)
            //eventDetail = itemView.findViewById(R.id.event_detail)
            eventDate = itemView.findViewById(R.id.event_dateTime)
            eventUbication = itemView.findViewById(R.id.event_ubication)
            eventParticipants = itemView.findViewById(R.id.event_participants)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_esdeveniments_model, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.eventTitle.text = eventTitles[position]
        //holder.eventDetail.text = eventDetails[position]
        holder.eventDate.text = eventDates[position]
        holder.eventUbication.text = eventUbications[position]
        holder.eventImage.setImageResource(eventImages[position])
        holder.eventParticipants.text = eventParticipants[position]

        if (position == 5) {
            holder.itemView.setOnClickListener { v: View ->
                // TODO: MOSTRAR DETALL ESDEVENIMENT
                // Toast.makeText(v.context, "Clicked on the item", Toast.LENGTH_SHORT).show()
                val intentDetallEsdeveniment = Intent(v.context, DetailedEventActivity::class.java).apply {}
                v.context.startActivity(intentDetallEsdeveniment)
            }
        }

    }

    override fun getItemCount(): Int {
        return eventTitles.size
    }
}