package com.example.appwithnegivablemenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        String[] my_fruits = {"Apple", "Banana", "Cherry", "Lemon", "Papaya", "Mango", "Pears", "Orange", "Grape", "Avocado"};
        //setting fruitName to randomFruit
        String luckyFruitName = luckyFruit(my_fruits);
        fruitName.setText(luckyFruitName);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_menu, menu);
        return true;
    }

    /*
    This method is overridden to allow functionality for items clicked on the menu
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.home_item)
        {
            intentTo(MainActivity.class); //intent to MainActivity.class
        } else if (itemId == R.id.share_item) {
            //receiving username from the intent of MainActivity.java
            String username = getIntent().getStringExtra("username");
            //initialize fruitName
            fruitName = (TextView) findViewById(R.id.displayFruitTextView);
            intentShareTo(username, fruitName.getText().toString()); //intent to another activity with extra values
        }else{ //for id for last item: quiting the app
            //todo add new code for quiting the app here
        }
        return super.onOptionsItemSelected(item);
    }

    //method 1: intent to another Activity without passing values
    public void intentTo(Class toActivity)//method to intent to any other activity
    {
        Intent i = new Intent(GiveAppleActivity.this, toActivity);
        startActivity(i);
    }
    //method 2: intent to share values to other activities
    public void intentShareTo(String username, String fruitName)//method to intent to any other activity
    {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, "Hey, "+ username + " got "+ fruitName + " as lucky fruit today");
        i.putExtra(Intent.EXTRA_SUBJECT, "My Lucky Fruit Today");
        startActivity(Intent.createChooser(i, "Sharing fruit with"));
    }
}