package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LessonActivity extends AppCompatActivity {

    CardView cv_bangchucai, cv_nguyenam, cv_phuam, cv_van, cv_tu;
    ImageView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_activity);
        mapping();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(h);
            }
        });

        cv_bangchucai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bangchucai = new Intent(getApplicationContext(),AlphabetActivity.class);
                startActivity(bangchucai);
            }
        });
        cv_nguyenam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nguyenam = new Intent(getApplicationContext(),NguyenAmActivity.class);
                startActivity(nguyenam);
            }
        });
        cv_phuam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phuam = new Intent(getApplicationContext(),PhuAmActivity.class);
                startActivity(phuam);
            }
        });
        cv_van.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent van = new Intent(getApplicationContext(),VanActivity.class);
                startActivity(van);
            }
        });
        cv_tu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tu = new Intent(getApplicationContext(),GhepTuActivity.class);
                startActivity(tu);
            }
        });
    }

    private void mapping() {
        cv_bangchucai = findViewById(R.id.cardview_bangchucai);
        cv_nguyenam = findViewById(R.id.cardview_nguyenam);
        cv_phuam = findViewById(R.id.cardview_phuam);
        cv_van = findViewById(R.id.cardview_van);
        cv_tu = findViewById(R.id.cardview_tu);
        home = findViewById(R.id.img_home_lesson);
    }
}