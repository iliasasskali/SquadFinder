package upf.edu.squadfinder.data

import java.io.Serializable

// switch is the public private switch
data class Event(val title: String, val numParticipants: Int, val switch: Boolean, val description: String, val location: String?) : Serializable {}