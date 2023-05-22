package com.example.guessnumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.guessnumberapp.databinding.ActivityGuessBinding
import com.example.guessnumberapp.databinding.ActivityMainBinding
import kotlin.random.Random

class GuessActivity : AppCompatActivity() {
        lateinit var binding: ActivityGuessBinding

        private var randomNumber = 0
        private var count = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        randomNumber = Random.nextInt(101)//0 with 101

        Log.e("Rastgele Sayı", randomNumber.toString())

        binding.buttonGuess.setOnClickListener{


            val myNumber = binding.editTextGuess.text.toString().toInt()

            count = count - 1

            if (randomNumber == myNumber){
                finish()
                startActivity(Intent(this@GuessActivity,ResultActivity::class.java))
                intent.putExtra("result",true)
                return@setOnClickListener
            }
            if (randomNumber > myNumber){
                binding.textViewTry.text = "Increase"
                binding.textViewCount.text = "Remaining Rights: :$count"
            }
            if (randomNumber < myNumber){
                binding.textViewTry.text = "Decrease"
                binding.textViewCount.text = "Remaining Rights: :$count"
            }
            if (count == 0){
                finish()
                startActivity(Intent(this@GuessActivity,ResultActivity::class.java))
                intent.putExtra("result",false)
            }
            binding.textViewTry.setText("")
        }

    }
}