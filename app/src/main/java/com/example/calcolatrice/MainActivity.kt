package com.example.calcolatrice


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException



class MainActivity : AppCompatActivity() {

    enum class Operazione
    {
        SOMMA, SOTTRAZIONE, MOLTIPLICAZIONE, DIVISIONE

    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSomma.setOnClickListener { calcola(Operazione.SOMMA) }
        btnSottr.setOnClickListener { calcola(Operazione.SOTTRAZIONE) }
        btnMolt.setOnClickListener { calcola(Operazione.MOLTIPLICAZIONE) }
        btnDiv.setOnClickListener { calcola(Operazione.DIVISIONE) }

    }


    private fun calcola(operazione: Operazione)
    {
        val op1 = editPrimo.text.toString()
        val op2 = editSecondo.text.toString()

        try
        {
            val a = op1.toDouble()
            val b = op2.toDouble()

            val risutato: Double

            when(operazione)
            {
                MainActivity.Operazione.SOMMA -> risutato= a+b
                MainActivity.Operazione.SOTTRAZIONE -> risutato = a-b
                MainActivity.Operazione.MOLTIPLICAZIONE -> risutato = a * b
                MainActivity.Operazione.DIVISIONE ->
                {
                    if (b != 0.0)
                    {
                        risutato = a/b
                    }
                    else
                    {
                        textRisutato.text = " non è possibile dividere per 0"
                        return
                    }
                }
            }

            textRisutato.text = risutato.toString()
        }
        catch (e: NumberFormatException)
        {
            textRisutato.text = "operandi non validi"
        }

    }
}