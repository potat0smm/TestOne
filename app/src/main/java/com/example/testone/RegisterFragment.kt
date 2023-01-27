package com.example.testone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.example.testone.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var cnfPassword: EditText
    private lateinit var fAuth: FirebaseAuth

    @SuppressLint("MissingInflatedId")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        username = view.findViewById(R.id.reg_username)
        password = view.findViewById(R.id.reg_password)
        cnfPassword = view.findViewById(R.id.reg_cnf_password)
        fAuth = FirebaseAuth.getInstance()

//->
        view.findViewById<Button>(R.id.btn_login_reg).setOnClickListener {
            val navRegister = activity as   FragmentNavigation
            navRegister.navigateFrag(LoginFragment(), false)
        }

        view.findViewById<Button>(R.id.btn_register_reg).setOnClickListener {
            validateEmprtyForm()
        }
        return view


    }

    private fun firebaseSignUp(){


        fAuth.createUserWithEmailAndPassword(username.text.toString(),
            password.text.toString()).addOnCompleteListener{
                task ->
                if(task.isSuccessful){
//->
                    val intent = Intent (activity,MenuActivity::class.java)
                    startActivity(intent)

                    Toast.makeText(context,"Register Successful", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context,task.exception?.message, Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun validateEmprtyForm(){


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
            TextUtils.isEmpty(cnfPassword.text.toString().trim())->{
                cnfPassword.setError("Please Enter Password Again",icon)
            }

            username.text.toString().isNotEmpty() &&
                    password.text.toString().isNotEmpty() &&
                    cnfPassword.text.toString().isNotEmpty() ->
            {
                //pattern for mail
                if(username.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))){
                    if(password.text.toString().length>=5){
                        if(password.text.toString() == cnfPassword.text.toString()){

                            firebaseSignUp()
                        //                            Toast.makeText(context,"Register Successful", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            cnfPassword.setError("Password didn't match",icon)
                        }
                    }
                    else {
                        password.setError("Please Enter at least 5 character",icon)
                    }
                }else{
                    username.setError("Please Enter Valid Email Id",icon)
                }
            }
        }
    }
}


