package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class OTGhepCauActivity extends AppCompatActivity {

    // con ca
    private int presCounter = 0; // đếm cái ấn
    private int maxPresCounter = 4; // số ấn của đáp án
    private int numberQues = 1; // biến để gọi câu hỏi hiện tại
    private String[] suggestion;
    DBHelper examHelper;
    String textAnswer;
    TextView textQuestion;
    EditText et_ans;
    ImageView img_question, img_home, review_list;
    GifImageView next_ques;
    Button btn_check;
    // Animation smallbigforth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otghep_cau);
        mapping(); // ánh xạ
        et_ans.setEnabled(false); // ko cho gõ chữ
        //    smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);

        database();
        update();
        img_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(home);
            }
        });
        review_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                review_list.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent lesson = new Intent(getApplicationContext(),ReviewActivity.class);
                        startActivity(lesson);
                    }
                });
            }
        });
    }

    private void database() {
        examHelper = new DBHelper(OTGhepCauActivity.this, "exam.sqlite", null,1);//
        examHelper.QueryData("CREATE TABLE IF NOT EXISTS Exam (Id INTEGER PRIMARY KEY AUTOINCREMENT, question TEXT PRIMATY KEY, key TEXT)");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Con... đang nhảy', 'ếch')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Mọi người đang...', 'ngủ')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Con gà đẻ...', 'trứng')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Cây phượng màu...', 'đỏ')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Mẹ... bát', 'rửa')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Con... màu xanh', 'rắn')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Cậu bé đang... dạo', 'đi')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Chị... quần áo', 'may')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Bạn nam đang...', 'tắm')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Con... có cái vòi dài', 'voi')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Bạn gái đang...cây', 'tưới')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Con sư tử màu...', 'vàng')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Con... đang leo cây', 'khỉ')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Con... có cái cổ cao', 'hươu')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Bạn gái đang đánh...', 'răng')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Bà... quần áo', 'ủi')");
//        examHelper.QueryData("INSERT INTO Exam VALUES (null, 'Mẹ... quần áo', 'giặt')");
//          examHelper.QueryData("DROP TABLE Exam");
    }


    public void mapping()
    {
        textQuestion = findViewById(R.id.textQuestion);
        et_ans = findViewById(R.id.editText);
        next_ques = findViewById(R.id.next_gif_ot_gc);
        btn_check = findViewById(R.id.btn_check);
        img_question = findViewById(R.id.img_question);
        img_home = findViewById(R.id.img_home_ot_gc);
        review_list = findViewById(R.id.review_list);
    }
    // chen cau hoi va cau tra loi cho database

    private String[] shuffleArray(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        linearLayoutParams.rightMargin = 30;

        final TextView textView = new TextView(this);

        textView.setLayoutParams(linearLayoutParams);
        textView.setBackground(this.getResources().getDrawable(R.drawable.bgpink));
        textView.setTextColor(this.getResources().getColor(R.color.colorPurple));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(32);

        // Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

//        textScreen = (TextView) findViewById(R.id.textScreen);
//        textTitle = (TextView) findViewById(R.id.textTitle);
//
//        textQuestion.setTypeface(typeface);
//        textScreen.setTypeface(typeface);
//        textTitle.setTypeface(typeface);
//        editText.setTypeface(typeface);
//        textView.setTypeface(typeface);

        textView.setOnClickListener(new View.OnClickListener() {

            //    @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(presCounter < maxPresCounter) {
                    if (presCounter == 0)
                        et_ans.setText(""); // set ô đáp án là rỗng

                    et_ans.setText(et_ans.getText().toString() + text);
                    //    textView.startAnimation(smallbigforth);
                    //   textView.animate().alpha(0).setDuration(300);
                    presCounter++;

                    if (presCounter == maxPresCounter)
                        doValidate();
                }
            }
        });
        viewParent.addView(textView);
    }

    private void doValidate() {
        presCounter = 0;
        LinearLayout linearLayout = findViewById(R.id.layoutParent);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_ans.getText().toString().equals(textAnswer)) {
                    Toast.makeText(OTGhepCauActivity.this, "Bé giỏi quá!", Toast.LENGTH_SHORT).show();
                    MediaPlayer ring= MediaPlayer.create(OTGhepCauActivity.this,R.raw.audio_dung);
                    ring.start();
                } else {
                    Toast.makeText(OTGhepCauActivity.this, "Tiếc quá, bé thử lại nhé!", Toast.LENGTH_SHORT).show();
                    MediaPlayer ring= MediaPlayer.create(OTGhepCauActivity.this,R.raw.audio_sai);
                    ring.start();
                }
            }
        });
        next_ques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_ans.setText("");
                update();
                suggestion = shuffleArray(suggestion);
                linearLayout.removeAllViews();
                for (String suggestion : suggestion) {
                    addView(linearLayout, suggestion, et_ans);
                }
            }
        });
    }
    // hàm set câu hỏi theo thứ tự numberQues
    public void update(){
        if (numberQues <= 18) {
            Cursor examData = examHelper.GetData("SELECT * FROM Exam where id = '" + numberQues + "'");
            while (examData.moveToNext()) {
                String ques = examData.getString(1);
                String ans = examData.getString(2);
                textQuestion.setText(ques);
                textAnswer = ans;
                suggestion = new String[5];

                String alphabet = "aăâbcdđeêghiklmnôơpqrstuưxy";
                int i = 0;

                for(; i < textAnswer.length();i++) {
                    suggestion[i] = String.valueOf(textAnswer.charAt(i));
                }
                for (; i < 5; i++)
                {
                    Random rnd = new Random();
                    //Character randomChar = alphabet.charAt(rnd.nextInt(alphabet.length()));
                    suggestion[i] = String.valueOf(alphabet.charAt(rnd.nextInt(alphabet.length())));
                }

                setImg(numberQues);
            }
            suggestion = shuffleArray(suggestion);

            for (String suggestion : suggestion) {
                addView(((LinearLayout) findViewById(R.id.layoutParent)), suggestion, ((EditText) findViewById(R.id.editText)));
            }
            maxPresCounter = textAnswer.length();
            numberQues++;
            if (numberQues == 19)
            {
                next_ques.setVisibility(View.GONE);
                Dialog dialog = new Dialog(OTGhepCauActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_end);
                Button tieptuc = dialog.findViewById(R.id.btn_tieptuc);
                ImageView review_list = dialog.findViewById(R.id.review_list);

                dialog.setCancelable(false);
                dialog.show();

                review_list.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent rv_list = new Intent(getApplicationContext(),ReviewActivity.class);
                        startActivity(rv_list);
                    }
                });

                tieptuc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Dialog dialog = new Dialog(OTGhepCauActivity.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.dialog_tapdoc);

                        TextView tv;
                        tv= dialog.findViewById(R.id.tv_tapdoc_link);
                        tv.setMovementMethod(LinkMovementMethod.getInstance());

                        dialog.show();
                        Toast.makeText(OTGhepCauActivity.this, "Chuyển sang youtube thành công!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }
    }
    public void setImg(int number)
    {
        switch (number)
        {
            case 1:
                img_question.setImageResource(R.drawable.img_ech);
                break;
            case 2:
                img_question.setImageResource(R.drawable.img_ngu);
                break;
            case 3:
                img_question.setImageResource(R.drawable.img_ga);
                break;
            case 4:
                img_question.setImageResource(R.drawable.img_cayphuong);
                break;
            case 5:
                img_question.setImageResource(R.drawable.img_rua);
                break;
            case 6:
                img_question.setImageResource(R.drawable.img_ran);
                break;
            case 7:
                img_question.setImageResource(R.drawable.img_didao);
                break;
            case 8:
                img_question.setImageResource(R.drawable.img_may);
                break;
            case 9:
                img_question.setImageResource(R.drawable.img_tam);
                break;
            case 10:
                img_question.setImageResource(R.drawable.img_voi);
                break;
            case 11:
                img_question.setImageResource(R.drawable.img_tuoicay);
                break;
            case 12:
                img_question.setImageResource(R.drawable.img_sutu);
                break;
            case 13:
                img_question.setImageResource(R.drawable.img_khi);
                break;
            case 14:
                img_question.setImageResource(R.drawable.img_huou);
                break;
            case 15:
                img_question.setImageResource(R.drawable.img_danhrang);
                break;
            case 16:
                img_question.setImageResource(R.drawable.img_ui);
                break;
            case 17:
                img_question.setImageResource(R.drawable.img_giatdo);
                break;
        }
    }
}