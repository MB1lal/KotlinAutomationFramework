package utils

import com.google.gson.Gson

interface ToJson {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}