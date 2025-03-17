package ru.otus.daggerhomework.di

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.EventObserver
import javax.inject.Singleton

@Module
object MainActivityModule {

    @Singleton
    @Provides
    fun provideEventObserver(): EventObserver = EventObserver()

    @Provides
    @Singleton
    fun provideContext(activity: Activity): Context = activity
}
