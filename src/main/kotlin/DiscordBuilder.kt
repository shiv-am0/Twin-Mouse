import JsonParsing.CoordinateJson
import utils.API.api
import utils.CONSTANTS
import java.awt.Robot

class DiscordBuilder {
    lateinit var coordinates: List<String>

    fun getChannels() {
        println(api.channels)
        for (cha in api.channels) {
            println(cha.toString())
        }
    }

    fun fetchCoordinates(data: String) {
        println("Data = $data")
        coordinates = data.split("&");
        val x = Integer.parseInt(coordinates[0])
        val y = Integer.parseInt(coordinates[1])

        moveMouse(x, y)

//        val generalChannel = api.getTextChannelById(CONSTANTS.GENERAL_CHANNEL)

//        generalChannel.ifPresent {
//            it.addMessageCreateListener { message ->
//                val data = message.messageContent
//                println("Data = $data")
//                coordinates = data.split("&");
//                val x = Integer.parseInt(coordinates[0])
//                val y = Integer.parseInt(coordinates[1])
////                val coordinateJson = CoordinateJson().fromJson(data)
////                val x = coordinateJson.x
////                val y = coordinateJson.y
//                println("X = $x   Y = $y")
//
//                moveMouse(x, y)
//            }
//        }
    }

    private fun moveMouse(x: Int?, y: Int?) {
        val robot = Robot()
        robot.mouseMove(x!!, y!!)
    }
}