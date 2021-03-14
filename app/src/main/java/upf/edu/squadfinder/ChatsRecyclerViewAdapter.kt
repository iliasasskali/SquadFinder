package upf.edu.squadfinder

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import upf.edu.squadfinder.ui.chat.ChatActivity

class ChatsRecyclerViewAdapter : RecyclerView.Adapter<ChatsRecyclerViewAdapter.ViewHolder>() {
    private val chatNames = arrayOf("Grup AiSM", "Mitja Marató de Barcelona")

    private val chatMessages = arrayOf("Hola, Com estas?", "Voldria més info")

    private val chatTimes = arrayOf("17:00", "15:20")

    private val chatImages = arrayOf(R.drawable.upf, R.drawable.runnning_event)

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var chatImage : ImageView
        var chatName : TextView
        var chatTime : TextView
        var chatMessage : TextView

        init {
            chatImage = itemView.findViewById(R.id.chat_image)
            chatName = itemView.findViewById(R.id.chat_title)
            chatTime = itemView.findViewById(R.id.chat_time)
            chatMessage = itemView.findViewById(R.id.chat_msg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_chats_model, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.chatName.text = chatNames[position]
        holder.chatTime.text = chatTimes[position]
        holder.chatMessage.text = chatMessages[position]
        holder.chatImage.setImageResource(chatImages[position])


        holder.itemView.setOnClickListener { v: View ->
            val intentChat = Intent(v.context, ChatActivity::class.java).apply {}
            v.context.startActivity(intentChat)
        }
    }

    override fun getItemCount(): Int {
        return chatNames.size
    }
}