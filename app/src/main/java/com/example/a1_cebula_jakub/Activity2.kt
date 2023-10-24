package com.example.a1_cebula_jakub

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.example.a1_cebula_jakub.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {

    lateinit var binding: Activity2Binding
    lateinit var etPhone: EditText
    lateinit var button_dial: Button
    lateinit var button_sms: Button
    lateinit var radio1: RadioButton
    lateinit var radio2: RadioButton
    lateinit var radio3: RadioButton
    lateinit var radio4: RadioButton
    lateinit var alt_text: EditText
    var current_msg = "def msg"

    fun runDial(phoneNum: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNum")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun runSMS(phoneNumber: String, message: String){

        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("smsto:$phoneNumber")
        }


        if (intent.resolveActivity(packageManager) != null) {
            intent.putExtra("sms_body", message);
            startActivity(intent);
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_2)

        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        etPhone = binding.etPhone
        button_dial = binding.buttonDial

        button_dial.setOnClickListener{ _->
            val str1 = etPhone.text
            runDial(str1.toString())
        }

        button_sms = binding.buttonSms
        radio1 = binding.radio1
        radio2 = binding.radio2
        radio3 = binding.radio3
        radio4 = binding.radio4
        alt_text = binding.editTextText

        radio1.setOnClickListener { _ ->
            current_msg = radio1.text.toString()
        }

        radio2.setOnClickListener { _ ->
            current_msg = radio2.text.toString()
        }

        radio3.setOnClickListener { _ ->
            current_msg = radio3.text.toString()
        }

        /*
        radio4.setOnClickListener { _ ->
            current_msg = alt_text.text.toString()
        }
         */

        button_sms.setOnClickListener {
            if (radio4.isChecked){
                current_msg = alt_text.text.toString()
            }
            val str1 = etPhone.text.toString()
            val str2 = current_msg
            runSMS(str1, str2)
        }


    }

}