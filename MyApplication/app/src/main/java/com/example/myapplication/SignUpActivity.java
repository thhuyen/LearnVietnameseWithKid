package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity  {


    Button btn_signUp;
    EditText et_username_signUp, et_password_signUp, et_repassword_signUp;
    DBHelper db;
    TextView have_acc;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        et_username_signUp = findViewById(R.id.et_username_sign_up);
        et_password_signUp = findViewById(R.id.et_password_sign_up);
        et_repassword_signUp = findViewById(R.id.et_repassword_sign_up);
        btn_signUp = findViewById(R.id.btn_sign_up);
        have_acc = findViewById(R.id.have_account);

        db = new DBHelper(SignUpActivity.this, "users.sqlite", null,1);
        db.QueryData("CREATE TABLE IF NOT EXISTS users(username TEXT PRIMARY KEY , password TEXT, name TEXT, email TEXT)");
        //db.QueryData("DROP TABLE users");


        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = et_username_signUp.getText().toString();
                String pass = et_password_signUp.getText().toString();
                String repass = et_repassword_signUp.getText().toString();
                String name = et_username_signUp.getText().toString();
                String mail = "user@123";

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(SignUpActivity.this, "Yêu cầu nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                else
                {
                    if (pass.equals(repass)) {
                        Boolean checkUser = db.checkUsername(user);
                        if (checkUser == false)
                        {
                            Boolean insert = db.insertData(user, pass, name,mail);
                            if (insert == true)
                            {
                                Toast.makeText(SignUpActivity.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                                startActivity(intent);
                            }
                            else // insert == false
                                Toast.makeText(SignUpActivity.this, "Tạo tài khoản thất bại", Toast.LENGTH_SHORT).show();
                        }
                        else // checkUser == true
                            Toast.makeText(SignUpActivity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(SignUpActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }
            }
        });

        have_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}