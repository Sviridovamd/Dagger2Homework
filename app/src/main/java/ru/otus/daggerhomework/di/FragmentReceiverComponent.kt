package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@Component(dependencies = [ApplicationComponent::class])
interface FragmentReceiverComponent {
    @Component.Factory
    interface Factory {
        fun create(appComponent: ApplicationComponent): FragmentReceiverComponent
    }
}
