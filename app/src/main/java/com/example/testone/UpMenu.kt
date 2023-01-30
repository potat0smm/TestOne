package com.example.testone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.testone.databinding.FragmentBuySheetBinding
import com.example.testone.databinding.UpMenuBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class

UpMenu : BottomSheetDialogFragment() {

    private lateinit var binding: UpMenuBinding
    private lateinit var viewModel: ViewModelTwo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = requireActivity()
            //viewModel = ViewModelTwo(activity).get(ViewModelTwo::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = UpMenuBinding.inflate(inflater,container,false )
        return binding.root

    }



}