package com.example.evneet_759831_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


     double carRent = 0;
     double noDays = 1;
     double amount = 0;
     double total = 0;
     ArrayList<String> details;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Spinner spinner = findViewById(R.id.spinner);
        final EditText rent = findViewById(R.id.daily_rent);
        SeekBar seekBar = findViewById(R.id.seekbar);
        final TextView days = findViewById(R.id.days);
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        final EditText amountEditText = findViewById(R.id.amount);
        final EditText totalEditText = findViewById(R.id.total);
        CheckBox checkBox1 = findViewById(R.id.c1);
        CheckBox checkBox2 = findViewById(R.id.c2);
        CheckBox checkBox3 = findViewById(R.id.c3);
        Button button = findViewById(R.id.button);
        final String[] dailyRent = {"0","20.0","19.09","25.60","55.0","43.87","36.54","38.76"};
        details = new ArrayList<>();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rent.setText("$" + dailyRent[position]);
                carRent = Double.parseDouble(dailyRent[position]);
                Amount();

                amountEditText.setText(String.format("$ %.2f",amount));
                totalEditText.setText(String.format("$ %.2f",total));

                details.add(spinner.getSelectedItem().toString());
                details.add(dailyRent[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                rent.setText("");
                amountEditText.setText("");
                totalEditText.setText("");

            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                days.setText(String.valueOf(progress));
                noDays = progress;

                Amount();
                amountEditText.setText(String.format("$ %.2f",amount));
                totalEditText.setText(String.format("$ %.2f",total));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.r1:
                         carRent += 5;
                        Amount();
                        amountEditText.setText(String.format("$ %.2f",amount));
                        totalEditText.setText(String.format("$ %.2f",total));
                        details.add(String.valueOf(noDays));
                        details.add("Less than 20");
                        break;
                    case R.id.r2:
                        carRent += 0;
                        Amount();
                        amountEditText.setText(String.format("$ %.2f",amount));
                        totalEditText.setText(String.format("$ %.2f",total));
                        details.add(String.valueOf(noDays));
                        details.add("Between 21 to 60");
                        break;
                    case R.id.r3:
                         carRent -= 10;
                        Amount();
                        amountEditText.setText(String.format("$ %.2f",amount));
                        totalEditText.setText(String.format("$ %.2f",total));
                        details.add(String.valueOf(noDays));
                        details.add("Above60");
                        break;

                }
            }
        });
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                carRent += 5;
                Amount();
                amountEditText.setText(String.format("$ %.2f",amount));
                totalEditText.setText(String.format("$ %.2f",total));
//                details.add("GPS");
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                carRent += 7;
                Amount();
                amountEditText.setText(String.format("$ %.2f",amount));
                totalEditText.setText(String.format("$ %.2f",total));
//                details.add("ChildSeat");
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                carRent += 10;
                Amount();
                amountEditText.setText(String.format("$ %.2f",amount));
                totalEditText.setText(String.format("$ %.2f",total));
//                details.add("Unlimited millage");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                details.add(String.valueOf(amount));
                details.add(String.valueOf(total));
                System.out.println(details);
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putStringArrayListExtra("carDetails",details);
                startActivity(intent);

            }
        });



    }
    private void Amount(){

        amount = carRent * noDays;
        total = amount + ((amount *13)/100);
    }
}
