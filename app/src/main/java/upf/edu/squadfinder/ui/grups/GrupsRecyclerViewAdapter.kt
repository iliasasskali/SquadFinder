package upf.edu.squadfinder.ui.grups

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import upf.edu.squadfinder.DetailedGroupActivity
import upf.edu.squadfinder.R

class GrupsRecyclerViewAdapter : RecyclerView.Adapter<GrupsRecyclerViewAdapter.ViewHolder>() {

    private val groupNames = arrayOf(
        "Grup Running Osona",
        "CsGo Team \uD83D\uDCAA\uD83D\uDC8E",
        "Lliga de Debat UPF",
        "Federació Cat. Ciclisme",
        "Club Tennis Girona",
        "Club de Fans de Jar Jar")

    private val groupLangs = arrayOf(
        "Català",
        "English",
        "Català, Español, English",
        "Català, Español",
        "Català, Español",
        "Español, English")

    private val groupMembers = arrayOf(
        "13/1000",
        "4/10",
        "6/10",
        "134/1000",
        "97/100",
        "1/25")

    private val groupUbications = arrayOf(
        "Vic",
        "Online",
        "Barcelona",
        "Online",
        "Girona",
        "Barcelona")

    private val groupImages = arrayOf(
        R.drawable.running,
        R.drawable.gaming2,
        R.drawable.lligadebat,
        R.drawable.cycling,
        R.drawable.tennis,
        R.drawable.jarjar
    )

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var groupImage : ImageView
        var groupName : TextView
        //var groupDetail : TextView
        var groupSlots : TextView
        var groupUbication : TextView
        var groupLang : TextView

        init {
            groupImage = itemView.findViewById(R.id.group_image)
            groupName = itemView.findViewById(R.id.group_name)
            //groupDetail = itemView.findViewById(R.id.group_detail)
            groupSlots = itemView.findViewById(R.id.group_members)
            groupUbication = itemView.findViewById(R.id.group_ubication)
            groupLang = itemView.findViewById(R.id.group_lang)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_grups_model, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.groupName.text = groupNames[position]
        holder.groupSlots.text = groupMembers[position]
        holder.groupUbication.text = groupUbications[position]
        holder.groupImage.setImageResource(groupImages[position])
        holder.groupLang.text = groupLangs[position]

        // DETALL DEL GRUP, FET NOMÉS PEL 3R GRUP
        if (position == 2) {
            holder.itemView.setOnClickListener { v: View ->
                val intentDetallGrup = Intent(v.context, DetailedGroupActivity::class.java).apply {}
                v.context.startActivity(intentDetallGrup)
            }
        }

    }

    override fun getItemCount(): Int {
        return groupNames.size
    }
}