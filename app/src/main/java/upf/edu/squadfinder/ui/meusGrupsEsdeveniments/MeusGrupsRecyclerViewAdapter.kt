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

    private val groupNames = arrayOf("Grup AiSM (Admin)", "Lliga de Debat UPF")
    private val groupMembers = arrayOf("3/3", "4/5")
    private val groupUbications = arrayOf("Online", "Barcelona")
    private val groupImages = arrayOf(R.drawable.upf, R.drawable.lligadebat)

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

        // Obrim el detall grup pel grup seguent:
        if (groupNames[position].equals("Lliga de Debat UPF")) {
            holder.itemView.setOnClickListener { v: View ->
                val intentDetallGrup = Intent(v.context, DetailedGroupActivity::class.java).apply {}
                v.context.startActivity(intentDetallGrup)
            }
        }
        /*if (groupNames[position].equals("Grup AiSM (Admin)")) {
            holder.itemView.setOnClickListener { v: View ->
                val intentDetallGrupCreador = Intent(v.context, DetailedGroupCreatorActivity::class.java).apply {}
                v.context.startActivity(intentDetallGrupCreador)
            }
        }*/

    }

    override fun getItemCount(): Int {
        return groupNames.size
    }
}

