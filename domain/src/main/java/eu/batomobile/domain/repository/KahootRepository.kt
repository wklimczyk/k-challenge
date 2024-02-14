package eu.batomobile.domain.repository

import eu.batomobile.domain.entity.Kahoot

interface KahootRepository {
    suspend fun getKahoot(id: String): Kahoot
}