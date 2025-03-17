package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.SharedFlow
import ru.otus.daggerhomework.Event
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    ViewModelModule::class,
    ViewModelFactoryModule::class
])
interface ApplicationComponent {

    fun provideSharedFlow(): SharedFlow<Event>

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}
