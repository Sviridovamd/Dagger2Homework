package ru.otus.daggerhomework.di

import android.app.Activity
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.EventObserver
import ru.otus.daggerhomework.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    fun eventObserver(): EventObserver

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance activityContext: Activity): MainActivityComponent
    }
}
