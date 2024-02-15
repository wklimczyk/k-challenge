package eu.batomobile.data.service

import eu.batomobile.data.model.response.KahootResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface KahootService {
    @GET("kahoots/{id}")
    suspend fun getKahoot(@Path("id") id: String): KahootResponse
}