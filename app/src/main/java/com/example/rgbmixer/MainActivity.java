package com.example.rgbmixer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn, randombtn;
    SeekBar redBar, greenBar, blueBar;
    Integer red, green, blue;
    EditText redNo, greenNo, blueNo;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        randombtn = findViewById(R.id.random);
        redBar = findViewById(R.id.redBar);
        greenBar = findViewById(R.id.greenBar);
        blueBar = findViewById(R.id.blueBar);
        redNo = findViewById(R.id.redNo);
        greenNo = findViewById(R.id.greenNo);
        blueNo = findViewById(R.id.blueNo);

        red = rand.nextInt(256);
        green = rand.nextInt(256);
        blue = rand.nextInt(256);

        redBar.setProgress(red);
        greenBar.setProgress(green);
        blueBar.setProgress(blue);

        btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#"+toHex(red)+toHex(green)+toHex(blue))));
        redNo.setText(red.toString());
        greenNo.setText(green.toString());
        blueNo.setText(blue.toString());

        redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#"+toHex(red)+toHex(green)+toHex(blue))));
                redNo.setText(red.toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                return;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                return;
            }
        });

        greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                green = progress;
                btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#"+toHex(red)+toHex(green)+toHex(blue))));
                greenNo.setText(green.toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                return;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                return;
            }
        });

        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#"+toHex(red)+toHex(green)+toHex(blue))));
                blueNo.setText(blue.toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                return;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                return;
            }
        });

        randombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red = rand.nextInt(256);
                green = rand.nextInt(256);
                blue = rand.nextInt(256);

                redBar.setProgress(red);
                greenBar.setProgress(green);
                blueBar.setProgress(blue);

                btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#"+toHex(red)+toHex(green)+toHex(blue))));
                redNo.setText(red.toString());
                greenNo.setText(green.toString());
                blueNo.setText(blue.toString());
            }
        });

    }

    public static String toHex(Integer num)
    {
        // For storing remainder
        int rem;
        boolean once = false;

        // For storing result
        String str2="";

        // Digits in hexadecimal number system
        char[] hex ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while(!once) {
            rem = num % 16;
            str2 = hex[rem] + str2;
            num = num / 16;

            if (num == 0) {
                once = true;
            }
        }
        if (str2.length()==1) {
            str2 = "0" + str2;
        }
        return str2;
    }

}