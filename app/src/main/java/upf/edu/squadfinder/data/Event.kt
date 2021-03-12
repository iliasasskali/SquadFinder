package upf.edu.squadfinder.data

import kotlinx.serialization.Serializable

// switch is the public private switch
@Serializable
data class Event(val title: String?, val numParticipants: Int?, val switch: Boolean, val description: String?, val location: String?) {}