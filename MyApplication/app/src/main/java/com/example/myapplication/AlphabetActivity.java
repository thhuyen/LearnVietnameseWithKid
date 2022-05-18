package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class AlphabetActivity extends AppCompatActivity {

    GridLayout parent_card;
    CardView a,aw,aa,b,c,d,dd,e,ee,g,h,i,k,l,m,n,o,oo,ow,p,q,r,s,t,u,uw,v,x,y;
    ImageView img_home;
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
                            MediaPlayer player0= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_a);
                            player0.start();
                            break;
                        case 1:
                            MediaPlayer player1= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_aw);
                            player1.start();
                            break;
                        case 2:
                            MediaPlayer player2= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_aa);
                            player2.start();
                            break;
                        case 3:
                            MediaPlayer player3= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_b);
                            player3.start();
                            break;
                        case 4:
                            MediaPlayer player4= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_c);
                            player4.start();
                            break;
                        case 5:
                            MediaPlayer player5= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_d);
                            player5.start();
                            break;
                        case 6:
                            MediaPlayer player6= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_dd);
                            player6.start();
                            break;
                        case 7:
                            MediaPlayer player7= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_e);
                            player7.start();
                            break;
                        case 8:
                            MediaPlayer player8= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_ee);
                            player8.start();
                            break;
                        case 9:
                            MediaPlayer player9= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_g);
                            player9.start();
                            break;
                        case 10:
                            MediaPlayer player10= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_h);
                            player10.start();
                            break;
                        case 11:
                            MediaPlayer player11= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_i);
                            player11.start();
                            break;
                        case 12:
                            MediaPlayer player12= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_k);
                            player12.start();
                            break;
                        case 13:
                            MediaPlayer player13= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_l);
                            player13.start();
                            break;
                        case 14:
                            MediaPlayer player14= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_m);
                            player14.start();
                            break;
                        case 15:
                            MediaPlayer player15= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_n);
                            player15.start();
                            break;
                        case 16:
                            MediaPlayer player16= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_o);
                            player16.start();
                            break;
                        case 17:
                            MediaPlayer player17= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_oo);
                            player17.start();
                            break;
                        case 18:
                            MediaPlayer player18= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_ow);
                            player18.start();
                            break;
                        case 19:
                            MediaPlayer player19= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_p);
                            player19.start();
                            break;
                        case 20:
                            MediaPlayer player20= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_q);
                            player20.start();
                            break;
                        case 21:
                            MediaPlayer player21= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_r);
                            player21.start();
                            break;
                        case 22:
                            MediaPlayer player22= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_s);
                            player22.start();
                            break;
                        case 23:
                            MediaPlayer player23= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_t);
                            player23.start();
                            break;
                        case 24:
                            MediaPlayer player24= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_u);
                            player24.start();
                            break;
                        case 25:
                            MediaPlayer player25= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_uw);
                            player25.start();
                            break;
                        case 26:
                            MediaPlayer player26= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_v);
                            player26.start();
                            break;
                        case 27:
                            MediaPlayer player27= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_x);
                            player27.start();
                            break;
                        case 28:
                            MediaPlayer player28= MediaPlayer.create(AlphabetActivity.this,R.raw.audio_i);
                            player28.start();
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
        img_home = findViewById(R.id.img_home);
    }
}