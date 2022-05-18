package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LessonActivity extends AppCompatActivity {

    CardView cv_bangchucai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_activity);

        mapping();
        cv_bangchucai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bangchucai = new Intent(getApplicationContext(),AlphabetActivity.class);
                startActivity(bangchucai);
            }
        });
    }

    private void mapping() {
        cv_bangchucai = findViewById(R.id.cardview_bangchucai);
    }
}