package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ProducerViewModel
import ru.otus.daggerhomework.ReceiverViewModel
import kotlin.reflect.KClass

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProducerViewModel::class)
    fun bindProducerViewModel(viewModel: ProducerViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReceiverViewModel::class)
    fun bindReceiverViewModel(viewModel: ReceiverViewModel): ViewModel
}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
