package com.example.mahadi.edittextapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText number1,number2;
    private Button btn_add,btn_subs;
    private TextView resultShow;
    double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.edit_text);
        number2 = (EditText) findViewById(R.id.edit_text2);

        btn_add  = (Button) findViewById(R.id.add);
        btn_subs = (Button) findViewById(R.id.subs);

        resultShow = (TextView) findViewById(R.id.resultShow);

        btn_add.setOnClickListener(this);
        btn_subs.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        try{
            String num1 = number1.getText().toString();
            String num2 = number2.getText().toString();

            //Converting into double

            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);

            switch (view.getId()){

                case R.id.add:
                    result = n1+n2;
                    resultShow.setText(n1 + " + " + n2 + " = " + new DecimalFormat("##.##").format(result));
                    break;

                case R.id.subs:
                    result = n1-n2;
                    resultShow.setText(n1 + " - " + n2 + " = " + new DecimalFormat("##.##").format(result));
                    break;

            }
        }catch(Exception e){
            Toast.makeText(MainActivity.this, "Please Enter number", Toast.LENGTH_SHORT).show();

        }
    }
}
