package upf.edu.squadfinder.ui.meusGrupsEsdeveniments

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import upf.edu.squadfinder.DetailedGroupActivity
import upf.edu.squadfinder.R
import java.security.AccessController.getContext

class MeusGrupsRecyclerViewAdapter : RecyclerView.Adapter<MeusGrupsRecyclerViewAdapter.ViewHolder>() {

    private val groupNames = arrayOf("Grup debat UPF")
    private val groupMembers = arrayOf("4/5")
    private val groupUbications = arrayOf("Barcelona")
    private val groupImages = arrayOf(R.drawable.lligadebat)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var groupImage: ImageView
        var groupName: TextView
        var groupUbication: TextView
        var groupMembers: TextView

        init {
            groupImage = itemView.findViewById(R.id.group_image)
            groupName = itemView.findViewById(R.id.group_name)
            groupUbication = itemView.findViewById(R.id.group_ubication)
            groupMembers = itemView.findViewById(R.id.group_members)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_grups_model, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.groupName.text = groupNames[position]
        holder.groupUbication.text = groupUbications[position]
        holder.groupImage.setImageResource(groupImages[position])
        holder.groupMembers.text = groupMembers[position]

        if (position == 5) {
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

