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
import com.google.android.material.snackbar.Snackbar

class MenuActivity : AppCompatActivity() {

    private val img = arrayOf(R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw,R.drawable.sw)
    private val desc = arrayOf("desc","desc","desc","desc","desc","desc","desc","desc","desc")
    private val text = arrayOf("StarWars","StarWars","StarWars","StarWars","StarWars","StarWars","StarWars","StarWars","StarWars")
    lateinit var menuActivityBinding: MenuActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_activity)
        menuActivityBinding = MenuActivityBinding.inflate(layoutInflater)
        setContentView(menuActivityBinding.root)

        //full
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(img,text,desc)



        //transitions between activities
        menuActivityBinding.bottomNavigationView.setOnItemReselectedListener {

            when(it.itemId){

                R.id.home -> {

                }
                R.id.person -> {
                    val intent = Intent(this,PersonActivity::class.java)
                    startActivity(intent)
                }
                R.id.setting ->{
                    val intent = Intent(this,SettingActivity::class.java)
                    startActivity(intent)
                }
                R.id.Map -> {
                    val intent = Intent(this,MapActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        //snakbar shop
        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener{
            val intent = Intent (this,MapActivity::class.java)
            startActivity(intent)
        }
    }

    //creation of Toast
    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Map -> {
                val intent = Intent(this@MenuActivity, MapActivity::class.java)
                startActivity(intent)
            }

        }
        return true
    }*/



}