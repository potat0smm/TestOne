package com.example.testone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.example.testone.databinding.MapActivityBinding

class MapActivity : AppCompatActivity() {

    lateinit var binding: MapActivityBinding
    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map_activity)
        binding = MapActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //buttom sheet
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        binding.fab.setOnClickListener {
            BuySheet().show(supportFragmentManager, "newTaskTag")
        }




        binding.bottomNavigationView.setOnItemReselectedListener {

            when(it.itemId){

                R.id.home -> {
                    val intent = Intent(this,MenuActivity::class.java)
                    startActivity(intent)
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

                }
            }
        }

    }
}