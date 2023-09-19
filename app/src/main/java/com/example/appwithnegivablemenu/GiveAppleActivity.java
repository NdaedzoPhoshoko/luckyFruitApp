package com.example.appwithnegivablemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class GiveAppleActivity extends AppCompatActivity {

    //declare objects
    private TextView title;
    private TextView fruitName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_apple);

        //initializing the instances included in activity_give_apple.xml
        title = (TextView) findViewById(R.id.yourLuckyFruitIsTextView);
        fruitName = (TextView) findViewById(R.id.displayFruitTextView);

        //receiving username from the intent of MainActivity.java
        String username = getIntent().getStringExtra("username");
        title.setText(username+" your lucky fruit is...");

        //array storing five fruit names
        String[] my_fruits = {"Apple", "Banana", "Cherry", "Lemon", "Papaya"};
        //setting fruitName to randomFruit
        fruitName.setText(luckyFruit(my_fruits));
    }

    /*
     *This method accept a string array of fruit names
     *When invoked, it generates random index and returns fruit[index] within bounds
     */
    public String luckyFruit(String[] fruits)
    {
        Random index = new Random();
        return fruits[index.nextInt(fruits.length-1)]; //bounds for index are 0 to size-1
    }

}