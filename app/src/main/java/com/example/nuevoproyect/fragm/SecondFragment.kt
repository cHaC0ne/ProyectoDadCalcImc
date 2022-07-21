package com.example.nuevoproyect.fragm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.textclassifier.TextClassifier.NO_OP
import com.example.nuevoproyect.R
import com.example.nuevoproyect.databinding.FragmentFirstBinding
import com.example.nuevoproyect.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var b: FragmentSecondBinding
    private var num1 = 0
    private var num2 = 0
    private var operacion = NO_OP

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        b = FragmentSecondBinding.inflate(layoutInflater)
        b.tvPantalla.text = "0"



        b.button0.setOnClickListener {
            pressNum("0")
        }
        b.button1.setOnClickListener {
            pressNum("1")
        }
        b.button2.setOnClickListener {
            pressNum("2")
        }
        b.button3.setOnClickListener {
            pressNum("3")
        }
        b.button4.setOnClickListener {
            pressNum("4")
        }
        b.button5.setOnClickListener {
            pressNum("5")
        }
        b.button6.setOnClickListener {
            pressNum("6")
        }
        b.button7.setOnClickListener {
            pressNum("7")
        }
        b.button8.setOnClickListener {
            pressNum("8")
        }
        b.button9.setOnClickListener {
            pressNum("9")
        }




        b.buttonLimpiar.setOnClickListener {
            b.tvPantalla.text = "0"
            num1 = 0
            num2 = 0
            operacion = 0
        }



        b.buttonMenos.setOnClickListener {
            num1 = b.tvPantalla.text.toString().toInt()
            operacion = resta
            b.tvPantalla.text = "0"

        }

        b.buttonMas.setOnClickListener {
            num1 = b.tvPantalla.text.toString().toInt()
            operacion = suma
            b.tvPantalla.text = "0"



        }

        b.buttonDivi.setOnClickListener {
            num1 = b.tvPantalla.text.toString().toInt()
            operacion = division
            b.tvPantalla.text = "0"
        }

        b.buttonMulti.setOnClickListener {
            num1 = b.tvPantalla.text.toString().toInt()
            operacion = multiplicacion
            b.tvPantalla.text = "0"

        }
        b.buttonIgual.setOnClickListener {
            num2 = b.tvPantalla.text.toString().toInt()
            var resultado =
                when (operacion) {
                    suma -> num1 + num2
                    resta -> num1 - num2
                    multiplicacion-> num1 * num2
                    division-> num1 / num2
                    else -> 0
                }
            b.tvPantalla.text = resultado.toString()
        }


        b.buttonPunto.setOnClickListener {

        }
        return b.root

    }

    companion object {
        const val  suma = 1
        const val resta = 2
        const val division = 3
        const val multiplicacion = 4
        const val NO_OP = 0
    }


    fun pressNum(n:String){
        if (b.tvPantalla.text.length < 8)
            b.tvPantalla.text = b.tvPantalla.text.toString().plus(n).toInt().toString()


    }

}

        // Inflate the layout for this fragment




