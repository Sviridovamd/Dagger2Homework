package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventObserver @Inject constructor() {
    private val _events = MutableStateFlow<Event?>(null)
    val events: StateFlow<Event?> = _events

    fun sendEvent(event: Event) {
        _events.value = event
    }
}
