package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView money;
    private int moneyCounter = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        money = findViewById(R.id.MoneyValue);
    }

    @SuppressLint("SetTextI18n")
    public void crorepatiBane(View view) {
        moneyCounter += 1000;
        money.setText("Rs. "+ moneyCounter);
        if(moneyCounter==20000) {
            money.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "DO IT QUICK", Toast.LENGTH_LONG)
                    .show();
        }
    }

    public void showInfo(View view) {
        Snackbar.make(money,"Looto re!!",-2)
                .setAction("Learn More!", view1 -> Toast.makeText(MainActivity.this,"Bhag yaha se",Toast.LENGTH_LONG)
                        .show())
                .show();
    }
}