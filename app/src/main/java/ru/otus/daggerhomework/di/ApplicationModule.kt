package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.SharedFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.Event
import ru.otus.daggerhomework.EventObserver
import javax.inject.Singleton

@Module
object ApplicationModule {

    @Provides
    @Singleton
    fun provideEventObserver(): EventObserver = EventObserver()

    @Provides
    @Singleton
    fun provideSharedFlow(eventObserver: EventObserver): SharedFlow<Event> = eventObserver.events
}

