package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.DatePickerDialog;
import java.util.Calendar;
import android.widget.DatePicker;

//import android.widget.Spinner;
//import java.util.ArrayList;
//import java.util.List;

public class FirstActivity extends AppCompatActivity {

    EditText etName, address, phoneNo, date;
    DatePickerDialog datePickerDialog;
    Button btnName;

    public final static String MESSAGE_KEY = "com.example.MyFirstApp.message_key";
    public final static String MESSAGE_KEY_Date = "com.example.MyFirstApp.Date";
    public final static String MESSAGE_KEY_Address = "com.example.MyFirstApp.Address";
    public final static String MESSAGE_KEY_Phone = "com.example.MyFirstApp.Phone";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        date = (EditText) findViewById(R.id.date);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(FirstActivity.this,
                        new DatePickerDialog.OnDateSetListener()
                        {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        }
    public void send_data(View view)
    {
        etName = findViewById(R.id.etName);
        btnName = findViewById(R.id.btnName);
        date = findViewById(R.id.date);
        address = findViewById(R.id.address);
        phoneNo = findViewById(R.id.phoneNo);


        String message = etName.getText().toString();
        String message1 = date.getText().toString();
        String message2 = address.getText().toString();
        String message3 = phoneNo.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);

        intent.putExtra(MESSAGE_KEY, message);
        intent.putExtra(MESSAGE_KEY_Date, message1);
        intent.putExtra(MESSAGE_KEY_Address, message2);
        intent.putExtra(MESSAGE_KEY_Phone, message3);


        startActivity(intent);

    }
}
