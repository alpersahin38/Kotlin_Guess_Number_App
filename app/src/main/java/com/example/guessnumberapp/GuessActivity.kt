package com.example.guessnumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.guessnumberapp.databinding.ActivityGuessBinding
import com.example.guessnumberapp.databinding.ActivityMainBinding

class GuessActivity : AppCompatActivity() {
        lateinit var binding: ActivityGuessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGuess.setOnClickListener{
            finish()
            startActivity(Intent(this@GuessActivity,ResultActivity::class.java))

        }
    }
}