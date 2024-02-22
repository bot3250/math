package com.bot.math;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView equationOne, equationTwo, equationThree;
    private EditText solvingOne, solvingTwo, solvingThree;
    private Button button;
    private int[] equationValue;
    private boolean right = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equationOne = findViewById(R.id.equationOne);
        equationTwo = findViewById(R.id.equationTwo);
        equationThree = findViewById(R.id.equationThree);
        solvingOne = findViewById(R.id.solvingOne);
        solvingTwo = findViewById(R.id.solvingTwo);
        solvingThree = findViewById(R.id.solvingThree);
        button = findViewById(R.id.button);

        equationValue = valueArrayRandom();

        equationOne.setText(equationValue[0] + " + " + equationValue[1] + " = ");
        equationTwo.setText(equationValue[2] + " + " + equationValue[3] + " = ");
        equationThree.setText(equationValue[4] + " + " + equationValue[5] + " = ");

        solvingOne.setOnFocusChangeListener(focusListener);
        solvingTwo.setOnFocusChangeListener(focusListener);
        solvingThree.setOnFocusChangeListener(focusListener);
        button.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @SuppressLint("ResourceAsColor")
        @Override
        public void onClick(View view) {
            equationValue = valueArrayRandom();
            equationOne.setText(equationValue[0] + " + " + equationValue[1] + " = ");
            equationTwo.setText(equationValue[2] + " + " + equationValue[3] + " = ");
            equationThree.setText(equationValue[4] + " + " + equationValue[5] + " = ");
            solvingOne.setText("");
            solvingTwo.setText("");
            solvingThree.setText("");
            solvingOne.setBackgroundColor(Color.WHITE);
            solvingTwo.setBackgroundColor(Color.WHITE);
            solvingThree.setBackgroundColor(Color.WHITE);

        }
    };

    private View.OnFocusChangeListener focusListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean b) {
            switch (view.getId()) {
                case R.id.solvingOne:
                    if(!b) {
                        if(Integer.parseInt(solvingOne.getText().toString()) == (equationValue[0] + equationValue[1])) {
                            solvingOne.setBackgroundColor(Color.GREEN);
                            right = true;
                        } else {
                            solvingOne.setBackgroundColor(Color.RED);
                            right = false;
                        }
                    }
                    break;
                case R.id.solvingTwo:
                    if(!b) {
                        if(Integer.parseInt(solvingTwo.getText().toString()) == (equationValue[2] + equationValue[3])) {
                            solvingTwo.setBackgroundColor(Color.GREEN);
                            right = true;
                        } else {
                            solvingTwo.setBackgroundColor(Color.RED);
                            right = false;
                        }
                    }
                    break;
                case R.id.solvingThree:
                    if(!b) {
                        if(Integer.parseInt(solvingThree.getText().toString()) == (equationValue[4] + equationValue[5])) {
                            solvingThree.setBackgroundColor(Color.GREEN);
                            right = true;
                        } else {
                            solvingThree.setBackgroundColor(Color.RED);
                            right = false;
                        }
                    }
                    break;
            }
        }
    };

    private int[] valueArrayRandom() {
        Random random = new Random();
        int[] arrayValue = new int[6];
        for (int i = 0; i < arrayValue.length; i++) {
            arrayValue[i] = random.nextInt(99) + 1;
        }
        return arrayValue;
    }
}