package com.example.appwithnegivablemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare instances
    private EditText usernameEditText;
    private Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize instances used in activity_main.xml
        usernameEditText = (EditText) findViewById(R.id.promptUsernameEditText);
        proceedButton = (Button) findViewById(R.id.proceedBtn);

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = usernameEditText.getText().toString();

                //validate: don't allow empty userNames
                if(userName.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter username", Toast.LENGTH_SHORT).show();
                } else{
                    myIntent(userName);
                }
            }
        });
    }

    /*
     *This method allows navigating from MainActivity to GiveAppleActivity
     * Sending also local data: userName
     */
    public void myIntent(String userName)
    {
        Intent i = new Intent(MainActivity.this, GiveAppleActivity.class);
        i.setType("plain/text");
        i.putExtra("username", userName);
        startActivity(i);
    }

}