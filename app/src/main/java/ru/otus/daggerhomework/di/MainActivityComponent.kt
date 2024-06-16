package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow

@Component(modules = [ObserverModule::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivityComponent
    }
}

@Module
class ObserverModule {

    @Provides
    fun provideEventFlow(): MutableStateFlow<String> {
        return MutableStateFlow("")
    }

}