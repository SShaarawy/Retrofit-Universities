package com.example.kotlinretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinretrofit.R
import com.example.kotlinretrofit.adapter.RecyclerViewAdapter
import com.example.kotlinretrofit.model.Dog

class MainActivity2 : AppCompatActivity() {
    private var rvAll: RecyclerView? = null
    private var rvAllAdapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rvAll = findViewById(R.id.rvAll)

        val uniList: ArrayList<Dog> = intent.getSerializableExtra("List") as ArrayList<Dog>

        //RecyclerView
        val layoutManager = LinearLayoutManager(this)
        rvAll?.layoutManager = layoutManager

        rvAllAdapter = RecyclerViewAdapter(uniList)
        rvAll?.adapter = rvAllAdapter


    }
}