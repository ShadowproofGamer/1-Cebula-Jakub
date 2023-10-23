package com.example.a1_cebula_jakub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.a1_cebula_jakub.databinding.Activity4Binding
import com.example.a1_cebula_jakub.databinding.ActivityMainBinding

class Activity4 : AppCompatActivity() {

    lateinit var binding: Activity4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_4)

        binding = Activity4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonBack : Button = binding.buttonBackA4
        buttonBack.setOnClickListener {_ ->
            onBackPressed()
        }

    }
}