package ru.otus.daggerhomework.di

import android.app.Activity
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, MainActivityModule::class, ColorGeneratorModule::class])
interface MainActivityComponent {

    fun producerFragmentComponent(): ProducerFragmentComponent.Factory
    fun receiverFragmentComponent(): ReceiverFragmentComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): MainActivityComponent
    }
}
