package com.beatrice.myarchitecture

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    val modelMVC = MyModel(count = 0)
    private lateinit var countTextView: TextView
    private lateinit var button: Button

    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        countTextView = findViewById(R.id.countTextView)
        button = findViewById(R.id.button)
        setButtonClickedMVVM()
        observeCount()
    }

    fun setTextMvc(){
        countTextView.text = modelMVC.count.toString()
    }

    fun setButtonClickedMvc() {
        button.setOnClickListener {
            modelMVC.updateCount()
            Log.d("Count", "${modelMVC.count}")
            setTextMvc()
        }
    }

    fun setButtonClickedMVVM(){
        button.setOnClickListener {
            viewModel.updateCount()
        }
    }

    fun observeCount(){
        viewModel.modelLiveData.observe(this){
            Log.d("Gotten", "was ${it.count}")
            countTextView.text = it.count.toString()
        }
    }
}