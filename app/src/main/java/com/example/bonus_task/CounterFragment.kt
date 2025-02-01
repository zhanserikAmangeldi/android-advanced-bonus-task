package com.example.bonus_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class CounterFragment : Fragment() {
    private lateinit var viewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(CounterViewModel::class.java)

        val tvCount = view.findViewById<TextView>(R.id.tv_count)
        val btnIncrement = view.findViewById<Button>(R.id.btn_increment)

        viewModel.count.observe(viewLifecycleOwner) { count ->
            tvCount.text = count.toString()
        }

        btnIncrement.setOnClickListener {
            viewModel.increment()
        }
    }
}