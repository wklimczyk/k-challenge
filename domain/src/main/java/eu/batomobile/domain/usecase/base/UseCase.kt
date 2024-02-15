package eu.batomobile.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext


abstract class UseCase<in TParam, out TResult>(private val dispatcher: CoroutineDispatcher) {

    protected abstract suspend fun executeInContext(param: TParam): TResult

    open suspend fun execute(param: TParam): TResult = withContext(dispatcher) {
        executeInContext(param)
    }

    suspend operator fun invoke(param: TParam): TResult = execute(param)
}

suspend operator fun <TResult> UseCase<Unit, TResult>.invoke(): TResult = execute(Unit)