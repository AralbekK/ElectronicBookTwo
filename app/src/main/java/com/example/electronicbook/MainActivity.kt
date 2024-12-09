package com.example.electronicbook

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggleButton: ToggleButton = findViewById(R.id.toggleButton)
        val loadButton: Button = findViewById(R.id.loadButton)
        val textView: TextView = findViewById(R.id.textView)
        val scrollView: ScrollView = findViewById(R.id.scrollView)

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Ночной режим
                scrollView.setBackgroundColor(Color.BLACK)
                textView.setTextColor(Color.WHITE)
            } else {
                // Дневной режим
                scrollView.setBackgroundColor(Color.WHITE)
                textView.setTextColor(Color.BLACK)
            }
        }

        loadButton.setOnClickListener {
            val words = loadBook(Database.text)
            textView.text = words.joinToString(" ")
        }
    }

    private fun loadBook(text: String): List<String> {
        return text.split(" ")
    }
}
