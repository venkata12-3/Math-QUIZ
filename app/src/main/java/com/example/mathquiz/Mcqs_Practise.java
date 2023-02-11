package com.example.mathquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Mcqs_Practise extends AppCompatActivity {

    MainActivity mainActivity;

    TextView score,liferem,timerem;
    TextView question;
    Button option1,option2,option3,submit;


    int op1,op2,op3;
    String user_ans="";

    Random random=new Random();

    int num1,num2,crt_res;

    int s=0,life=3;

    String type="";

    CountDownTimer timer;
    private static final long START_TIMER_IN_MILIS=60000;
    long timeLeftInMillis=START_TIMER_IN_MILIS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqs_practise);

        score=findViewById(R.id.score);
        liferem=findViewById(R.id.life_rem);
        timerem=findViewById(R.id.time_rem);
        question=findViewById(R.id.ques_tex);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        submit=findViewById(R.id.submit);

        Intent i=getIntent();
        type = i.getStringExtra("type");

        createquestion();
        submit.setEnabled(false);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option2.setEnabled(true);
                option3.setEnabled(true);
                option1.setEnabled(false);

                user_ans = (String) option1.getText();
                submit.setEnabled(true);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option1.setEnabled(true);
                option3.setEnabled(true);
                option2.setEnabled(false);

                user_ans=(String) option2.getText();
                submit.setEnabled(true);
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option1.setEnabled(true);
                option2.setEnabled(true);
                option3.setEnabled(false);
                user_ans=(String) option3.getText();
                submit.setEnabled(true);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseTimer();

                checkAnswer();

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something here
                        createquestion();
                    }
                }, 1000);


            }
        });


   }


    private void createquestion()
    {

        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        submit.setEnabled(false);
        if(type.equals("add_mcqs")){

            num1 = random.nextInt(100);
            num2 = random.nextInt(100);
            crt_res=num1+num2;
            question.setText(num1+" + "+num2+" = ?");
            op1=random.nextInt(201);
            op2=random.nextInt(201);
            op3=random.nextInt(201);
            setcrtAnswer();
            resetTimer();
            startTimer();

        }
        else if(type.equals("sub_mcqs")){
            num1 = random.nextInt(100);
            num2 = random.nextInt(100);
            crt_res=Math.max(num1,num2)-Math.min(num1,num2);
            question.setText(Math.max(num1,num2)+" - "+Math.min(num1,num2)+" = ?");
            op1=random.nextInt(101);
            op2=random.nextInt(101);
            op3=random.nextInt(101);
            setcrtAnswer();
            resetTimer();
            startTimer();

        }else if(type.equals("mul_mcqs")){
            num1 = random.nextInt(20);
            num2 = random.nextInt(20);
            crt_res=num1*num2;
            question.setText(num1+" * "+num2+" = ?");
            op1=random.nextInt(401);
            op2=random.nextInt(401);
            op3=random.nextInt(401);
            setcrtAnswer();
            resetTimer();
            startTimer();

        }else if(type.equals("practise_mcqs")){
            int type_num=random.nextInt(3)+1;
            if(type_num==1){
                num1 = random.nextInt(100);
                num2 = random.nextInt(100);
                crt_res=num1+num2;
                question.setText(num1+" + "+num2+" = ?");
                op1=random.nextInt(201);
                op2=random.nextInt(201);
                op3=random.nextInt(201);
                setcrtAnswer();
                resetTimer();
                startTimer();

            }else if(type_num==2){
                num1 = random.nextInt(100);
                num2 = random.nextInt(100);
                crt_res=Math.max(num1,num2)-Math.min(num1,num2);
                question.setText(Math.max(num1,num2)+" - "+Math.min(num1,num2)+" = ?");
                op1=random.nextInt(101);
                op2=random.nextInt(101);
                op3=random.nextInt(101);
                setcrtAnswer();
                resetTimer();
                startTimer();
            }else{
                num1 = random.nextInt(20);
                num2 = random.nextInt(20);
                crt_res=num1*num2;
                question.setText(num1+" * "+num2+" = ?");
                op1=random.nextInt(401);
                op2=random.nextInt(401);
                op3=random.nextInt(401);
                setcrtAnswer();
                resetTimer();
                startTimer();
            }

        }
    }

    private void setcrtAnswer()
    {
        int pos=random.nextInt(3)+1;
        if(pos==1)
        {
            option1.setText(""+crt_res);
            option2.setText(""+op1);
            option3.setText(""+op2);
        }
        else if(pos==2){
            option1.setText(""+op2);
            option2.setText(""+crt_res);
            option3.setText(""+op3);
        }else if(pos==3){
            option1.setText(""+op3);
            option2.setText(""+op1);
            option3.setText(""+crt_res);
        }
    }

    private void checkAnswer()
    {
        if(user_ans.equals(""+crt_res)){
            question.setText("Congradulations,right");
            s=s+10;
            score.setText(""+s);
        }else{
            question.setText("Wrong");
             life-=1;
           liferem.setText(""+life);
            CheckGameOver();

        }

    }

    private void CheckGameOver(){
        if(life==0){
            Toast.makeText(getApplicationContext(),"Game Over",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(Mcqs_Practise.this,Game_Over.class);
            intent.putExtra("score",s);
            intent.putExtra("type",type);
            startActivity(intent);
            finish();
            /*
              QuizOver quizOver=new QuizOver(Mcqs_Practise.this,Mcqs_Practise.this);
              quizOver.setCancelable(true);
              quizOver.show();
           */

        }
    }


    private void updateText()
    {
        int second=(int)(timeLeftInMillis/1000) % 60;
        timerem.setText(String.format("%02d",second));
    }

    private void pauseTimer()
    {
        timer.cancel();
    }

    private void resetTimer() {
        timeLeftInMillis=START_TIMER_IN_MILIS;
        updateText();
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
                life=life-1;
                liferem.setText(""+life);
                question.setText("Time is up");
                CheckGameOver();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something here
                        createquestion();
                    }
                }, 1000);
                //createquestion();
            }
        }.start();
    }

    public void playagain()
    {
        Intent intent=new Intent(Mcqs_Practise.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void exit()
    {
        mainActivity.exit2();
    }


}