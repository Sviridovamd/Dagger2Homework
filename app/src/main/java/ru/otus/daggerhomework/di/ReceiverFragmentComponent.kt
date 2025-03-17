package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.ReceiverFragment

@Subcomponent
interface ReceiverFragmentComponent {
    fun inject(fragment: ReceiverFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: ReceiverFragment): ReceiverFragmentComponent
    }
}
