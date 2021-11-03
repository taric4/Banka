package com.tarikalperen.banka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tarikalperen.banka.adapter.RecyclerViewAdapter
import com.tarikalperen.banka.databinding.ActivityUpload2Binding
import com.tarikalperen.banka.model.CrytoModel
import com.tarikalperen.banka.servis.CryptoAPI
import kotlinx.android.synthetic.main.activity_upload2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UploadActivity2 : AppCompatActivity(),RecyclerViewAdapter.Listener {

    private val BASE_URL = "https://api.nomics.com/v1/"
    private var cryptoModels: ArrayList<CrytoModel>? = null
    private var recyclerViewAdapter : RecyclerViewAdapter? = null

    private lateinit var binding : ActivityUpload2Binding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityUpload2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        loadData()

    }

    //https://api.nomics.com/v1
    //a4da7af7fd89f355b28ca16816dbf6698876478c

    private fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CryptoAPI::class.java)
        val call = service.getData()
        with(call) {
            enqueue(object: Callback<List<CrytoModel>> {
                override fun onFailure(call: Call<List<CrytoModel>>, t: Throwable){
                    t.printStackTrace()
                }


                override fun onResponse(call: Call<List<CrytoModel>>, response: Response<List<CrytoModel>>) {

                    if (response.isSuccessful){
                        response.body()?.let {
                            cryptoModels = ArrayList(it)

                            cryptoModels?.let {
                                recyclerViewAdapter = RecyclerViewAdapter(it,this@UploadActivity2)
                                recyclerView.adapter = recyclerViewAdapter
                            }
                        /*
                            for (cryptoModel : CrytoModel in cryptoModels!!){
                                println(cryptoModel.currency)
                                println(cryptoModel.price)
                            }

                             */

                        }

                    }
                }

            })
        }

    }
    override fun onItemClick(cryptoModel: CrytoModel) {
        Toast.makeText(this,"Clicked : ${cryptoModel.currency}", Toast.LENGTH_SHORT ).show()
    }
}
