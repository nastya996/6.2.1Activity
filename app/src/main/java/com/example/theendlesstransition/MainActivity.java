package com.example.theendlesstransition;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button mNextBtn;
    private Button mBackBtn;
    private TextView textView_number;
    Random random = new Random();
    int activityNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mNextBtn = findViewById(R.id.mNextBtn);
        mBackBtn = findViewById(R.id.mBackBtn);

        mNextBtn.setOnClickListener(clickListener_next);
       mBackBtn.setOnClickListener(clickListener_back);

        textView_number = findViewById(R.id.textView_number);
        activityNumber = Integer.parseInt(String.valueOf(random.nextInt(101)));
        nextActivity();
        Log.d("Lifecycle", activityNumber + "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", activityNumber + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", activityNumber + "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", activityNumber + "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", activityNumber + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", activityNumber + "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", activityNumber + "onRestart");
    }

    private View.OnClickListener clickListener_next = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,
                    MainActivity.class );
            startActivity(intent);
        }
    };

    @SuppressLint("SetTextI18n")
    private void nextActivity() {
        textView_number.setText("http://myfile.org/" +
                activityNumber);
    }

    private View.OnClickListener clickListener_back = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}