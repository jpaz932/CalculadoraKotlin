package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding : ActivityMainBinding

    var num1: Double = 0.0
    var num2: Double = 0.0
    var tipo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener { txtPantalla("1") }
        binding.btn2.setOnClickListener { txtPantalla("2") }
        binding.btn3.setOnClickListener { txtPantalla("3") }
        binding.btn4.setOnClickListener { txtPantalla("4") }
        binding.btn5.setOnClickListener { txtPantalla("5") }
        binding.btn6.setOnClickListener { txtPantalla("6") }
        binding.btn7.setOnClickListener { txtPantalla("7") }
        binding.btn8.setOnClickListener { txtPantalla("8") }
        binding.btn9.setOnClickListener { txtPantalla("9") }
        binding.btn0.setOnClickListener { txtPantalla("0") }

        binding.btnBorrar.setOnClickListener { reiniciar() }

        binding.btnSum.setOnClickListener { tipoOperacion("suma") }
        binding.btnRest.setOnClickListener { tipoOperacion("resta") }
        binding.btnMult.setOnClickListener { tipoOperacion("multiplicacion") }
        binding.btnDiv.setOnClickListener { tipoOperacion("division") }

        binding.btnTot.setOnClickListener { resultado() }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    fun txtPantalla(boton: String) {
        if(binding.txtResult.text == "0") binding.txtResult.text = ""
        binding.txtResult.text = "${binding.txtResult.text}$boton"
    }

    fun reiniciar() {
        binding.txtResult.text = "0"
        this.num1 = 0.0
        this.num2 = 0.0
        this.tipo = ""
    }

    fun tipoOperacion(operacion: String) {
        this.tipo = operacion
        this.num1 = binding.txtResult.text.toString().toDouble()
        binding.txtResult.text = "0"
    }

    fun resultado() {
        this.num2 = binding.txtResult.text.toString().toDouble()
        var resultado = when(this.tipo) {
            "suma" -> this.num1 + this.num2
            "resta" -> this.num1 + this.num2
            "multiplicacion" -> this.num1 * this.num2
            "division" -> this.num1 / this.num2
            else -> 0
        }
        if(resultado.toDouble().rem(1).equals(0.0))
            binding.txtResult.text = resultado.toDouble().toInt().toString()
        else
            binding.txtResult.text = resultado.toString()
    }
}