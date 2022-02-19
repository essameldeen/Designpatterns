package com.demo.builderpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.demo.builderpattern.builder.FoodOrder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var foodOrder = FoodOrder.Builder()
            .bread("Black bread")
            .condiments("2 df")
            .meat("bacon")
            .build()


        Toast.makeText(this,foodOrder.bread,Toast.LENGTH_LONG).show()
    }
}