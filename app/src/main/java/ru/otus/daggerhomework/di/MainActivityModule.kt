package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.EventObserver
import javax.inject.Singleton

@Module
object MainActivityModule {

    @Singleton
    @Provides
    fun provideEventObserver(): EventObserver = EventObserver()
}
