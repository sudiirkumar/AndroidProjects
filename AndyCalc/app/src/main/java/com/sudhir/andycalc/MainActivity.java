package com.sudhir.andycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    boolean wasEqual;
    boolean isResultSize30;
    MaterialButton button_allclear,button_clear,button_percent,button_divide;
    MaterialButton button_7,button_8,button_9,button_multi;
    MaterialButton button_4,button_5,button_6,button_minus;
    MaterialButton button_1,button_2,button_3,button_plus;
    MaterialButton button_switch,button_0,button_dot,button_equals;
    TextView tv_result,tv_solution;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result = findViewById(R.id.tv_result);
        tv_solution = findViewById(R.id.tv_solution);
        assignId(button_0,R.id.button_0);
        assignId(button_1,R.id.button_1);
        assignId(button_2,R.id.button_2);
        assignId(button_3,R.id.button_3);
        assignId(button_4,R.id.button_4);
        assignId(button_5,R.id.button_5);
        assignId(button_6,R.id.button_6);
        assignId(button_7,R.id.button_7);
        assignId(button_8,R.id.button_8);
        assignId(button_9,R.id.button_9);
        assignId(button_allclear,R.id.button_allclear);
        assignId(button_clear,R.id.button_clear);
        assignId(button_percent,R.id.button_percent);
        assignId(button_divide,R.id.button_divide);
        assignId(button_multi,R.id.button_multi);
        assignId(button_minus,R.id.button_minus);
        assignId(button_plus,R.id.button_plus);
        assignId(button_equals,R.id.button_equal);
        assignId(button_dot,R.id.button_dot);
        assignId(button_switch,R.id.button_switch);
    }
    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = tv_solution.getText().toString();
        if(wasEqual){
            wasEqual = false;
            tv_solution.setTextSize(60);
            String textToShow = tv_result.getText().toString();
            if(textToShow.startsWith("= ")){
                textToShow = textToShow.substring(2);
            }
            dataToCalculate = textToShow;
        }
        if(buttonText.equals("AC")){
            tv_solution.setText("");
            tv_result.setText("0");
            tv_result.setTextSize(60);
            isResultSize30 = false;
            return;
        }
        if(buttonText.equals("=")){
            wasEqual = true;
            if(!dataToCalculate.equals("")){
                tv_solution.setTextSize(30);
                tv_result.setTextSize(60);
                isResultSize30 = false;
            }
            return;
        }
        if(buttonText.equals("C")){
            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            return;
        }
        dataToCalculate = dataToCalculate + buttonText;
        if((!isResultSize30) && (!dataToCalculate.equals(""))){
            tv_result.setTextSize(30);
            isResultSize30 = true;
        }
        tv_solution.setText(dataToCalculate);
        String finalRes = getResult(dataToCalculate);
        if(!finalRes.equals("Error")){
            tv_result.setText("= "+finalRes);
        }
    }
    String getResult(String data){
        try{
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable,data,"JavaScript",1,null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.substring(0,finalResult.length()-2);
            }
            return finalResult;
        }catch (Exception e){
            return "Error";
        }
    }
}