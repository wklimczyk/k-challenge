package eu.batomobile.data.service

import eu.batomobile.data.model.response.KahootResponse
import retrofit2.http.GET

internal interface KahootService {
    @GET("kahoots/{id}")
    suspend fun getKahoot(id: String): KahootResponse
}