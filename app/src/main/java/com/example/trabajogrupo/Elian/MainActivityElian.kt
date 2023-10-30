package com.example.trabajogrupo.Elian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.trabajogrupo.Menu.MainActivity
import com.example.trabajogrupo.R

class MainActivityElian : AppCompatActivity() {
    //texto donde van apareciendo nuestros parametros
    private lateinit var texto: TextView
    private lateinit var botones: List<Button>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_elian)

        inicBots()
        val calc = CalculoElian()
        for (i in botones.indices) {
            botones[i].setOnClickListener {
                val resultado = calc.BotonClick(i, botones[i].text.toString())
                if (resultado == "") {
                    mensError("Debe introducir dos numeros y una operación")
                }
                texto.text = resultado
            }
        }
        //calc.bucleBots(botones, texto)
        btnRegresarMenu()
    }

    private fun inicBots() {
        //lista de botones
        botones = listOf(
            findViewById(R.id.boton0),
            findViewById(R.id.boton1),
            findViewById(R.id.boton2),
            findViewById(R.id.boton3),
            findViewById(R.id.boton4),
            findViewById(R.id.boton5),
            findViewById(R.id.boton6),
            findViewById(R.id.boton7),
            findViewById(R.id.boton8),
            findViewById(R.id.boton9),
            findViewById(R.id.botonMas),
            findViewById(R.id.botonMenos),
            findViewById(R.id.botonPor),
            findViewById(R.id.botonEntre),
            findViewById(R.id.botonEquals),
            findViewById(R.id.botonCE),
            findViewById(R.id.botonCE1),
            findViewById(R.id.botonPunto)
        )

        texto = findViewById(R.id.texto)
    }

    private fun mensError(msj: String) {
        Toast.makeText(this, msj, Toast.LENGTH_LONG).show()
    }

    private fun btnRegresarMenu() {
        val btnRegresar = findViewById<Button>(R.id.botonVolver)
        btnRegresar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

