package eu.batomobile.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eu.batomobile.data.repository.KahootRepositoryImpl
import eu.batomobile.domain.repository.KahootRepository

@Module
@InstallIn(SingletonComponent::class)
internal abstract class InternalDataModule {
    @Binds
    abstract fun bindKahootRepo(impl: KahootRepositoryImpl): KahootRepository
}