package com.example.question2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.question2.ui.theme.Question2Theme
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            val numberOfDraws = spinner.selectedItem.toString().toInt()
            val drawnNumbers = drawNumbers(numberOfDraws)
            textView.text = "Drawn Numbers: ${drawnNumbers.joinToString(", ")}"
        }
    }

    private fun drawNumbers(count: Int): List<Int> {
        val numbers = (1..100).toMutableList()
        numbers.shuffle()
        return numbers.take(count)
    }
}
