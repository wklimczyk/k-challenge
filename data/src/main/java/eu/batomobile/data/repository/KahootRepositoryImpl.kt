package eu.batomobile.data.repository

import eu.batomobile.data.mapper.KahootMapper
import eu.batomobile.data.service.KahootService
import eu.batomobile.domain.entity.Kahoot
import eu.batomobile.domain.repository.KahootRepository
import javax.inject.Inject

internal class KahootRepositoryImpl @Inject constructor(
    private val kahootMapper: KahootMapper,
    private val service: KahootService,
) : KahootRepository {
    override suspend fun getKahoot(id: String): Kahoot {
        val response = service.getKahoot(id)
        return kahootMapper.mapToEntity(response)
    }
}