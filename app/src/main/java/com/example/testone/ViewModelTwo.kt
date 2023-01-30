package com.example.testone

import androidx.lifecycle.MutableLiveData

class ViewModelTwo: androidx.lifecycle.ViewModel() {


    var name = MutableLiveData<String>()
    var desc = MutableLiveData<String>()

}