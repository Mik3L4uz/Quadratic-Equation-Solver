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
            // assegazione valori
            var valore_a = a.text.toString().toDoubleOrNull()
            var valore_b = b.text.toString().toDoubleOrNull()
            var valore_c = c.text.toString().toDoubleOrNull()

            var ris1 = 0
            var ris2 = 0


            if ( valore_a == null || valore_b == null || valore_c == null){
                if (valore_a == null){ // controllo se manca a
                    errore.text = "a must be provided with a value"
                }
                else if (valore_b == null && valore_c == null ){
                    ris1 = 0
                    ris2 = 0
                }
                else if (valore_b == null){
                    if ((valore_c/valore_a)>=0) // calcolo delta
                    {
                        ris1 = sqrt(  -( valore_c/valore_a) )
                        ris2 =  -ris1
                    }
                    else{
                        errore.text= "delta (b^2-4ac) is a negative value"
                    }
                }
                else if (valore_c == null){
                    ris1 = 0
                    ris2 = -(valore_b / valore_a) // calcolo della x quando c non c'è
                }

            }
            if ( valore_a == null && valore_b == null && valore_c == null){
                errore.text = "insert at leat 2 values in gaps (a must have one)"
            }
            else if (valore_a != null && valore_b != null && valore_c != null){ // utilizzo formula standard eq 2° grado

                var menob2 = -(valore_b.pow(2))

                var delta = sqrt( valore_b.pow(2) -4 *valore_a*valore_c )

                if (delta >=0){
                    ris1 = (menob2 + delta) / 2*valore_a
                    ris2 = (menob2 - delta) / 2*valore_a
                }
                else if (delta == 0){
                    ris1 = (menob2) / 2*valore_a
                    ris2 = ris1
                }
                else {

                    errore.text="delta (b^2-4ac) is a negative value"
                }

            }


        }






    }
}