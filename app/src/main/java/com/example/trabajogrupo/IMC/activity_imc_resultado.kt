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
    private lateinit var backgroundImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_resultado)


        LlamadaComponente()

        Resultado()

        BotonVuelta()
    }


    /**
     * Función que llama a cada componente.
     */
    fun LlamadaComponente(){
        pantalla2 = findViewById<TextView>(R.id.pantalla2)
        vuelta = findViewById(R.id.vueltaReseultado)

        backgroundImageView = findViewById<ImageView>(R.id.backgroundImageView)
    }

    /**
     * Depende del valor del resultado, enviará un mensaje sobre el peso con su respectiva imagen.
     */

    fun Resultado(){
        val resultado = intent.getDoubleExtra("IMC_export", IMCActivity.IMC_export)

        if(resultado < 18.5){
            // Si es inferior a 18.5 el peso es inferior al normal.
            pantalla2.text = "Tu resultado es: " + resultado.toString() + "\nPeso inferior al normal"
            backgroundImageView.setImageResource(R.drawable.sudo)
        }
        if(resultado in 18.5..24.9){
            // Si está entre 18.5 y 24.9 el peso es normal.
            pantalla2.text = "Tu resultado es: " + resultado.toString() + "\nPeso normal"
            backgroundImageView.setImageResource(R.drawable.eddie)
        }
        if(resultado in 25.0..29.9){
            // Si está entre 25 y 29.9 el peso es superior al normal.
            pantalla2.text = "Tu resultado es: " + resultado.toString() + "\nPeso superior al normal"
            backgroundImageView.setImageResource(R.drawable.fuerte)
        }
        if(resultado > 29.9){
            // Si es superior a 29.9 el peso es de persona obesa.
            pantalla2.text = "Tu resultado es: " + resultado.toString() + "\nCuidadin, estás obeso"
            backgroundImageView.setImageResource(R.drawable.obelix)
        }
    }

    /**
     *  Retorna a la pantalla anterior.
     */

    fun BotonVuelta(){
        vuelta.setOnClickListener{
            val intent = Intent(this, IMCActivity::class.java)
            startActivity(intent) }
    }
}