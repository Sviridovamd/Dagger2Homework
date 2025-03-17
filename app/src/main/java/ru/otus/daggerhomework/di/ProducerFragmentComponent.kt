package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.otus.daggerhomework.ProducerFragment

@Subcomponent
interface ProducerFragmentComponent {
    fun inject(fragment: ProducerFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: ProducerFragment): ProducerFragmentComponent
    }
}
