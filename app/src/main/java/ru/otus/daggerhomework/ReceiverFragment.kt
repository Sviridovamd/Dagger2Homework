package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ViewModelFactory
import javax.inject.Inject

class ReceiverFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: ReceiverViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: android.content.Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainActivityComponent
            .receiverFragmentComponent()
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_receiver, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.events.collect { event ->
                if (event is Event.ChangeColor) {
                    viewModel.observeColor(event.color)
                }
            }
        }
    }
}
