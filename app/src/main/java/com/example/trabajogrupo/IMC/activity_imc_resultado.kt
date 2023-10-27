package com.example.trabajogrupo.IMC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.trabajogrupo.R

class activity_imc_resultado : AppCompatActivity() {


    private lateinit var pruebaImc : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_resultado)

        pruebaImc = findViewById(R.id.pruebaDelImc)

        pruebaImc.setOnClickListener {
            val parametroIMCexport = intent.getStringExtra(IMCActivity.IMC_export)
            println(parametroIMCexport)
        }

    }


}