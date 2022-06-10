package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class AlphabetActivity extends AppCompatActivity {

    GridLayout parent_card;
    CardView a,aw,aa,b,c,d,dd,e,ee,g,h,i,k,l,m,n,o,oo,ow,p,q,r,s,t,u,uw,v,x,y;
    MediaPlayer audio_apb;
    GifImageView gif_next, gif_back;
    ImageView img_lesson, img_home;
 //   DBHelper db_content_subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        mapping();
        setSingleEvent(parent_card);

        // insert dữ liệu cho table Alphabet
//        db_content_subject = new DBHelper(AlphabetActivity.this, "alphabet.sqlite", null,1);
//        db_content_subject.QueryData("CREATE TABLE IF NOT EXISTS alphabet(subject, lesson TEXT, content TEXT primary key)");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'a')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'ă')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'â')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'b')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'c')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'd')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'đ')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'e')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'ê')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'g')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'h')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'i')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'k')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'l')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'm')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'n')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'o')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'ô')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'ơ')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'p')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'q')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'r')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 's')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 't')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'u')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'ư')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'v')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'x')");
//        db_content_subject.QueryData("INSERT INTO alphabet VALUES ('Tiếng Việt', 'Bảng chữ cái', 'y')");

        //set sự kiện cho home
        img_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(home);
            }
        });

        gif_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlphabetActivity.this);
                builder.setMessage("Bé có muốn chuyển sang học nguyên âm?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent na = new Intent(getApplicationContext(), NguyenAmActivity.class);
                        startActivity(na);
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();

            }
        });
        gif_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlphabetActivity.this);
                builder.setMessage("Bé có muốn chuyển sang danh sách bài học?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent lesson = new Intent(getApplicationContext(), LessonActivity.class);
                        startActivity(lesson);
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();

            }
        });

    }

    // set âm thanh cho card view
    private void setSingleEvent(GridLayout parent_card) {
        for (int i = 0; i < parent_card.getChildCount();i++)
        {
            final int indexx = i;
            CardView cardView = (CardView) parent_card.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (indexx){
                        case 0:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_a);
                            audio_apb.start();
                            break;
                        case 1:
                            audio_apb= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_aw);
                            audio_apb.start();
                            break;
                        case 2:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_aa);
                            audio_apb.start();
                            break;
                        case 3:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_b);
                            audio_apb.start();
                            break;
                        case 4:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_c);
                            audio_apb.start();
                            break;
                        case 5:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_d);
                            audio_apb.start();
                            break;
                        case 6:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_dd);
                            audio_apb.start();
                            break;
                        case 7:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_e);
                            audio_apb.start();
                            break;
                        case 8:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_ee);
                            audio_apb.start();
                            break;
                        case 9:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_g);
                            audio_apb.start();
                            break;
                        case 10:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_h);
                            audio_apb.start();
                            break;
                        case 11:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_i);
                            audio_apb.start();
                            break;
                        case 12:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_k);
                            audio_apb.start();
                            break;
                        case 13:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_l);
                            audio_apb.start();
                            break;
                        case 14:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_m);
                            audio_apb.start();
                            break;
                        case 15:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_n);
                            audio_apb.start();
                            break;
                        case 16:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_o);
                            audio_apb.start();
                            break;
                        case 17:
                            audio_apb= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_oo);
                            audio_apb.start();
                            break;
                        case 18:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_ow);
                            audio_apb.start();
                            break;
                        case 19:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_p);
                            audio_apb.start();
                            break;
                        case 20:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_q);
                            audio_apb.start();
                            break;
                        case 21:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_r);
                            audio_apb.start();
                            break;
                        case 22:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_s);
                            audio_apb.start();
                            break;
                        case 23:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_t);
                            audio_apb.start();
                            break;
                        case 24:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_u);
                            audio_apb.start();
                            break;
                        case 25:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_uw);
                            audio_apb.start();
                            break;
                        case 26:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_v);
                            audio_apb.start();
                            break;
                        case 27:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_x);
                            audio_apb.start();
                            break;
                        case 28:
                            audio_apb = MediaPlayer.create(AlphabetActivity.this,R.raw.audio_i);
                            audio_apb.start();
                            break;


                    }
                }
            });
        }
    }


    // ánh xạ
    private void mapping() {
        a = findViewById(R.id.cv_a);
        aw = findViewById(R.id.cv_aw);
        aa = findViewById(R.id.cv_aa);
        b = findViewById(R.id.cv_b);
        c = findViewById(R.id.cv_c);
        d = findViewById(R.id.cv_d);
        dd = findViewById(R.id.cv_dd);
        e = findViewById(R.id.cv_e);
        ee = findViewById(R.id.cv_ee);
        g = findViewById(R.id.cv_g);
        h = findViewById(R.id.cv_h);
        i = findViewById(R.id.cv_i);
        k = findViewById(R.id.cv_k);
        l = findViewById(R.id.cv_l);
        m = findViewById(R.id.cv_m);
        n = findViewById(R.id.cv_n);
        o = findViewById(R.id.cv_o);
        oo = findViewById(R.id.cv_oo);
        ow = findViewById(R.id.cv_ow);
        p = findViewById(R.id.cv_p);
        q = findViewById(R.id.cv_q);
        r = findViewById(R.id.cv_r);
        s = findViewById(R.id.cv_s);
        t = findViewById(R.id.cv_t);
        u = findViewById(R.id.cv_u);
        uw = findViewById(R.id.cv_uw);
        x = findViewById(R.id.cv_x);
        v = findViewById(R.id.cv_v);
        y = findViewById(R.id.cv_y);
        parent_card = findViewById(R.id.parent_card);
        gif_next = (GifImageView) findViewById(R.id.next_gif_apb);
        gif_back = (GifImageView) findViewById(R.id.back_gif_apb);
        img_home = findViewById(R.id.img_home_apb);
    }
}