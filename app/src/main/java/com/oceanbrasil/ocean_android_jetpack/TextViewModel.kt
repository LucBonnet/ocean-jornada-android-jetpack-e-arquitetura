package com.oceanbrasil.ocean_android_jetpack

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextViewModel : ViewModel() {
    var text = ObservableField("Hello World")
}