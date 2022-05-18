package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btn_signIn;
    DBHelper db;
    TextView have_no_acc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.et_username_sign_in);
        password = findViewById(R.id.et_password_sign_in);
        btn_signIn = findViewById(R.id.btn_sign_in);
        have_no_acc = findViewById(R.id.have_no_account);

        db = new DBHelper(LoginActivity.this, "users.sqlite", null,1);

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(LoginActivity.this, "Yêu cầu nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                else
                {
                    Boolean checkAccount = db.checkAccount(user,pass);
                    if (checkAccount == true) {
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(LoginActivity.this, "Mật khẩu hoặc tài khoản không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });

        have_no_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
