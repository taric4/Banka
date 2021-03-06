package com.tarikalperen.banka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.tarikalperen.banka.*
import com.tarikalperen.banka.databinding.ActivityFeedBinding


private lateinit var auth : FirebaseAuth
private lateinit var db : FirebaseFirestore
private lateinit var binding: ActivityFeedBinding

class FeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.banka_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


         if (item.itemId == R.id.logout) {


            auth.signOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }

        return super.onOptionsItemSelected(item)
    }

    fun textButtonClicked (view : View){
        val intent = Intent (this, UploadActivity::class.java)
        startActivity(intent)

    }


    fun textButtonClicked2 (view : View){
        val intent = Intent (this, UploadActivity2::class.java)
        startActivity(intent)

    }


    fun textButtonClicked3 (view : View){
        val intent = Intent (this, UploadActivity3::class.java)
        startActivity(intent)

    }


}




