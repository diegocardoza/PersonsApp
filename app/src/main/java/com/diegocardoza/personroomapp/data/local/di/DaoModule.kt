package com.diegocardoza.personroomapp.data.local.di

import com.diegocardoza.personroomapp.data.local.PersonDatabase
import com.diegocardoza.personroomapp.data.local.dao.PersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun bindPersonDao(db: PersonDatabase): PersonDao = db.getPersonDao()

}