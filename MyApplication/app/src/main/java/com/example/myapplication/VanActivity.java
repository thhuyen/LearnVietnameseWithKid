package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import pl.droidsonroids.gif.GifImageView;

public class VanActivity extends AppCompatActivity {

    CardView van_ia,van_ua,van_uwa, van_ao, van_eo, van_au, van_aau, van_eeu;
    CardView van_iu, van_uwu, van_ai, van_oi, van_ooi, vam_owi, van_ui, van_uwi;
    CardView van_ay, van_aay, van_ac, van_aac, van_uc, van_uwc,van_oc,van_ooc;
    CardView van_at, van_awt, van_aat, van_et, van_eet, van_it, van_ot, van_oot, van_owt;
    CardView van_ut, van_uwt, van_an, van_awn, van_aan, van_en, van_een, van_in, van_un, van_on, van_oon;
    GifImageView gif_next, gif_back;
    ImageView img_lesson, img_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van);

        gif_next = findViewById(R.id.next_gif_pa);
        gif_back = findViewById(R.id.back_gif_pa);
        img_home = findViewById(R.id.img_home_pa);
        img_lesson = findViewById(R.id.img_lesson_pa);

        gif_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VanActivity.this);
                builder.setMessage("Bé có muốn chuyển sang học ghép từ?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent gt = new Intent(getApplicationContext(), GhepTuActivity.class);
                        startActivity(gt);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(VanActivity.this);
                builder.setMessage("Bé có muốn chuyển sang học phụ âm?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent pa = new Intent(getApplicationContext(), PhuAmActivity.class);
                        startActivity(pa);
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
                Intent lesson = new Intent(getApplicationContext(),LessonActivity.class);
                startActivity(lesson);
            }
        });

        van_ia = findViewById(R.id.cardview_van_ia);
        van_ia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_ia);
                ring.start();
            }
        });

        van_ua = findViewById(R.id.cardview_van_ua);
        van_ua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_ua);
                ring.start();
            }
        });

        van_uwa = findViewById(R.id.cardview_van_uwa);
        van_uwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_uwa);
                ring.start();
            }
        });

        van_ao = findViewById(R.id.cardview_van_ao);
        van_ao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_ao);
                ring.start();
            }
        });

        van_eo = findViewById(R.id.cardview_van_eo);
        van_eo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_eo);
                ring.start();
            }
        });

        van_au = findViewById(R.id.cardview_van_au);
        van_au.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_au);
                ring.start();
            }
        });

        van_aau = findViewById(R.id.cardview_van_aau);
        van_aau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_aau);
                ring.start();
            }
        });

        van_eeu = findViewById(R.id.cardview_van_eeu);
        van_eeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_eeu);
                ring.start();
            }
        });

        van_iu = findViewById(R.id.cardview_van_iu);
        van_iu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_iu);
                ring.start();
            }
        });

        van_uwu = findViewById(R.id.cardview_van_uwu);
        van_uwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_uwu);
                ring.start();
            }
        });

        van_ai = findViewById(R.id.cardview_van_ai);
        van_ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_ai);
                ring.start();
            }
        });

        van_oi = findViewById(R.id.cardview_van_oi);
        van_oi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_oi);
                ring.start();
            }
        });

        van_ooi = findViewById(R.id.cardview_van_ooi);
        van_ooi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_ooi);
                ring.start();
            }
        });

        vam_owi = findViewById(R.id.cardview_van_owi);
        vam_owi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_owi);
                ring.start();
            }
        });

        van_ui = findViewById(R.id.cardview_van_ui);
        van_ui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_ui);
                ring.start();
            }
        });

        van_uwi = findViewById(R.id.cardview_van_uwi);
        van_uwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_uwi);
                ring.start();
            }
        });

        van_ay = findViewById(R.id.cardview_van_ay);
        van_ay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_ay);
                ring.start();
            }
        });

        van_aay = findViewById(R.id.cardview_van_aay);
        van_aay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_aay);
                ring.start();
            }
        });

        van_ac = findViewById(R.id.cardview_van_ac);
        van_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_ac);
                ring.start();
            }
        });

        van_aac = findViewById(R.id.cardview_van_aac);
        van_aac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_aac);
                ring.start();
            }
        });

        van_uc = findViewById(R.id.cardview_van_uc);
        van_uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_uc);
                ring.start();
            }
        });

        van_uwc = findViewById(R.id.cardview_van_uwc);
        van_uwc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_uwc);
                ring.start();
            }
        });

        van_oc = findViewById(R.id.cardview_van_oc);
        van_oc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_oc);
                ring.start();
            }
        });

        van_ooc = findViewById(R.id.cardview_van_ooc);
        van_ooc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_ooc);
                ring.start();
            }
        });

        van_at = findViewById(R.id.cardview_van_at);
        van_at.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_at);
                ring.start();
            }
        });

        van_awt = findViewById(R.id.cardview_van_awt);
        van_awt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_awt);
                ring.start();
            }
        });

        van_aat = findViewById(R.id.cardview_van_aat);
        van_aat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_aat);
                ring.start();
            }
        });

        van_et = findViewById(R.id.cardview_van_et);
        van_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_et);
                ring.start();
            }
        });

        van_eet = findViewById(R.id.cardview_van_eet);
        van_eet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_eet);
                ring.start();
            }
        });

        van_it = findViewById(R.id.cardview_van_it);
        van_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_it);
                ring.start();
            }
        });

        van_ot = findViewById(R.id.cardview_van_ot);
        van_ot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_ot);
                ring.start();
            }
        });

        van_oot = findViewById(R.id.cardview_van_oot);
        van_oot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_oot);
                ring.start();
            }
        });

        van_owt = findViewById(R.id.cardview_van_owt);
        van_owt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_owt);
                ring.start();
            }
        });

        van_ut = findViewById(R.id.cardview_van_ut);
        van_ut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_ut);
                ring.start();
            }
        });

        van_uwt = findViewById(R.id.cardview_van_uwt);
        van_uwt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_uwt);
                ring.start();
            }
        });

        van_an = findViewById(R.id.cardview_van_an);
        van_an.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_an);
                ring.start();
            }
        });

        van_awn = findViewById(R.id.cardview_van_awn);
        van_awn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_awn);
                ring.start();
            }
        });

        van_aan = findViewById(R.id.cardview_van_aan);
        van_aan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_aan);
                ring.start();
            }
        });

        van_en = findViewById(R.id.cardview_van_en);
        van_en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_en);
                ring.start();
            }
        });

        van_een = findViewById(R.id.cardview_van_een);
        van_een.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_een);
                ring.start();
            }
        });

        van_in = findViewById(R.id.cardview_van_in);
        van_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_in);
                ring.start();
            }
        });

        van_un = findViewById(R.id.cardview_van_un);
        van_un.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_un);
                ring.start();
            }
        });

        van_on = findViewById(R.id.cardview_van_on);
        van_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_on);
                ring.start();
            }
        });

        van_oon = findViewById(R.id.cardview_van_oon);
        van_oon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer ring= MediaPlayer.create(VanActivity.this,R.raw.audio_van_oon);
                ring.start();
            }
        });

    }
}