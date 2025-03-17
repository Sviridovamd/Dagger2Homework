package ru.otus.daggerhomework

sealed class Event {
    data class ChangeColor(val color: Int) : Event()
}
