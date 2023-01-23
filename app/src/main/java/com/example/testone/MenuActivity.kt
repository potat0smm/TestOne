package com.example.testone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {

    private val img = arrayOf(R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw)
    private val desc = arrayOf("desc","desc","desc","desc","desc","desc","desc","desc","desc")
    private val text = arrayOf("StarWars","StarWars","StarWars","StarWars","StarWars","StarWars","StarWars","StarWars","StarWars")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_activity)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(img,text,desc)


    }
}