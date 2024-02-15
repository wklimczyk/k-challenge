package eu.batomobile.domain.usecase

import eu.batomobile.domain.entity.Kahoot
import eu.batomobile.domain.repository.KahootRepository
import eu.batomobile.domain.usecase.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetKahootUseCase(
    dispatcher: CoroutineDispatcher,
    private val kahootRepository: KahootRepository,
) :
    UseCase<Unit, Kahoot>(dispatcher) {
    override suspend fun executeInContext(param: Unit): Kahoot {
        return kahootRepository.getKahoot("fb4054fc-6a71-463e-88cd-243876715bc1")
    }
}