package com.example.mathquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Game_Over extends AppCompatActivity {

    TextView final_score;
    AppCompatButton btn_palyagain;
    AppCompatButton btn_exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        final_score=findViewById(R.id.final_score);
        btn_exit=findViewById(R.id.btn_exit);
        btn_palyagain=findViewById(R.id.btn_playagain);

        Intent i=getIntent();
        int total_score=i.getIntExtra("score",0);
        String type=i.getStringExtra("type");
        final_score.setText(""+total_score);

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        btn_palyagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Game_Over.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}