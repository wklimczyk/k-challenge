package eu.batomobile.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eu.batomobile.domain.repository.KahootRepository
import eu.batomobile.domain.usecase.GetKahootUseCase
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun provideGetKahootUseCase(kahootRepository: KahootRepository): GetKahootUseCase =
        GetKahootUseCase(Dispatchers.IO, kahootRepository)
}