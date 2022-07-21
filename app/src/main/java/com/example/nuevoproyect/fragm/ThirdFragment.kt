package com.example.nuevoproyect.fragm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.example.nuevoproyect.R
import com.example.nuevoproyect.databinding.FragmentSecondBinding
import com.example.nuevoproyect.databinding.FragmentThirdBinding
import com.google.android.material.snackbar.Snackbar


class ThirdFragment : Fragment() {
    private lateinit var b: FragmentThirdBinding


    private var altura = 150
    private var peso = 75
    private var dobleAltura = 2.25
    private var  IMC = 33.33

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        b = FragmentThirdBinding.inflate(layoutInflater)
        showTable()
        b.imageView.setOnClickListener{showTable()}

        b.sbAltura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {

                b.tvSBAltura.text = progress.toString().plus("/200")
                altura = progress



            }


            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                calcularIMC()

            }
        })
        b.sbPeso.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {

                b.tvSBPeso.text = progress.toString().plus("/150")
                peso = progress




            }


            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                calcularIMC()
            }
        })
        return b.root
    }


    private fun snackBar(){
        var obs = when(IMC){
            in 0.0..15.99 -> Snackbar.make(b.root, "Delgadez Severa", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.AzulOscuro))
                .setAction("Ver Tabla"){showTable()}.show()
            in 16.00..16.99 -> Snackbar.make(b.root, "Delgadez Moderada", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.Azul))
                .setAction("Ver Tabla"){showTable()}.show()
            in 17.00..18.49 -> Snackbar.make(b.root, "Delgadez Leve", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.AzulCeleste))
                .setAction("Ver Tabla"){showTable()}.show()
            in 18.50..24.99 -> Snackbar.make(b.root, "Peso Normal", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.Verde))
                .setAction("Ver Tabla"){showTable()}.show()
            in 25.00..29.99 -> Snackbar.make(b.root, "Preobesidad", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.VerdeCesped))
                .setAction("Ver Tabla"){showTable()}.show()
            in 30.00..34.99 -> Snackbar.make(b.root, "Obesidad Leve", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.Amarillo))
                .setAction("Ver Tabla"){showTable()}.show()
            in 35.00..40.00 -> Snackbar.make(b.root, "Obesidad Media", Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.Naranja))
                .setAction("Ver Tabla"){showTable()}.show()
            else -> Snackbar.make(b.root, "Obesidad Morvida",Snackbar.LENGTH_SHORT).setBackgroundTint(ContextCompat.getColor(this, R.color.Rojo))
                .setAction("Ver Tabla"){showTable()}.show()
        }


    }

}