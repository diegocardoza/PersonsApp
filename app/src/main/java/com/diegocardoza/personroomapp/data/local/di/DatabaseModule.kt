package com.diegocardoza.personroomapp.data.local.di

import android.content.Context
import androidx.room.Room
import com.diegocardoza.personroomapp.data.local.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val PERSON_DATABASE_NAME = "person_db"

    @Provides
    @Singleton
    fun providePersonDatabase(
        @ApplicationContext context: Context
    ): PersonDatabase =
        Room.databaseBuilder(
            context,
            PersonDatabase::class.java,
            PERSON_DATABASE_NAME
        ).build()
}