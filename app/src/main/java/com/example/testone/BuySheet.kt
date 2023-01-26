package com.example.testone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.testone.databinding.FragmentBuySheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BuySheet : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBuySheetBinding
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = requireActivity()
        viewModel = ViewModelProvider(activity).get(ViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBuySheetBinding.inflate(inflater,container,false )
        return binding.root
    }



}