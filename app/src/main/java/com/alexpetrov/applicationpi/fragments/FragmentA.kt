package com.alexpetrov.applicationpi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alexpetrov.applicationpi.databinding.FragmentABinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.math.BigDecimal

class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding
    private var resultOne = BigDecimal(3)
    private var counterOne: Double = 0.0
    private var showOne = ""
    private var formula: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding
            .inflate(inflater, container, false)

        main()
        return binding.root
    }

    private fun main() {

        GlobalScope.launch {
            val coroutineFlow = oneScreen()
            coroutineFlow.collect {}
        }
    }

    private fun oneScreen() = flow {
        emit(100)

        while (true) {
            counterOne += 1
            if (counterOne % 2 == 1.0) {
                formula = counterOne * 2 * (counterOne * 2 + 1) * (counterOne * 2 + 2)
                resultOne += (BigDecimal(4).divide(BigDecimal(formula), 300, 0))

            } else {
                formula = counterOne * 2 * (counterOne * 2 + 1) * (counterOne * 2 + 2)
                resultOne -= (BigDecimal(4).divide(BigDecimal(formula), 300, 0))
            }

            showOne = resultOne.toString()
            if (counterOne % 1000 == 0.0) {
                binding.textViewA.text = showOne
            }
        }

    }.flowOn(Dispatchers.IO)

    companion object {
        @JvmStatic
        fun newInstance() = FragmentA()
    }
}

