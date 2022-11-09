package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.DatePickerDialog;
import java.util.Calendar;

import android.widget.DatePicker;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    EditText etName, etAddress, etPhoneNo,etEmail, etDate;
    DatePickerDialog datePickerDialog;
    Button btnName;

    public final static String MESSAGE_KEY = "com.example.MyFirstApp.message_key";
    public final static String MESSAGE_KEY_Date = "com.example.MyFirstApp.Date";
    public final static String MESSAGE_KEY_Address = "com.example.MyFirstApp.Address";
    public final static String MESSAGE_KEY_Email = "com.example.MyFirstApp.Email";
    public final static String MESSAGE_KEY_Phone = "com.example.MyFirstApp.Phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        etDate = (EditText) findViewById(R.id.etDate);
        // perform click event on edit text
        etDate.setOnClickListener(new View.OnClickListener(){
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
                                etDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        }
    public void send_data(View view) {
        etName = findViewById(R.id.etName);
        btnName = findViewById(R.id.btnName);
        etDate = findViewById(R.id.etDate);
        etAddress = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNo = findViewById(R.id.etPhoneNo);

        String message = etName.getText().toString();
        String message1 = etDate.getText().toString();
        String message2 = etAddress.getText().toString();
        String message3 = etEmail.getText().toString();
        String message4 = etPhoneNo.getText().toString();

        if (!MESSAGE_KEY_Email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(message3).matches()) {

            Toast.makeText(this,"Successful Send!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

            intent.putExtra(MESSAGE_KEY, message);
            intent.putExtra(MESSAGE_KEY_Date, message1);
            intent.putExtra(MESSAGE_KEY_Address, message2);
            intent.putExtra(MESSAGE_KEY_Email, message3);
            intent.putExtra(MESSAGE_KEY_Phone, message4);

            startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid Email Address!", Toast.LENGTH_SHORT).show();
        }
    }
}
