package com.example.a1_cebula_jakub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a1_cebula_jakub.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {

    lateinit var binding: Activity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_2)

        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}