package com.example.evneet_759831_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView name = findViewById(R.id.name);
        TextView p = findViewById(R.id.price);
        TextView days = findViewById(R.id.days);
        TextView age = findViewById(R.id.age);

        TextView amount = findViewById(R.id.amount);
        TextView totalPay = findViewById(R.id.total);
        ArrayList<String> carDetails = (ArrayList<String>) getIntent().getSerializableExtra("carDetails");

        name.setText(String.valueOf(carDetails.get(2)));
        p.setText(String.valueOf(carDetails.get(3)));
        days.setText(String.valueOf(carDetails.get(4)));
        age.setText(String.valueOf(carDetails.get(5)));
        amount.setText(String.valueOf(carDetails.get(6)));
        totalPay.setText(String.valueOf(carDetails.get(7)));




    }
}
