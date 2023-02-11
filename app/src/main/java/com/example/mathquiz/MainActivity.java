package com.example.mathquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /*
    @Override
    public void  onBackPressed()
    {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("No",null)
                .show();
    }
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView add=findViewById(R.id.add);
        CardView sub=findViewById(R.id.sub);
        CardView mul=findViewById(R.id.mul);
        CardView rapidoo=findViewById(R.id.rapidoo);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select_quiz_type sel_quiz_type=new select_quiz_type(MainActivity.this,"Practise on Addition",MainActivity.this);
                sel_quiz_type.setCancelable(true);
                sel_quiz_type.show();

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                select_quiz_type sel_quiz_type=new select_quiz_type(MainActivity.this,"Practise on Subtraction",MainActivity.this);
                sel_quiz_type.setCancelable(true);
                sel_quiz_type.show();


            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                select_quiz_type sel_quiz_type=new select_quiz_type(MainActivity.this,"Practise on Multiplication",MainActivity.this);
                sel_quiz_type.setCancelable(true);
                sel_quiz_type.show();


            }
        });

        rapidoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select_quiz_type sel_quiz_type=new select_quiz_type(MainActivity.this,"PRACTISE",MainActivity.this);
                sel_quiz_type.setCancelable(true);
                sel_quiz_type.show();


            }
        });



    }

    public void add_mcqs()
    {
        Intent intent=new Intent(MainActivity.this,Mcqs_Practise.class);
        intent.putExtra("type","add_mcqs");
        startActivity(intent);
    }
    public void sub_mcqs()
    {
        Intent intent=new Intent(MainActivity.this,Mcqs_Practise.class);
        intent.putExtra("type","sub_mcqs");
        startActivity(intent);
    }
    public void mul_mcqs()
    {
        Intent intent=new Intent(MainActivity.this,Mcqs_Practise.class);
        intent.putExtra("type","mul_mcqs");
        startActivity(intent);
    }
    public void practise_mcqs()
    {
        Intent intent=new Intent(MainActivity.this,Mcqs_Practise.class);
        intent.putExtra("type","practise_mcqs");
        startActivity(intent);
    }

    public void exit2(){
        finish();
    }


    public void practise_que_ans() {
        Intent intent=new Intent(MainActivity.this,Ques_Ans_Practise.class);
        intent.putExtra("type","practise_que_ans");
        startActivity(intent);

    }

    public void mul_que_ans() {
        Intent intent=new Intent(MainActivity.this,Ques_Ans_Practise.class);
        intent.putExtra("type","mul_que_ans");
        startActivity(intent);
    }

    public void sub_ques_ans() {
        Intent intent=new Intent(MainActivity.this,Ques_Ans_Practise.class);
        intent.putExtra("type","sub_que_ans");
        startActivity(intent);
    }

    public void add_que_ans() {
        Intent intent=new Intent(MainActivity.this,Ques_Ans_Practise.class);
        intent.putExtra("type","add_que_ans");
        startActivity(intent);
    }
}