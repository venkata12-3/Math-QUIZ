package com.example.mathquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Ques_Ans_Practise extends AppCompatActivity {
    MainActivity mainActivity1;

    TextView score1,liferem1,timerem1;
    TextView question1;

    EditText answer_text;
    Button submit1;

    Random random1=new Random();

    int number1,number2,crt_res1;

    int s1=0,life1=3;

    String type1="";
    int output;
    int target;


    CountDownTimer timer;
    private static final long START_TIMER_IN_MILIS=60000;
    long timeLeftInMillis=START_TIMER_IN_MILIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques_ans_practise);
        score1=findViewById(R.id.score1);
        liferem1=findViewById(R.id.life_rem1);
        timerem1=findViewById(R.id.time_rem1);
        question1=findViewById(R.id.question1);
        answer_text=findViewById(R.id.answer_text);
        submit1=findViewById(R.id.submit1);

        Intent i=getIntent();
        type1 = i.getStringExtra("type");

        createquestion();

            submit1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String res=answer_text.getText().toString();
                    if(res.isEmpty()){
                        Toast.makeText(Ques_Ans_Practise.this,"Please Type The Answer",Toast.LENGTH_SHORT).show();
                    }else{
                        pauseTimer();
                        output = Integer.parseInt(res);
                        checkAnswer();
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                answer_text.setText("");
                                createquestion();
                            }
                        }, 1000);
                        }

                }
            });
        }



    private void createquestion() {
        if (type1.equals("add_que_ans")) {//add_mcqs
            number1 = random1.nextInt(100);
            number2 = random1.nextInt(100);
            target = number1 + number2;
            question1.setText(number1 + " + " + number2 + " = ?");
            resetTimer();
            startTimer();

        } else if (type1.equals("sub_que_ans")) {
            number1 = random1.nextInt(100);
            number2 = random1.nextInt(100);
            target = Math.max(number1, number2) - Math.min(number1, number2);
            question1.setText(Math.max(number1, number2) + " - " + Math.min(number1, number2) + " = ?");
            resetTimer();
            startTimer();

        } else if (type1.equals("mul_que_ans")) {
            number1 = random1.nextInt(20);
            number2 = random1.nextInt(20);
            target = number1 * number2;
            question1.setText(number1 + " * " + number2 + " = ?");
            resetTimer();
            startTimer();

        } else if (type1.equals("practise_que_ans")) {
            int type_num = random1.nextInt(3) + 1;
            if (type_num == 1) {
                number1 = random1.nextInt(100);
                number2 = random1.nextInt(100);
                target = number1 + number2;
                question1.setText(number1 + " + " + number2 + " = ?");
                resetTimer();
                startTimer();

            } else if (type_num == 2) {
                number1 = random1.nextInt(100);
                number2 = random1.nextInt(100);
                target = Math.max(number1, number2) - Math.min(number1, number2);
                question1.setText(Math.max(number1, number2) + " - " + Math.min(number1, number2) + " = ?");
                resetTimer();
                startTimer();
            } else {
                number1 = random1.nextInt(20);
                number2 = random1.nextInt(20);
                target = number1 * number2;
                question1.setText(number1 + " * " + number2 + " = ?");
                resetTimer();
                startTimer();
            }

        }
    }
    private void checkAnswer()
    {
        if(target==output){
            question1.setText("Congradulations,right");
            s1=s1+10;
            score1.setText(""+s1);
        }else{
            question1.setText("Wrong");
            life1-=1;
            liferem1.setText(""+life1);
            CheckGameOver();
        }

    }


    private void startTimer(){

        timer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis=millisUntilFinished;
                updateText();
            }
            @Override
            public void onFinish() {
                pauseTimer();
                life1=life1-1;
                liferem1.setText(""+life1);
                question1.setText("Time is up");
                CheckGameOver();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        answer_text.setText("");
                        createquestion();
                    }
                }, 1000);



            }
        }.start();
    }

    private void updateText() {
        int second=(int)(timeLeftInMillis/1000) % 60;
        timerem1.setText(String.format("%02d",second));
    }
    private void pauseTimer() {
        timer.cancel();
    }
    private void resetTimer() {
        timeLeftInMillis=START_TIMER_IN_MILIS;
        updateText();
    }


    private void CheckGameOver() {
        if (life1 == 0) {
            Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_LONG).show();
            //clear()
            Intent i=new Intent(Ques_Ans_Practise.this,Game_Over.class);
            i.putExtra("score",s1);
            startActivity(i);
            finish();
            /*
            QuizOver quizOver=new QuizOver(Ques_Ans_Practise.this,.this);
            quizOver.setCancelable(true);
            quizOver.show();
             */
        }
    }
        public void clear(){
            score1.setText("0");
            liferem1.setText("0");
            timerem1.setText(" ");
        }


    }



