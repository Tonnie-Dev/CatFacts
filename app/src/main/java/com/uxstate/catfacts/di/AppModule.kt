package com.uxstate.catfacts.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.uxstate.catfacts.data.remote.CatAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCatAPI(): CatAPI {

        val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()

        return Retrofit.Builder()
                .baseUrl(CatAPI.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create()
    }
}