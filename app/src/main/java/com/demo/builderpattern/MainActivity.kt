package com.demo.builderpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.demo.builderpattern.builder.FoodOrder
import com.demo.builderpattern.factory.Coffee
import com.demo.builderpattern.factory.CoffeeFactory
import com.demo.builderpattern.singletone.Singleton

class MainActivity : AppCompatActivity() {
    private var isChanged: Boolean = false
    private lateinit var button: Button
    private lateinit var name: TextView
    private lateinit var description: TextView
    private lateinit var price: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button = findViewById(R.id.coffee_btn)
        button.setOnClickListener(this::changeCoffee)

        // builder pattern
        var foodOrder = FoodOrder.Builder()
            .bread("Black bread")
            .condiments("2 df")
            .meat("bacon")
            .build()


        Toast.makeText(this, foodOrder.bread, Toast.LENGTH_LONG).show()


        // singleTone pattern
        val singleton: Singleton = Singleton.getInstance()


    }

    private fun changeCoffee(view: View) {
        var factory: Coffee
        if (isChanged) {
            factory = CoffeeFactory.getCoffee(CoffeeFactory.Type.AMERICANO)
            isChanged = false
        } else {
            factory = CoffeeFactory.getCoffee(CoffeeFactory.Type.LATTE)
            isChanged = true
        }

        changeCoffeeType(factory.description(), factory.name(), factory.price())
    }


    private fun changeCoffeeType(descriptionValue: String, nameValue: String, priceValue: Int) {

        name = findViewById(R.id.coffee_name)
        name.text = nameValue

        description = findViewById(R.id.coffee_description)
        description.text = descriptionValue
        price = findViewById(R.id.coffee_price)
        price.text = "${priceValue.toString()} pound"


    }
}