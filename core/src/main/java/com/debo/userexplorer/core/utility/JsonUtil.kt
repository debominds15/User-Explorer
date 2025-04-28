package com.debo.userexplorer.core.utility

import com.google.gson.Gson
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.net.URLEncoder

object JsonUtil {
    fun <T> toJson(anyObject: T): String {
        try {
            val userJson = Gson().toJson(anyObject)
            return URLEncoder.encode(userJson, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }
        return ""
    }

    inline fun <reified T> fromJson(encodedJson: String): T? {
        return try {
            val decodedJson = URLDecoder.decode(encodedJson, "UTF-8")
            Gson().fromJson(decodedJson, T::class.java)
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
            null
        }
    }
}