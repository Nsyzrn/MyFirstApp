package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public final static String MESSAGE_KEY = "com.example.MyFirstApp.message_key";
    public final static String MESSAGE_KEY_Address = "com.example.MyFirstApp.Address";
    public final static String MESSAGE_KEY_Phone = "com.example.MyFirstApp.Phone";
    public final static String MESSAGE_KEY_Date= "com.example.MyFirstApp.Date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MESSAGE_KEY);
        String message1 = intent.getStringExtra(MESSAGE_KEY_Date);
        String message2 = intent.getStringExtra(MESSAGE_KEY_Address);
        String message3 = intent.getStringExtra(MESSAGE_KEY_Phone);

        TextView textView = new TextView(this);

        textView.setTextSize(20);

        textView.setText("Name: "+ message +"\nBirth Date: "+ message1 + "\nAddress: "+ message2 +"\nPhone: "+ message3);

        setContentView(textView);
    }
}