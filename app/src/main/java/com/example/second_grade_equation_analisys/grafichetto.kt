package com.example.second_grade_equation_analisys

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlin.math.pow

class grafichetto : AppCompatActivity() {

    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grafichetto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        back = findViewById<Button>(R.id.bottone_back)
        val chart = findViewById<com.github.mikephil.charting.charts.LineChart>(R.id.lineChart)
        val a = intent.getDoubleExtra("EXTRA_A", 0.0)
        val b = intent.getDoubleExtra("EXTRA_B", 0.0)
        val c = intent.getDoubleExtra("EXTRA_C", 0.0)

        val valori = ArrayList<Entry>()

        var x = -100f
        while (x <= 100f) {
            val y = (a * x.toDouble().pow(2) + b * x + c).toFloat()
            valori.add(Entry(x, y))
            x += 0.5f // Passo del grafico (più è piccolo, più la curva è fluida)
        }

        val dataSet = LineDataSet(valori, "Equazione: ${a}x² + ${b}x + $c")
        dataSet.color = Color.BLUE
        dataSet.setDrawCircles(false) // Rimuove i pallini sui punti per una linea continua
        dataSet.lineWidth = 2f

        chart.data = LineData(dataSet)
        chart.invalidate()
        chart.xAxis.setDrawGridLines(true)
        chart.axisLeft.setDrawGridLines(true)

        back.setOnClickListener {
            val menu = Intent(this, MainActivity::class.java)
            startActivity((menu))
        }
    }
}