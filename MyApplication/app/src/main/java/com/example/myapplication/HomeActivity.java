package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {


    DBHelper db;
    DrawerLayout drawerLayout_home;
    NavigationView navigationView_home;
    ActionBarDrawerToggle toggle;
    TextView hello;
    String user_name, pass, ten, email;
    CardView cv_tiengviet, toan;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background)));
        db = new DBHelper(HomeActivity.this, "users.sqlite", null,1);

        // ánh xạ-
        mapping();
        Cursor dataUser = db.GetData("SELECT * FROM users");
        while (dataUser.moveToNext())
        {
            String hoten = dataUser.getString(2);
            hello.setText("Chào bé "+hoten);
        }

        //--sự kiện scroll side bar --//
        toggle = new ActionBarDrawerToggle(this, drawerLayout_home, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout_home.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // tạo sự kiện click cho từng item sidebar
        navigationView_home.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_hoso:
                        Dialog dialog = new Dialog(HomeActivity.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.dialog_profile);
                        dialog.setCanceledOnTouchOutside(false);

                        TextView profile_username = dialog.findViewById(R.id.profile_username);
                        ImageView img_sua_hoten = dialog.findViewById(R.id.img_sua_profile_hoten);
                        ImageView img_sua_email = dialog.findViewById(R.id.img_sua_profile_email);
                        ImageView img_close_dialog_profile = dialog.findViewById(R.id.img_close_dialog_profile);
                        EditText et_hoten = dialog.findViewById(R.id.et_profile_hoten);
                        EditText et_email = dialog.findViewById(R.id.et_profile_email);

                        Cursor dataUser = db.GetData("SELECT * FROM users WHERE username = '"+user_name+"'");
                        while (dataUser.moveToNext())
                        {
                            String user_name = dataUser.getString(0);
                            String pass = dataUser.getString(1);
                            String ten = dataUser.getString(2);
                            String mail = dataUser.getString(3);
                            profile_username.setText(user_name);
                            et_hoten.setText(ten);
                            et_email.setText(mail);
                        }


                        dialog.show();
                        img_close_dialog_profile.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                return;
                            }
                        });

                        img_sua_hoten.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String new_ten = et_hoten.getText().toString();
                                db.QueryData("UPDATE users SET name = '"+new_ten+"' WHERE username = '"+user_name+"' ");
                                Toast.makeText(HomeActivity.this, "Sửa họ tên thành công", Toast.LENGTH_SHORT).show();
                                ActionGetData();
                                hello.setText("Xin chào, "+new_ten);
                            }
                        });

                        img_sua_email.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String new_mail = et_email.getText().toString();
                                db.QueryData("UPDATE users SET email = '"+new_mail+"' WHERE username = '"+user_name+"' ");
                                Toast.makeText(HomeActivity.this, "Thêm email thành công", Toast.LENGTH_SHORT).show();
                                ActionGetData();
                            }
                        });

                        return true;

                    case R.id.nav_quatrinh:
                        Toast.makeText(HomeActivity.this, "quatrinh", Toast.LENGTH_SHORT).show();;
                        return true;

                    case R.id.nav_danhgia:
                        Intent intent3 = new Intent(getApplicationContext(), RateUsActivity.class);
                        startActivity(intent3);
                        return true;

                    case R.id.nav_meohoctot:
                        Intent intent4 = new Intent(getApplicationContext(),TipsActivity.class);
                        startActivity(intent4);
                        return true;

                    case R.id.nav_infor:
                        Intent intent5 = new Intent(getApplicationContext(), AboutUsActivity.class);
                        startActivity(intent5);
                        return true;
                    case R.id.nav_log_out:
                        Intent intent6 = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent6);
                        return true;
                }
                return true;
            }
        });

        // set sự kiện mô tiếng việt
        cv_tiengviet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tiengviet = new Intent(getApplicationContext(),LessonActivity.class);
                startActivity(tiengviet);
            }
        });

    }

    private void mapping() {
        drawerLayout_home = findViewById(R.id.main_drawlayout);
        navigationView_home = findViewById(R.id.navigatioview);
        hello = findViewById(R.id.tv_hello);
        cv_tiengviet = findViewById(R.id.cardview_tiengviet);
    }

    public void ActionGetData()
    {
        Cursor dataUser = db.GetData("SELECT * FROM users");
        while (dataUser.moveToNext())
        {
            String user_name = dataUser.getString(0);
            String pass = dataUser.getString(1);
            String hoten = dataUser.getString(2);
            String email = dataUser.getString(3);
        }
    }
}