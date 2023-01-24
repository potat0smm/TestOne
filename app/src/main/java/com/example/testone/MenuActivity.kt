package com.example.testone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testone.databinding.MenuActivityBinding

class MenuActivity : AppCompatActivity() {

    private val img = arrayOf(R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw)
    private val desc = arrayOf("desc","desc","desc","desc","desc","desc","desc","desc","desc")
    private val text = arrayOf("StarWars","StarWars","StarWars","StarWars","StarWars","StarWars","StarWars","StarWars","StarWars")
    private lateinit var menuActivityBinding: MenuActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_activity)
        menuActivityBinding = MenuActivityBinding.inflate(layoutInflater)
        setContentView(menuActivityBinding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(img,text,desc)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
            R.id.Map -> {
                Toast.makeText(this,"sus",Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }



}