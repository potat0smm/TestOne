package com.example.testone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.testone.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {
    lateinit var mBinding: LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        fun goMy(@Suppress("UNUSED_PARAMETER")view: View) {
            val text = mBinding.etName.text.toString()
            val goIntent = Intent(this,MenuActivity::class.java)
            startActivity(goIntent)
        }
    }
}