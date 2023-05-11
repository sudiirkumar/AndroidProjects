package com.sudhir.ironmanvscaptain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView img[][] = new TextView[3][3];
    String btn_txt[][] = new String[3][3];
    boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img[0][0] = findViewById(R.id.btn00);
        img[0][1] = findViewById(R.id.btn01);
        img[0][2] = findViewById(R.id.btn02);
        img[1][0] = findViewById(R.id.btn10);
        img[1][1] = findViewById(R.id.btn11);
        img[1][2] = findViewById(R.id.btn12);
        img[2][0] = findViewById(R.id.btn20);
        img[2][1] = findViewById(R.id.btn21);
        img[2][2] = findViewById(R.id.btn22);

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                img[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View view) {
        TextView curr = (TextView) view;
        if(curr.getText().toString().equals("-")){
            if (flag) {
                //iron man
                curr.setText("O");
                flag = false;
            } else {
                curr.setText("X");
                flag = true;
            }
        }
    }
    public void check(){
        //check rows
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if()
            }
        }
    }
}