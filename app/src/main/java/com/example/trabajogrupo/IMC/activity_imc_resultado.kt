package com.example.trabajogrupo.IMC

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.trabajogrupo.Menu.MainActivity
import com.example.trabajogrupo.R

class activity_imc_resultado : AppCompatActivity() {


    private lateinit var pantalla2: TextView
    private lateinit var vuelta: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_resultado)


        val backgroundImageView = findViewById<ImageView>(R.id.backgroundImageView)


        pantalla2 = findViewById<TextView>(R.id.pantalla2)
        vuelta = findViewById(R.id.vueltaReseultado)
        val resultado = intent.getDoubleExtra("IMC_export", IMCActivity.IMC_export)

            if(resultado < 18.5){
                pantalla2.text = "Tu resultado es: " + resultado.toString() + "\nPeso inferior al normal"
                backgroundImageView.setImageResource(R.drawable.sudo)
            }
            if(resultado in 18.5..24.9){
                pantalla2.text = "Tu resultado es: " + resultado.toString() + "\nPeso normal"
                backgroundImageView.setImageResource(R.drawable.eddie)
            }
            if(resultado in 25.0..29.9){
                pantalla2.text = "Tu resultado es: " + resultado.toString() + "\nPeso superior al normal"
                backgroundImageView.setImageResource(R.drawable.fuerte)
            }
            if(resultado > 29.9){
                pantalla2.text = "Tu resultado es: " + resultado.toString() + "\nCuidadin, estás obeso"
                backgroundImageView.setImageResource(R.drawable.obelix)
            }

        vuelta.setOnClickListener{
            val intent = Intent(this, IMCActivity::class.java)
            startActivity(intent) }

    }


}