package com.example.a1_cebula_jakub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a1_cebula_jakub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button1:Button = binding.buttonAct1
        button1.setOnClickListener {_ ->
            val myIntent = Intent(this, Activity2::class.java)
            startActivity(myIntent)

        }

        val button2:Button = binding.buttonAct2
        button2.setOnClickListener {_ ->
            val myIntent = Intent(this, Activity3::class.java)
            startActivity(myIntent)

        }

        val button3:Button = binding.buttonAct3
        button3.setOnClickListener {_ ->
            val myIntent = Intent(this, Activity4::class.java)
            startActivity(myIntent)

        }
    }
}