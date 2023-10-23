package com.example.a1_cebula_jakub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.a1_cebula_jakub.databinding.Activity3Binding
import com.example.a1_cebula_jakub.databinding.Activity4Binding

class Activity3 : AppCompatActivity() {

    lateinit var binding:Activity3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_3)

        binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonBack : Button = binding.buttonBack
        buttonBack.setOnClickListener {_ ->
            onBackPressed()
        }
    }
}