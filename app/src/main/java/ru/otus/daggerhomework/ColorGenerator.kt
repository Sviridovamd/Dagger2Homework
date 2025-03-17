package ru.otus.daggerhomework

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

interface ColorGenerator {

    @ColorInt
    fun generateColor(): Int
}

@Singleton
class ColorGeneratorImpl @Inject constructor() : ColorGenerator {
    override fun generateColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}
