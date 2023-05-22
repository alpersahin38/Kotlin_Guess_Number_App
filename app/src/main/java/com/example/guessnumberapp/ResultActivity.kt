package com.example.guessnumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.guessnumberapp.databinding.ActivityGuessBinding
import com.example.guessnumberapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getBooleanExtra("result",true)

        if (result){
            binding.imageViewResult.setImageResource(R.drawable.happy)
            binding.textViewResult.text = "YOU WON"
        }
        else{
            binding.imageViewResult.setImageResource(R.drawable.baseline_sentiment_very_dissatisfied_24)
            binding.textViewResult.text = "YOU LOST"
        }

        binding.buttonTry.setOnClickListener{
            finish()
            startActivity(Intent(this@ResultActivity,MainActivity::class.java))

        }
    }
}