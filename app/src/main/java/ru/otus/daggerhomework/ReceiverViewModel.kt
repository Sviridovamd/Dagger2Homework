package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class ReceiverViewModel @Inject constructor(
    val events: SharedFlow<Event>,
    private val context: Context
) : ViewModel() {

    fun observeColor(color: Int) {
        if (context !is Application) throw RuntimeException("Application context is required")
        Toast.makeText(context, "Color received: $color", Toast.LENGTH_LONG).show()
    }
}
