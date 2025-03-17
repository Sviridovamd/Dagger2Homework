package ru.otus.daggerhomework

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    @Inject
    lateinit var eventObserver: EventObserver

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent.factory().create(this)
        mainActivityComponent.inject(this)
    }
}
