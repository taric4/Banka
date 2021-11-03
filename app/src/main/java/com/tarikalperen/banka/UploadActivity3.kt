package com.tarikalperen.banka

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tarikalperen.banka.databinding.ActivityUpload3Binding
import retrofit2.Retrofit

class UploadActivity3 : AppCompatActivity (){

    private lateinit var binding : ActivityUpload3Binding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityUpload3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }


}