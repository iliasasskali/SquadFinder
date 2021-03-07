package upf.edu.squadfinder.ui.grups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import upf.edu.squadfinder.R

class GrupsRecyclerViewAdapter : RecyclerView.Adapter<GrupsRecyclerViewAdapter.ViewHolder>() {

    private val groupNames = arrayOf(
        "Grup Running BCN",
        "CsGo Team",
        "Grup debat UPF",
        "Grup 4",
        "Grup 5",
        "Grup 6")

    /*private val groupDetails = arrayOf(
            "Començarem a Vic i farem la ruta...",
            "Qualsevol nivell, uneix-te i t'afegirem a un equip.",
            "Conert a BCN... info...",
            "Aula esport: Nutrició i rendiment...",
            "Informació de la protesta...",
            "Inscriute a http://edreamsmitjabarcelona.com/inscripcion/")*/

    private val groupMembers = arrayOf(
        "13/1000",
        "4/10",
        "4/5",
        "134/1000",
        "97/100",
        "11/25")

    private val groupUbications = arrayOf(
        "Vic",
        "Online",
        "Barcelona",
        "Online",
        "Girona",
        "Barcelona")

    private val groupImages = arrayOf(
        R.drawable.running2,
        R.drawable.gaming2,
        R.drawable.debat,
        R.drawable.upf,
        R.drawable.band,
        R.drawable.cycling2
    )

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var groupImage : ImageView
        var groupName : TextView
        //var groupDetail : TextView
        var groupSlots : TextView
        var groupUbication : TextView

        init {
            groupImage = itemView.findViewById(R.id.group_image)
            groupName = itemView.findViewById(R.id.group_name)
            //groupDetail = itemView.findViewById(R.id.group_detail)
            groupSlots = itemView.findViewById(R.id.group_members)
            groupUbication = itemView.findViewById(R.id.group_ubication)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_grups_model, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.groupName.text = groupNames[position]
        //holder.eventDetail.text = eventDetails[position]
        holder.groupSlots.text = groupMembers[position]
        holder.groupUbication.text = groupUbications[position]
        holder.groupImage.setImageResource(groupImages[position])

        holder.itemView.setOnClickListener { v: View ->
            // TODO: MOSTRAR DETALL ESDEVENIMENT
            Toast.makeText(v.context, "Clicked on the item", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return groupNames.size
    }
}