package ru.otus.daggerhomework

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appContext = (application as App).appComponent.provideApplicationContext()
        Toast.makeText(this, "Context injected: $appContext", Toast.LENGTH_SHORT).show()
    }
}
