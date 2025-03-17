package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProducerViewModel @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val eventObserver: EventObserver,
    private val context: Context
) : ViewModel() {

    fun generateColor() {
        if (context !is Activity) throw RuntimeException("Activity context is required")
        val color = colorGenerator.generateColor()

        viewModelScope.launch {
            eventObserver.sendEvent(Event.ChangeColor(color))
        }

        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}
