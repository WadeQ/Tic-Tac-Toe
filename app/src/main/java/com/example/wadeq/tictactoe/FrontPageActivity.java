package com.example.wadeq.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrontPageActivity extends AppCompatActivity {

    Button btnByThree;
    Button btnByFive;


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
    }
}
