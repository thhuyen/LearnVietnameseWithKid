package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class OTGhepTuActivity extends AppCompatActivity {

    int ot_img_question[] = {R.drawable.ot_a_ma, R.drawable.ot_aw_ngua, R.drawable.ot_aa_mualan, R.drawable.ot_b_bongbong,
            R.drawable.ot_c_ca, R.drawable.ot_d_de, R.drawable.ot_dd_den, R.drawable.ot_e_xe, R.drawable.ot_ee_le, R.drawable.ot_g_ga,
            R.drawable.ot_h_hoa, R.drawable.ot_i_vienbi, R.drawable.ot_k_keo, R.drawable.ot_l_la, R.drawable.ot_m_meo, R.drawable.ot_n_no,
            R.drawable.ot_o_nho, R.drawable.ot_oo_xo, R.drawable.ot_ow_quabo, R.drawable.ot_p_denpin, R.drawable.ot_q_qua, R.drawable.ot_r_ro,
            R.drawable.ot_s_soc, R.drawable.ot_t_tom, R.drawable.ot_u_susu, R.drawable.ot_uw_letter, R.drawable.ot_v_vit, R.drawable.ot_x_xeng, R.drawable.ot_y_chimyen};

    String ot_answer[] = {"a","ă","â","b","c","d","đ","e","ê","g","h","i","k","l","m","n","o","ô","ơ", "p","q","r","s","t","u","ư","v","x","y"};

    int ot_img_answer[] = {R.drawable.ot_a, R.drawable.ot_aw, R.drawable.ot_aa, R.drawable.ot_b,
            R.drawable.ot_c, R.drawable.ot_d, R.drawable.ot_dd, R.drawable.ot_e, R.drawable.ot_ee, R.drawable.ot_g,
            R.drawable.ot_h, R.drawable.ot_i, R.drawable.ot_k, R.drawable.ot_l, R.drawable.ot_m, R.drawable.ot_n,
            R.drawable.ot_o, R.drawable.ot_oo, R.drawable.ot_ow, R.drawable.ot_p, R.drawable.ot_q, R.drawable.ot_r,
            R.drawable.ot_s, R.drawable.ot_t, R.drawable.ot_u, R.drawable.ot_uw, R.drawable.ot_v, R.drawable.ot_x, R.drawable.ot_y};
    ImageView loca1, loca2, loca3, loca4, img_ques;
    DBHelper GhepTuHelper;
    int numberQues = 0;
    TextView tv_ques;
    Boolean checked;
    GifImageView gif_next, gif_back;
    ImageView img_lesson, img_home;
    int position = 0;
    LinkedList<Integer> numbers = new LinkedList<Integer>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otghep_tu);
        database();
        findViewByIds();
        update();

        img_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(home);
            }
        });
        img_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lesson = new Intent(getApplicationContext(),ReviewActivity.class);
                startActivity(lesson);
            }
        });
        gif_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberQues >= 28) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(OTGhepTuActivity.this);
                    builder.setMessage("Bé có muốn chuyển sang ôn tập câu?");
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent gc = new Intent(getApplicationContext(), OTGhepCauActivity.class);
                            startActivity(gc);
                        }
                    });
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();
                }
                else
                {
                    numberQues++;
                    update();
                }
            }
        });
        gif_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberQues <= 0)
                {
                    Intent lesson = new Intent(getApplicationContext(),ReviewActivity.class);
                    startActivity(lesson);
                }
                else
                {
                    numberQues--;
                    update();
                }
            }
        });



        loca1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    Toast.makeText(OTGhepTuActivity.this, "Bé giỏi quá!", Toast.LENGTH_SHORT).show();
                    MediaPlayer ring= MediaPlayer.create(OTGhepTuActivity.this,R.raw.audio_dung);
                    ring.start();
                }
                else
                {
                    Toast.makeText(OTGhepTuActivity.this, "Tiếc quá, sai mất rồi!", Toast.LENGTH_SHORT).show();
                    MediaPlayer ring= MediaPlayer.create(OTGhepTuActivity.this,R.raw.audio_sai);
                    ring.start();
                }
            }
        });
        loca2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 1) {
                    Toast.makeText(OTGhepTuActivity.this, "Bé giỏi quá!", Toast.LENGTH_SHORT).show();
                    MediaPlayer ring= MediaPlayer.create(OTGhepTuActivity.this,R.raw.audio_dung);
                    ring.start();
                }
                else
                {
                    Toast.makeText(OTGhepTuActivity.this, "Tiếc quá, sai mất rồi!", Toast.LENGTH_SHORT).show();
                    MediaPlayer ring= MediaPlayer.create(OTGhepTuActivity.this,R.raw.audio_sai);
                    ring.start();
                }
            }
        });
        loca3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 2) {
                    Toast.makeText(OTGhepTuActivity.this, "Bé giỏi quá!", Toast.LENGTH_SHORT).show();
                    MediaPlayer ring= MediaPlayer.create(OTGhepTuActivity.this,R.raw.audio_dung);
                    ring.start();
                }
                else
                {
                    Toast.makeText(OTGhepTuActivity.this, "Tiếc quá, sai mất rồi!", Toast.LENGTH_SHORT).show();
                    MediaPlayer ring= MediaPlayer.create(OTGhepTuActivity.this,R.raw.audio_sai);
                    ring.start();
                }
            }
        });
        loca4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 3)
                {
                    Toast.makeText(OTGhepTuActivity.this, "Bé giỏi quá!", Toast.LENGTH_SHORT).show();
                    MediaPlayer ring= MediaPlayer.create(OTGhepTuActivity.this,R.raw.audio_dung);
                    ring.start();
                }
                else {
                    Toast.makeText(OTGhepTuActivity.this, "Tiếc quá, sai mất rồi!", Toast.LENGTH_SHORT).show();
                    MediaPlayer ring= MediaPlayer.create(OTGhepTuActivity.this,R.raw.audio_sai);
                    ring.start();
                }
            }
        });
    }

    private void database() {
        GhepTuHelper = new DBHelper(OTGhepTuActivity.this, "exam.sqlite", null,1);
        GhepTuHelper.QueryData("CREATE TABLE IF NOT EXISTS GhepTu (Id INTEGER PRIMARY KEY AUTOINCREMENT, question TEXT PRIMATY KEY, key TEXT)");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'con m...', 'a')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'ngựa v...`n', 'ă')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'múa l...n', 'â')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, '...óng ...ay', 'b')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, '...on ...á', 'c')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'con ...ê', 'd')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'cái ...èn', 'đ')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'cái x...', 'e')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'quả l...', 'ê')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'con ...à', 'g')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, '...oa ...ồng', 'h')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'viên b...', 'i')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'cây ...éo', 'k')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'cái ...á', 'l')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'con ...èo', 'm')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'cái ...ơ', 'n')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'chùm nh...', 'o')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'cái x...', 'ô')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'quả b...', 'ơ')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'đèn ...in', 'p')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'con ...uạ', 'q')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'cái ...ổ', 'r')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'con ...óc', 's')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'con ...ôm', 't')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'quả s... s...', 'u')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'lá th...', 'ư')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'con ...ịt', 'v')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'cái ...ẻng', 'x')");
//        GhepTuHelper.QueryData("INSERT INTO GhepTu VALUES (null, 'chim ...ến', 'y')");
//        GhepTuHelper.QueryData("DROP TABLE GhepTu");

    }

    private void findViewByIds() {
        loca1 = findViewById(R.id.img_loca_1);
        loca2 = findViewById(R.id.img_loca_2);
        loca3 = findViewById(R.id.img_loca_3);
        loca4 = findViewById(R.id.img_loca_4);
        img_ques = findViewById(R.id.img_ques);
        tv_ques = findViewById(R.id.tv_ques);
        gif_next = findViewById(R.id.next_gif_pa);
        gif_back = findViewById(R.id.back_gif_pa);
        img_home = findViewById(R.id.img_home_pa);
        img_lesson = findViewById(R.id.img_lesson_pa);
    }

    void update()
    {

        String question = "";
        Cursor dataQuestion = GhepTuHelper.GetData("SELECT * FROM GhepTu where Id = '"+(numberQues +1)+"'");
        while (dataQuestion.moveToNext())
        {
            question = dataQuestion.getString(1);
        }
        tv_ques.setText(question);

        img_ques.setImageResource(ot_img_question[numberQues]);

        numbers.clear();
        Random randomGenerator = new Random();
        numbers.add(numberQues);
        while (numbers.size() < 4) {

            int random = randomGenerator.nextInt(28);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        Collections.shuffle(numbers);

        loca1.setImageResource(ot_img_answer[numbers.get(0)]);
        loca2.setImageResource(ot_img_answer[numbers.get(1)]);
        loca3.setImageResource(ot_img_answer[numbers.get(2)]);
        loca4.setImageResource(ot_img_answer[numbers.get(3)]);

        for(int i = 0; i < 4; i++)
        {
            if(numbers.get(i) == numberQues)
                position = i;
        }
    }
}