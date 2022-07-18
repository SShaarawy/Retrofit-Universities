package com.example.kotlinretrofit.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.kotlinretrofit.R
import com.example.kotlinretrofit.model.Dog
import com.example.kotlinretrofit.service.DogAPI
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private var uniList: ArrayList<Dog>? = null
    private var tvWebPages: TextView? = null
    private var tvAlphaTwoCode: TextView? = null
    private var tvName: TextView? = null
    private var tvCountry: TextView? = null
    private var btnNext: Button? = null
    private var btnClear: Button? = null
    private var btnAll: Button? = null

    private val list = arrayListOf<Dog>()
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvWebPages = findViewById(R.id.tvWebPages)
        tvName = findViewById(R.id.tvName)
        tvAlphaTwoCode = findViewById(R.id.tvAlphaTwoCode)
        tvCountry = findViewById(R.id.tvCountry)

        btnAll = findViewById(R.id.btnAll)
        btnClear = findViewById(R.id.btnClear)
        btnNext = findViewById(R.id.btnNext)

        loadData()

        btnNext?.setOnClickListener { showData() }
        btnClear?.setOnClickListener { clearData() }
        btnAll?.setOnClickListener { showAllData() }

    }

    private fun loadData() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(DogAPI::class.java) //service

        val call = retrofit.getData()

        call.enqueue(object : Callback<List<Dog>> {
            override fun onResponse(call: Call<List<Dog>>, response: Response<List<Dog>>) {
                if (response.isSuccessful) {
                    println("asd" + response.body()?.get(0)?.name)
                    println("aaa" + response.body()?.get(0)?.country)
                    println("aaa" + response.body()?.get(0)?.web_pages)
                    println("aaa" + response.body()?.get(0)?.alpha_two_code)


                    uniList = response.body()?.let { ArrayList(it) }
                    println(uniList?.size)
                }
            }

            override fun onFailure(call: Call<List<Dog>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private fun showData() {
        val length = uniList?.get(counter)?.web_pages?.size
        var str = ""
        for (i in 0 until length!!) {
            if (i != (length - 1)) {
                str += uniList?.get(counter)?.web_pages?.get(i) + ",\n"
            } else {
                str += uniList?.get(counter)?.web_pages?.get(i)
            }
        }
        tvWebPages?.text = str
        tvName?.text = uniList?.get(counter)?.name
        tvAlphaTwoCode?.text = uniList?.get(counter)?.alpha_two_code
        tvCountry?.text = uniList?.get(counter)?.country

        counter++
    }

    private fun clearData() {
        tvWebPages?.text = ""
        tvName?.text = ""
        tvAlphaTwoCode?.text = ""
        tvCountry?.text = ""

        counter = 0
    }

    private fun showAllData() {
        for (item in 0..20) {
            println(item)
            println(list.add(uniList!![item]))
        }
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("List", list)
        startActivity(intent)
        finish()
    }
}



