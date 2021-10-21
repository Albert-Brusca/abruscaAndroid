package me.albertbruscamanchon.dam.comptador

import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.stream.DoubleStream.builder
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    internal lateinit var tapMeButton : Button
    internal lateinit var time : TextView
    internal lateinit var counter : TextView
    internal var contador = 0
    internal var temps = 60

    internal var appStarted = false
    internal lateinit var countDownTimer : CountDownTimer
    internal val initialCountDownTimer : Long = 10000
    internal val intervalCountDownTimer : Long = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCountdown()

        tapMeButton = findViewById(R.id.tapMeButton)
        time = findViewById(R.id.time)
        counter = findViewById(R.id.counter)

        tapMeButton.setOnClickListener{
            if (!appStarted) {
                startGame()
            }
            incrementCounter()

        }

//        time.text = temps.toString()
        time.text = getString(R.string.TimeText, temps)

    }

    private fun startGame() {
        countDownTimer.start()
        appStarted=true
    }

    private fun initCountdown() {
        countDownTimer = object : CountDownTimer(initialCountDownTimer,intervalCountDownTimer) {
            override fun onTick(millisUntilFinished: Long) {
                var timeLeft = millisUntilFinished / 1000
                time.text = timeLeft.toString()
            }

            override fun onFinish() {
                endGame()
            }
        }
    }

    private fun incrementCounter() {
        contador += 1
        counter.text = contador.toString()

    }

    private fun endGame() {
        Toast.makeText(this, getString(R.string.endGame), Toast.LENGTH_LONG).show()
    }
}