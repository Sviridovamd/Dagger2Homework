package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent.factory().create(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_a, FragmentProducer())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_b, FragmentReceiver())
            .addToBackStack(null)
            .commit()

    }
}