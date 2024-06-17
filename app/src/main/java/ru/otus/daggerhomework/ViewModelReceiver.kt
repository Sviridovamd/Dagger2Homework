package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ViewModelReceiver(
    private val eventFlow: MutableStateFlow<Int>,
    private val context: Context
) : ViewModel() {

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}

class ViewModelReceiverFactory @Inject constructor(
    private val eventFlow: MutableStateFlow<Int>,
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelProducer::class.java)) {
            return ViewModelReceiver(eventFlow, context) as T
        }
        throw IllegalArgumentException()
    }
}