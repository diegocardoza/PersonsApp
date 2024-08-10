package com.diegocardoza.personroomapp.data.di

import com.diegocardoza.personroomapp.data.repository.PersonRepositoryImpl
import com.diegocardoza.personroomapp.domain.repository.PersonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PersonRepositoryModule {

    @Binds
    abstract fun bindsPersonRepository(impl: PersonRepositoryImpl): PersonRepository

}