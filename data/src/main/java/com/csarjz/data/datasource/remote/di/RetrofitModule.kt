package com.csarjz.data.datasource.remote.di

import com.csarjz.data.BuildConfig
import com.csarjz.data.datasource.remote.api.AppRestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val BASE_URL = "https://demo6889125.mockable.io/"

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(apiInterceptor: ApiInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = when {
            BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
            else -> HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
            .certificatePinner(SSLPinning.getPinnedCertificate())
            .addInterceptor(apiInterceptor)
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideAppRestApi(retrofit: Retrofit): AppRestApi = retrofit.create(AppRestApi::class.java)
}
