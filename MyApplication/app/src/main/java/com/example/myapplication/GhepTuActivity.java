package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class GhepTuActivity extends AppCompatActivity {
    public List<String> suggestSource = new ArrayList<>();
    public GridViewAnswerAdapter answerAdapter;
    public GridViewSuggestAdapter suggestAdapter;
    public Button btnSubmit;
    public GridView gridViewAnswer,gridViewSuggest;
    public ImageView imgViewQuestion;
    GifImageView gif_next;
    ImageView img_lesson, img_home;

    int[] image_list={

            R.drawable.conca,
            R.drawable.conga,
            R.drawable.conmeo,
            R.drawable.conbo,
            R.drawable.sutu,
            R.drawable.conco,
            R.drawable.embe,
            R.drawable.sutu,
            R.drawable.caino,
            R.drawable.quacam,
            R.drawable.quabo,
            R.drawable.quale,
            R.drawable.conech,
            R.drawable.conong,
            R.drawable.conheo,
            R.drawable.ngoinha,
            R.drawable.butchi,
            R.drawable.ocsen,
            R.drawable.conmuc,
            R.drawable.conchim,
            R.drawable.hoahong,
            R.drawable.caighe,
            R.drawable.conkhi,
            R.drawable.conbuom,
            R.drawable.mattroi,
            R.drawable.giadinh,
            R.drawable.yta,
            R.drawable.conrua,
            R.drawable.caykem,
            R.drawable.condieu,

    };

    public char[] answer;

    String correct_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghep_tu);
        gif_next = findViewById(R.id.next_gif_tu);
        img_lesson = findViewById(R.id.img_lesson_tu);
        img_home = findViewById(R.id.img_home_tu);
        //Init View
        initView();



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
    }

    private void initView() {
        gridViewAnswer = (GridView)findViewById(R.id.gridViewAnswer);
        gridViewSuggest = (GridView)findViewById(R.id.gridViewSuggest);

        imgViewQuestion = (ImageView)findViewById(R.id.imgLogo);

        //Add SetupList Here
        setupList();

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result="";
                for(int i=0;i< Common.user_submit_answer.length;i++)
                    result+=String.valueOf(Common.user_submit_answer[i]);
                if(result.equals(correct_answer))
                {
                    Toast.makeText(getApplicationContext(),"Đúng rồi, chính là "+result,Toast.LENGTH_SHORT).show();
                    MediaPlayer ring= MediaPlayer.create(GhepTuActivity.this,R.raw.audio_dung);
                    ring.start();


                }
                else
                {
                    Toast.makeText(GhepTuActivity.this, "Sai rồi, bé thử lại nhé!", Toast.LENGTH_SHORT).show();
                    MediaPlayer ring= MediaPlayer.create(GhepTuActivity.this,R.raw.audio_sai);
                    ring.start();
                }
            }
        });
        gif_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Reset
                Common.count = 0;
                Common.user_submit_answer = new char[correct_answer.length()];

                //Set Adapter
                GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(setupNullList(),getApplicationContext());
                gridViewAnswer.setAdapter(answerAdapter);
                answerAdapter.notifyDataSetChanged();

                GridViewSuggestAdapter suggestAdapter = new GridViewSuggestAdapter(suggestSource,getApplicationContext(),GhepTuActivity.this);
                gridViewSuggest.setAdapter(suggestAdapter);
                suggestAdapter.notifyDataSetChanged();

                setupList();
            }
        });
    }

    private void setupList() {
        //Random logo
        Random random = new Random();
        int imageSelected = image_list[random.nextInt(image_list.length)];
        imgViewQuestion.setImageResource(imageSelected);

        correct_answer = getResources().getResourceName(imageSelected);
        correct_answer = correct_answer.substring(correct_answer.lastIndexOf("/")+1);

        answer = correct_answer.toCharArray();

        Common.user_submit_answer = new char[answer.length];

        //Add Answer character to List
        suggestSource.clear();
        for(char item:answer)
        {
            //Add logo name to list
            suggestSource.add(String.valueOf(item));
        }

        //Random add some character to list
        for(int i = answer.length;i<answer.length*2;i++)
            suggestSource.add(Common.alphabet_character[random.nextInt(Common.alphabet_character.length)]);

        //Sort random
        Collections.shuffle(suggestSource);

        //Set for GridView
        answerAdapter = new GridViewAnswerAdapter(setupNullList(),this);
        suggestAdapter = new GridViewSuggestAdapter(suggestSource,this,this);

        answerAdapter.notifyDataSetChanged();
        suggestAdapter.notifyDataSetChanged();

        gridViewSuggest.setAdapter(suggestAdapter);
        gridViewAnswer.setAdapter(answerAdapter);
    }

    private char[] setupNullList() {
        char result[] = new char[answer.length];
        for(int i=0;i<answer.length;i++)
            result[i]=' ';
        return result;
    }
}