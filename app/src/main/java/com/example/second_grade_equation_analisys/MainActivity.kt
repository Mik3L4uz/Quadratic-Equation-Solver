package com.example.second_grade_equation_analisys

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.abs
class MainActivity : AppCompatActivity() {

    lateinit var a : EditText

    lateinit var b : EditText

    lateinit var c : EditText


    lateinit var bottonesoluzione : Button


    lateinit var risultato1 : TextView


    lateinit var risultato2 : TextView


    lateinit var bottonegrafico : Button


    lateinit var errore : TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // dichiarazione valori equazioni
        a = findViewById<EditText>(R.id.editTextText)
        b = findViewById<EditText>(R.id.editTextText2)
        c = findViewById<EditText>(R.id.editTextText3)

        // dichiarazione bottoni
        bottonesoluzione = findViewById<Button>(R.id.bottonesolution)
        bottonegrafico = findViewById<Button>(R.id.bottonegrafico)

        // dichiarazione TextView
        risultato1 = findViewById<TextView>(R.id.ris1)
        risultato2 = findViewById<TextView>(R.id.ris2)
        errore = findViewById<TextView>(R.id.mess_err)




        bottonesoluzione.setOnClickListener {
            // reset messaggio errore
            errore.text=""

            // assegazione valori
            var valore_a = a.text.toString().toDoubleOrNull()?:0.0
            var valore_b = b.text.toString().toDoubleOrNull()?:0.0
            var valore_c = c.text.toString().toDoubleOrNull()?:0.0

            if (valore_a==0.0){
            errore.text="\"a\" must be provided with a value"
            }

            else if (valore_b == 0.0 && valore_c == 0.0){
                risultato1.text = "without \"b\" and \"c\" the result will always be only one: 0"
            }
            else {    // utilizzo formula standard eq 2° grado

                //valore delta minimo per confronto finale
                val cock = 1e-10

                var menob2 = -(valore_b.pow(2))

                var delta = sqrt( (valore_b.pow(2)) - (4 *valore_a * valore_c))

                //controllo delta e calcolo finale


                if (delta >=0){
                    risultato1.text = ((menob2 + delta) / 2*valore_a).toString()
                    risultato2.text = ((menob2 - delta) / 2*valore_a).toString()
                }
                else if (abs(delta) < cock){ // confronto in caso di numeri molto piccolini
                    risultato1.text = (( menob2) / 2 * valore_a ).toString()
                    risultato2.text = (risultato1.text).toString()
                    bottonegrafico.isEnabled = false
                }
                else {
                    errore.text="delta (b^2-4ac) is a negative value"
                }

                bottonegrafico.setOnClickListener {
                    val intent = Intent(this, SecondActivity::class.java)
                    startActivity(intent)
                }
            }






        }






    }
}