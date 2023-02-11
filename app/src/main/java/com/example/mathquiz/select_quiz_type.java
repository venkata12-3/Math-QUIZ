package com.example.mathquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class select_quiz_type extends Dialog{

    String message;
    MainActivity mainActivity;



    public select_quiz_type(@NonNull Context context, String message, MainActivity mainActivity) {

        super(context);
        this.message=message;
        this.mainActivity=mainActivity;
    }

    TextView quiz_type;
    AppCompatButton btn_mcqs;
    AppCompatButton btn_que_ans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_quiz_type);

        quiz_type=findViewById(R.id.quiz_type);
        btn_mcqs=findViewById(R.id.btn_mcqs);
        btn_que_ans=findViewById((R.id.btn_que_ans));

        quiz_type.setText(message);

        String str[]=message.split(" ");
        String type=str[str.length-1];




        btn_mcqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(type.equals("Addition"))
                {
                    mainActivity.add_mcqs();
                    dismiss();
                }
                else if(type.equals("Subtraction"))
                {
                    mainActivity.sub_mcqs();
                    dismiss();

                }
                else if(type.equals("Multiplication"))
                {
                    mainActivity.mul_mcqs();
                    dismiss();
                }
                else {
                    mainActivity.practise_mcqs();
                    dismiss();
                }

            }
        });

        btn_que_ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(type.equals("Addition"))
                {
                    mainActivity.add_que_ans();
                    dismiss();

                }
                else if(type.equals("Subtraction"))
                {
                    mainActivity.sub_ques_ans();
                    dismiss();

                }
                else if(type.equals("Multiplication"))
                {
                    mainActivity.mul_que_ans();
                    dismiss();

                }else{
                    mainActivity.practise_que_ans();
                    dismiss();

                }

            }
        });
    }
}