package me.albertbruscamanchon.dam.comptador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    internal lateinit var tapMeButton : Button
    internal lateinit var time : TextView
    internal lateinit var counter : TextView
    internal var contador = 0
    internal var temps = 60


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tapMeButton = findViewById(R.id.tapMeButton)
        time = findViewById(R.id.time)
        counter = findViewById(R.id.counter)

        // Actualitzar  o definir valor inicial de counter -> counter = score -> 0

        // TODO en algun moment haurem d'executar icrementCounter()

        tapMeButton.setOnClickListener{
            incrementCounter()

        }

//        time.text = temps.toString()
        time.text = getString(R.string.TimeText, temps)

        //TODO -> Iniciar el temps
    }

    private fun incrementCounter() {
        contador += 1
        counter.text = contador.toString()

    }
}