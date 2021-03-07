package upf.edu.squadfinder.ui.meusGrupsEsdeveniments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import upf.edu.squadfinder.R

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val eventTitles = arrayOf(
            "Ruta Cicloturista",
            "Torneig CS GO",
            "Concert solidari BCN",
            "Aula Esport: Nutrició",
            "Protesta per ...",
            "Mitja Marató de Barcelona")

    /*private val eventDetails = arrayOf(
            "Començarem a Vic i farem la ruta...",
            "Qualsevol nivell, uneix-te i t'afegirem a un equip.",
            "Conert a BCN... info...",
            "Aula esport: Nutrició i rendiment...",
            "Informació de la protesta...",
            "Inscriute a http://edreamsmitjabarcelona.com/inscripcion/")*/

    private val eventDates = arrayOf(
        "25/03/2021, 17:00",
        "04/04/2021, 23:00",
        "04/04/2021, 20:00",
        "15/04/2021, 11:00",
        "25/04/2021, 09:00",
        "17/10/2021, 10:00")

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
        R.drawable.running
    )

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var eventImage : ImageView
        var eventTitle : TextView
        //var eventDetail : TextView
        var eventDate : TextView
        var eventUbication : TextView

        init {
            eventImage = itemView.findViewById(R.id.event_image)
            eventTitle = itemView.findViewById(R.id.event_title)
            //eventDetail = itemView.findViewById(R.id.event_detail)
            eventDate = itemView.findViewById(R.id.event_dateTime)
            eventUbication = itemView.findViewById(R.id.event_ubication)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_model, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.eventTitle.text = eventTitles[position]
        //holder.eventDetail.text = eventDetails[position]
        holder.eventDate.text = eventDates[position]
        holder.eventUbication.text = eventUbications[position]
        holder.eventImage.setImageResource(eventImages[position])

        holder.itemView.setOnClickListener { v: View ->
            // TODO: MOSTRAR DETALL ESDEVENIMENT
            Toast.makeText(v.context, "Clicked on the item", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return eventTitles.size
    }
}