package com.beatrice.myarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.beatrice.myarchitecture.data.Model

class MainActivity : AppCompatActivity() {
    val model = Model(count = 0)
    private lateinit var countTextView: TextView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTextView = findViewById(R.id.countTextView)
        button = findViewById(R.id.button)
        countTextView.text = model.count.toString()
        setButtonClickedMvc()
    }

    fun setButtonClickedMvc() {
        button.setOnClickListener {
            model.updateCount()
            Log.d("Count", "${model.count}")
            countTextView.text = model.count.toString()
        }
    }
}