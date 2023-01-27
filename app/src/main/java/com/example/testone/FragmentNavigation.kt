package com.example.testone

import androidx.fragment.app.Fragment

interface FragmentNavigation {

    fun navigateFrag(fragment:Fragment, addToStack: Boolean)
}