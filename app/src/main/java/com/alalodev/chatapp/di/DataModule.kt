package com.alalodev.chatapp.di

import android.content.Context
import com.alalodev.chatapp.data.database.DatabaseServiceImp
import com.alalodev.chatapp.data.network.FirebaseChatService
import com.alalodev.chatapp.domain.DatabaseService
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideDatabaseReference() = Firebase.database.reference

    @Singleton
    @Provides
    fun provideFirebaseService(reference: DatabaseReference) = FirebaseChatService(reference)

    @Singleton
    @Provides
    fun provideDatabaseService(@ApplicationContext context: Context): DatabaseService {
        return DatabaseServiceImp(context)
    }

}