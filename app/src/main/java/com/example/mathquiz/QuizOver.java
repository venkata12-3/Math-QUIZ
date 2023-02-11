package com.example.mathquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class QuizOver extends Dialog {
    //String message;
    Mcqs_Practise mcqs_practise;
    Ques_Ans_Practise ques_ans_practise;

    public QuizOver(@NonNull Context context,Mcqs_Practise mcqs_practise) {
        super(context);
        //this.message = message;
        this.mcqs_practise=mcqs_practise;
    }
    AppCompatButton btn_playagain;
    AppCompatButton btn_exit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_over);

        btn_exit=findViewById(R.id.btn_exit);
        btn_playagain=findViewById(R.id.btn_playagain);


        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mcqs_practise.exit();
            dismiss();
            }
        });

        btn_playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mcqs_practise.playagain();
               dismiss();
            }
        });

    }
}