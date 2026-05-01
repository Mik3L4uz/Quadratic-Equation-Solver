package com.example.second_grade_equation_analisys

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    lateinit var a : TextView

    lateinit var b : TextView

    lateinit var c : TextView


    fun isNumeroValido(valore: String): Boolean {
        return valore.toDoubleOrNull() != null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        a = findViewById<TextView>(R.id.bho)
        b = findViewById<TextView>(R.id.bho)
        c = findViewById<TextView>(R.id.bho)

        val valore_a = a.text.toString().toDoubleOrNull()
        val valore_b = b.text.toString().toDoubleOrNull()
        val valore_c = c.text.toString().toDoubleOrNull()

        val ris1 = 0
        val ris2 = 0


        if ( valore_a == null || valore_b == null || valore_c == null){
            if (valore_a == null){
                //errore diolegna
            }
            else if (valore_b == null){
                //calcoli
            }
            else if (valore_c == null){
                //calcoli
            }
            else if (valore_b == null || valore_c == null ){
                ris1 = 0
                ris2 = 0
            }
        }

    }
}