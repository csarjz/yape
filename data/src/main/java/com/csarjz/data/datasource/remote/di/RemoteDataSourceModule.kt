package com.csarjz.data.datasource.remote.di

import com.csarjz.data.datasource.remote.api.recipe.RecipeRemoteDataSource
import com.csarjz.data.datasource.remote.api.recipe.RecipeRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindRecipeRemoteDataSource(
        recipeRemoteDataSourceImpl: RecipeRemoteDataSourceImpl
    ): RecipeRemoteDataSource
}
