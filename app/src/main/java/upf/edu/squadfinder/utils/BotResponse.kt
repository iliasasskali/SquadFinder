package upf.edu.squadfinder.utils

import android.widget.Toast
import upf.edu.squadfinder.utils.Constants.OPEN_GOOGLE
import upf.edu.squadfinder.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "cara" else "creu"

                "E tirat una moneda i he obtingut $result"
            }


            //Math calculations
            message.contains("resol")-> {
                val equation: String? = message.substringAfterLast("resol")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Perdó, no ho puc resoldre, poc IQ...."
                }
            }

            //Hello
            message.contains("hola") || message.contains("ei") -> {
                when (random) {
                    0 -> "Hola, que tal!"
                    1 -> "Ei"
                    2 -> "Com vas!"
                    else -> "error" }
            }

            //How are you?
            message.contains("que tal") || message.contains("com estas")
                    || message.contains("i tu")-> {
                when (random) {
                    0 -> "Estic bé, gràcies!"
                    1 -> "Tinc una mica de gana..."
                    2 -> "Força bé i tu?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("hora") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("obre") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("busca")-> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "No t'entenc, perdó..."
                    1 -> "Prova de preguntar-me una altre cosa"
                    2 -> "No ho sé"
                    else -> "error"
                }
            }
        }
    }
}