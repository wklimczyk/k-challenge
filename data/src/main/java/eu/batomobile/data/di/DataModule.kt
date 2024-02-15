package eu.batomobile.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eu.batomobile.data.provider.ApiPathProvider
import eu.batomobile.data.provider.ProdApiPathProviderImpl
import eu.batomobile.data.service.KahootService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    @Provides
    internal fun provideRetrofit(
        httpClient: OkHttpClient,
        apiPathProvider: ApiPathProvider,
        converter: Converter.Factory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(apiPathProvider.getApiPath())
            .addConverterFactory(converter)
            .client(httpClient)
            .build()

    @Provides
    fun provideGsonConverterFactory(): Converter.Factory =
        GsonConverterFactory.create()

    @Provides
    internal fun provideApiPathProvider(): ApiPathProvider =
        ProdApiPathProviderImpl()

    @Provides
    internal fun provideKahootService(retrofit: Retrofit): KahootService =
        retrofit.create(KahootService::class.java)
}