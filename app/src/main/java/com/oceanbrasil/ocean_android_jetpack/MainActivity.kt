package com.oceanbrasil.ocean_android_jetpack

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.oceanbrasil.ocean_android_jetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /*
        val textView = findViewById<TextView>(R.id.tv)
        textView.setOnClickListener() {
            textView.text = "Clicado!!"
        }
        */

        // val cronometroViewModel = ViewModelProvider(this).get(CronometroViewModel::class.java)

        val textViewModel =
            ViewModelProvider(this)
                .get(TextViewModel::class.java)

        binding.viewModel = textViewModel

        val textView = findViewById<TextView>(R.id.tv)

        // cronometroViewModel.elapsedTime.observe(this, {
        //    textView.text = "$it segundos se passaram"
        // })

        // textView.text = textViewModel.text


        // textViewModel.text.observe(this, {
        //     textView.text = it
        // })

        textView.setOnClickListener {
            textViewModel.text.set("Elemento clicado!!")

            // textView.text = textViewModel.text
        }

        textView.setOnLongClickListener {
            textViewModel.text.set("Elemento segurado!!")

            // textView.text = textViewModel.text

            true
        }
    }

    /*
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val textView = findViewById<TextView>(R.id.tv)
        val valorTextView = savedInstanceState.getString("VALOR_TEXT_VIEW")
        textView.setText(valorTextView)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val textView = findViewById<TextView>(R.id.tv)
        outState.putString("VALOR_TEXT_VIEW", textView.text.toString())
    }
    */
}