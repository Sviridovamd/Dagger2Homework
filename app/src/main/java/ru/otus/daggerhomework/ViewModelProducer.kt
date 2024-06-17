package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val eventFlow: MutableStateFlow<Int>,
    private val context: Context
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}

class ViewModelProducerFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val eventFlow: MutableStateFlow<Int>,
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelProducer(colorGenerator, eventFlow, context) as T
    }
}