package com.example.a1_cebula_jakub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.a1_cebula_jakub.databinding.Activity3Binding
import com.example.a1_cebula_jakub.databinding.Activity4Binding

class Activity3 : AppCompatActivity() {

    lateinit var binding:Activity3Binding
    lateinit var etName3 : EditText
    lateinit var etEmail3 : EditText
    lateinit var etPhone3 : EditText
    lateinit var etNick3 : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_3)

        binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val iii: Intent = getIntent()
        val bundle = iii.extras
        var txtname:String = bundle?.getString("name") ?: "Name"
        var txtnick:String = bundle?.getString("nick") ?: "Nick"
        var email:String = bundle?.getString("email") ?: ""
        var phone:Int = bundle?.getInt("phone", 999) ?: 0

        val buttonBack : Button = binding.buttonBack
        etName3 = binding.etName
        etEmail3 = binding.etEmail
        etPhone3 = binding.etPhone3
        etNick3 = binding.etNick

        etName3.setText(txtname.toString())
        etEmail3.setText(email.toString())
        etPhone3.setText(phone.toString())
        etNick3.setText(txtnick.toString())

        buttonBack.setOnClickListener {_ ->
            var newName = etName3.text.toString()
            var newEmail = etEmail3.text.toString()
            var newPhone = etPhone3.text.toString()
            var newNick = etNick3.text.toString()

            /*
            etName3.setText(newName)
            etEmail3.setText(newEmail)
            etPhone3.setText(newPhone)
            etNick3.setText(newNick)
             */


            iii.putExtra("newname", newName)
            iii.putExtra("newnick", newNick)
            iii.putExtra("email", newEmail)
            iii.putExtra("phone", newPhone)
            setResult(RESULT_OK, iii)
            finish()
        }
    }

}