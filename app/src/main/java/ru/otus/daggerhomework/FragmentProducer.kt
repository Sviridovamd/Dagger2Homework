package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var appContext: Context

    @Inject
    lateinit var eventFlow: MutableStateFlow<String>

    @Inject
    lateinit var viewModelProducerFactory: ViewModelProducerFactory

    private val viewModelProducer: ViewModelProducer by viewModels { viewModelProducerFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentProducerComponent.factory()
            .create((requireActivity().application as App).applicationComponent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModelProducer.generateColor()
        }
    }
}
