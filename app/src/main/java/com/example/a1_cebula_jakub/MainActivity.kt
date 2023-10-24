package com.example.a1_cebula_jakub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a1_cebula_jakub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var txtNameMain: TextView
    lateinit var txtNick: TextView
    var email:String = ""
    var phone:String = "999"

    val startRenameForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                // Handle the Intent:
                val intent = result.data // the same is: intent = result.getData()
                val na = intent?.getStringExtra("newname")
                val ni = intent?.getStringExtra("newnick")
                val ne = intent?.getStringExtra("email")
                val np = intent?.getStringExtra("phone")
                if (na != null) {
                    //val str = na.toString()
                    txtNameMain.setText(na)
                }
                if (ni != null) {
                    //val str = ni.toString()
                    txtNick.setText(ni)
                }
                if (ne != null) {
                    email=ne
                }
                if (np != null) {
                    phone=np
                }
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtNameMain = binding.txtName
        txtNick = binding.txtNick



        val button1:Button = binding.buttonAct1
        button1.setOnClickListener {_ ->
            val myIntent = Intent(this, Activity2::class.java)
            startActivity(myIntent)

        }

        val button2:Button = binding.buttonAct2
        var aBundle = Bundle()
        button2.setOnClickListener {_ ->
            val myIntent = Intent(this, Activity3::class.java)
            //startActivity(myIntent)
            aBundle.putString("name", txtNameMain.text.toString())
            aBundle.putString("nick", txtNick.text.toString())
            aBundle.putString("email", email)
            aBundle.putInt("phone", phone.toInt())
            myIntent.putExtras(aBundle)
            startRenameForResult.launch(myIntent)
        }

        val button3:Button = binding.buttonAct3
        button3.setOnClickListener {_ ->
            val myIntent = Intent(this, Activity4::class.java)
            startActivity(myIntent)

        }
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "welcome back!", Toast.LENGTH_SHORT).show()
    }
}