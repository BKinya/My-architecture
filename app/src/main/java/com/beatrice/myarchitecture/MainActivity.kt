package com.beatrice.myarchitecture

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.beatrice.myarchitecture.data.MyModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val modelMVC = MyModel(count = 0, id = 1)
    private lateinit var countTextView: TextView
    private lateinit var button: Button

    private val viewModel: MyViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTextView = findViewById(R.id.countTextView)
        button = findViewById(R.id.button)
        viewModel.getCountModel()
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
            viewModel.updateCountAndSave()
        }
    }

    fun observeCount(){
        viewModel.countModel.observe(this){
            Log.d("Gotten", "was ${it.count}")
            countTextView.text = it.count.toString()
        }
    }
}