package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@Component(dependencies = [ApplicationComponent::class])
interface FragmentProducerComponent {
    @Component.Factory
    interface Factory {
        fun create(appComponent: ApplicationComponent): FragmentProducerComponent
    }
}
