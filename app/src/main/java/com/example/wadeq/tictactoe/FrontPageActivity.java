package com.example.wadeq.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrontPageActivity extends AppCompatActivity {

    Button btnByThree;
    Button btnByFive;

    Button singlePlayerThree;
    Button singlePlayerFive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        btnByThree = findViewById(R.id.btnByThree);
        btnByThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent threeByThreeBoard = new Intent(FrontPageActivity.this, ThreeBoardActivity.class);
                startActivity(threeByThreeBoard);
            }
        });
        btnByFive = findViewById(R.id.btnByFive);
        btnByFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fiveByFiveBoard = new Intent(FrontPageActivity.this, FiveBoardActivity.class);
                startActivity(fiveByFiveBoard);
            }
        });
        singlePlayerThree = findViewById(R.id.singlePlayerThree);
        singlePlayerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent threeByThreeBoard = new Intent(FrontPageActivity.this, SinglePlayerThreeBoardActivity.class);
                startActivity(threeByThreeBoard);
            }
        });
        singlePlayerFive = findViewById(R.id.singlePlayerFive);
        singlePlayerFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fiveByFiveBoard = new Intent(FrontPageActivity.this, SinglePlayerFiveBoardActivty.class);
                startActivity(fiveByFiveBoard);
            }
        });


    }
}
