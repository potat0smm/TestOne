package com.example.testone

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var fAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        username = view.findViewById(R.id.log_username)
        password = view.findViewById(R.id.log_password)
        fAuth = FirebaseAuth.getInstance()

        view.findViewById<Button>(R.id.btn_register).setOnClickListener {
            val navRegister = activity as FragmentNavigation
            navRegister.navigateFrag(RegisterFragment(), false)
        }
        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            validateForm()
        }
        return view
    }

    private fun firebaseSignIn(){

        fAuth.signInWithEmailAndPassword(username.text.toString(),
            password.text.toString()).addOnCompleteListener{
                task ->
                if(task.isSuccessful){
                    val intent = Intent (activity,MenuActivity::class.java)
                    startActivity(intent)
                   // Animatoo.animateSlideFade(this)
                    Toast.makeText(context,"login",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context,task.exception?.message, Toast.LENGTH_SHORT).show()
                }
        }

    }





    private fun validateForm(){
        val icon = AppCompatResources.getDrawable(requireContext(),
            R.drawable.baseline_warning_amber_24)

        icon?.setBounds(0,0,icon.intrinsicWidth,icon.intrinsicHeight)
        when{
            TextUtils.isEmpty(username.text.toString().trim())->{
                username.setError("Please Enter Username",icon)
            }
            TextUtils.isEmpty(password.text.toString().trim())->{
                password.setError("Please Enter Password",icon)
            }


            username.text.toString().isNotEmpty() &&
                    password.text.toString().isNotEmpty()  -> {

                if (username.text.toString().matches(Regex("[a-zA-Z\\d._-]+@[a-z]+\\.+[a-z]+"))) {

                    firebaseSignIn()

                } else {
                    username.setError("Please Enter Valid Email Id", icon)
                }

            }


        }

    }


}