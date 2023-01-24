package com.example.testone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.testone.databinding.SettingActivityBinding

class SettingActivity : AppCompatActivity() {

    lateinit var binding: SettingActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_activity)
        binding = SettingActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

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

                }
                R.id.Map -> {
                    val intent = Intent(this,MapActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }
}