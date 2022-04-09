package utils

import org.javacord.api.DiscordApi
import org.javacord.api.DiscordApiBuilder

object API {
    val api: DiscordApi by lazy {
        val api = DiscordApiBuilder().setToken(CONSTANTS.BOT_TOKEN).login().join()
        api
    }
}