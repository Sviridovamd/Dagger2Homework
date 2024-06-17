package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ViewModelProducerFactory
import ru.otus.daggerhomework.ViewModelReceiverFactory

@Component(modules = [ObserverModule::class])
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivityComponent
    }
}

@Module
interface ObserverModule {

    companion object {
        @Provides
        fun provideEventFlow(): MutableStateFlow<Int> {
            return MutableStateFlow(0)
        }

        @Provides
        fun provideViewModelProducerFactory(
            colorGenerator: ColorGenerator,
            eventFlow: MutableStateFlow<Int>,
            context: Context
        ): ViewModelProducerFactory {
            return ViewModelProducerFactory(colorGenerator, eventFlow, context)
        }

        @Provides
        fun provideViewModelReceiverFactory(
            eventFlow: MutableStateFlow<Int>,
            context: Context
        ): ViewModelReceiverFactory {
            return ViewModelReceiverFactory(eventFlow, context)
        }
    }

    @Binds
    fun bindsColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

}