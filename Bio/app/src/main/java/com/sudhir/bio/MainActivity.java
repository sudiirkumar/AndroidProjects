package com.sudhir.bio;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sudhir.bio.data.Bio;
import com.sudhir.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Bio bio = new Bio();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bio.setName("Sudhir Kumar");
        binding.setBio(bio);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
    }

    public void buttonClicked(View view) {
        binding.hobbi.setText("Hobbies: "+binding.hobbiInput.getText().toString().trim());
        binding.hobbi.setVisibility(View.VISIBLE);
        //hide the keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromInputMethod(view.getWindowToken(),0);
    }
}