package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    public final static String MESSAGE_KEY = "com.example.MyFirstApp.message_key";
    public final static String MESSAGE_KEY_Date= "com.example.MyFirstApp.Date";
    public final static String MESSAGE_KEY_Address = "com.example.MyFirstApp.Address";
    public final static String MESSAGE_KEY_Email = "com.example.MyFirstApp.Email";
    public final static String MESSAGE_KEY_Phone = "com.example.MyFirstApp.Phone";

    TextView textViewName, textViewDate, textViewAddress, textViewEmail, textViewPhone;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewName = findViewById(R.id.tvUserName);
        textViewDate = findViewById(R.id.tvDate);
        textViewAddress = findViewById(R.id.tvAddress);
        textViewEmail = findViewById(R.id.tvEmail);
        textViewPhone = findViewById(R.id.tvPhone);
        imageView = findViewById(R.id.ivUser);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MESSAGE_KEY);
        String message1 = intent.getStringExtra(MESSAGE_KEY_Date);
        String message2 = intent.getStringExtra(MESSAGE_KEY_Address);
        String message3 = intent.getStringExtra(MESSAGE_KEY_Email);
        String message4 = intent.getStringExtra(MESSAGE_KEY_Phone);

        textViewName.setTextSize(20);
        textViewName.setText("Name : " + message);

        textViewDate.setTextSize(20);
        textViewDate.setText("Date : " + message1);

        textViewAddress.setTextSize(20);
        textViewAddress.setText("Address : " + message2);

        textViewEmail.setTextSize(20);
        textViewEmail.setText("Email : " + message3);

        textViewPhone.setTextSize(20);
        textViewPhone.setText("Phone Number : " + message4);
    }
}