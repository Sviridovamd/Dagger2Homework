package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import javax.inject.Singleton

@Module
interface ColorGeneratorModule {

    @Binds
    @Singleton
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator
}
