package com.tarikalperen.banka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tarikalperen.banka.databinding.ActivityMainBinding
import com.tarikalperen.banka.FeedActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

        val currentUser = auth.currentUser

        if (currentUser != null) {
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun signInClicked(view: View) {

        val userEmail = binding.hesaptext.text.toString()
        val password = binding.pintext.text.toString()

        if (userEmail.equals("") || password.equals("")) {

            Toast.makeText(this, "E-mail ve şifre giriniz!", Toast.LENGTH_LONG).show()
        } else {
            auth.signInWithEmailAndPassword(userEmail, password).addOnSuccessListener {
                val intent = Intent(this@MainActivity, FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener{
                Toast.makeText(this@MainActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
                }

        }}




        fun signUpClicked(view: View) {

            val userEmail = binding.hesaptext.text.toString()
            val password = binding.pintext.text.toString()

            if (userEmail.equals("") || password.equals("")) {

                Toast.makeText(this, "E-mail ve şifre giriniz!", Toast.LENGTH_LONG).show()
            } else {
                auth.createUserWithEmailAndPassword(userEmail, password).addOnSuccessListener {
                    val intent = Intent(this@MainActivity, FeedActivity::class.java)
                    startActivity(intent)
                    finish()
                }.addOnFailureListener{
                    Toast.makeText(this@MainActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
                }

            }

        }

}
