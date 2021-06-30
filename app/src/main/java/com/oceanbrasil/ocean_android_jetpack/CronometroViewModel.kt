package com.oceanbrasil.ocean_android_jetpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.timerTask

class CronometroViewModel : ViewModel() {
    val elapsedTime = MutableLiveData<Long>(0)

    private val timer = Timer()

    init {
        timer.scheduleAtFixedRate(
            timerTask {
                val value = elapsedTime.value ?: 0

                elapsedTime.postValue(value + 1)
            }, 1000, 1000
        )
    }
}