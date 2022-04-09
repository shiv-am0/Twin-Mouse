package JsonParsing

import com.google.gson.Gson

class CoordinateJson() {
    var x: Int? = null;
    var y: Int? = null;

    fun fromJson(data: String): CoordinateJson {
        val gson = Gson()
        gson.newBuilder().setPrettyPrinting().create();
        return gson.fromJson(data, CoordinateJson::class.java)
    }
}