package com.bruce.project.gogolook.di

import com.bruce.project.gogolook.Api.PixabayApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Reusable
    @Provides
    fun provideGitApi(retrofit: Retrofit): PixabayApi =
        retrofit.create(PixabayApi::class.java)
}