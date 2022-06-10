package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewActivity extends AppCompatActivity {

    CardView cv_gheptu, cv_ghepcau, cv_tapdoc;
    ImageView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        mapping();

        // set su kien

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(h);
            }
        });

        cv_ghepcau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gc = new Intent(getApplicationContext(), OTGhepCauActivity.class);
                startActivity(gc);
            }
        });
        cv_gheptu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gt = new Intent(getApplicationContext(), OTGhepTuActivity.class);
                startActivity(gt);
            }
        });
        cv_tapdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(ReviewActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_tapdoc);

                TextView tv;
                tv= dialog.findViewById(R.id.tv_tapdoc_link);
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                dialog.show();
                Toast.makeText(ReviewActivity.this, "Chuyển sang youtube thành công!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void mapping()
    {
        //cv_ghepvan = findViewById(R.id.cardview_ghepvan_test);
        cv_gheptu = findViewById(R.id.cardview_gheptu_test);
        cv_ghepcau = findViewById(R.id.cardview_ghepcau_test);
        cv_tapdoc = findViewById(R.id.cardview_tapdoc_test);
        home = findViewById(R.id.img_home_rv);
    }
}