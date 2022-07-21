package com.example.nuevoproyect.fragm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.nuevoproyect.R
import com.example.nuevoproyect.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var b: FragmentFirstBinding
    val cont = 0


    private val dados = arrayOf<Int>(
        R.drawable.dice1,
        R.drawable.img,
        R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentFirstBinding.inflate(layoutInflater)

        b.ivDado1.setOnClickListener {
            val dado1 = (1..6).random()
            val dado2 = (1..6).random()
            b.ivDado1.setImageResource(dados[dado1 - 1])
            b.ivDado2.setImageResource(dados[dado2 - 1])
            b.tvTotal.text = (dado1.plus(dado2)).toString()


        }
        b.ivDado2.setOnClickListener {
            val dado1 = (1..6).random()
            val dado2 = (1..6).random()
            b.ivDado1.setImageResource(dados[dado1 - 1])
            b.ivDado2.setImageResource(dados[dado2 - 1])
            b.tvTotal.text = (dado1.plus(dado2)).toString()
        }




        // FragmentFirstBinding.inflate(inflater, container, false)
        return b.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b.tvTotal.setOnClickListener {
            setFragmentResult("Paquete1", bundleOf("Primer dato" to b.tvTotal.text.toString()))

        }
    }
}