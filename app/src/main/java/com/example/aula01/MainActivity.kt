package com.example.aula01

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.text.ParseException

class MainActivity : AppCompatActivity() {
    private lateinit var etRaio: EditText
    private lateinit var tvPerimetro: TextView
    private lateinit var tvArea: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etRaio = findViewById(R.id.etRaio)
        tvPerimetro = findViewById(R.id.perimetro)
        tvArea = findViewById(R.id.area)

        etRaio.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                calcular()
            }
        })
    }

    private fun calcular(){
        if(etRaio.text.isEmpty()){
            tvArea.text = ""
            tvPerimetro.text = ""

            return
        }

        val raio = etRaio.text.toString().toDouble()
        val perimetro = 2 * Math.PI * raio
        val area = Math.PI * raio * raio

        tvArea.text = "%.2f".format(area)
        tvPerimetro.text = "%.2f".format(perimetro)
    }
}