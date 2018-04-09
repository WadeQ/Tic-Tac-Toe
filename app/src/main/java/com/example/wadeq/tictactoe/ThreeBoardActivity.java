package com.example.wadeq.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThreeBoardActivity extends AppCompatActivity implements OnClickListener{

    Button[][] button = new Button[3][3];
    Button resetButton;

    int checkDraw;

    boolean firstMove = true;

    TextView displayOne, displayTwo ;

    int playerOneScore;
    int playerTwoScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_board);

        //Create references to our variables
        displayOne = findViewById(R.id.displayOne);
        displayTwo = findViewById(R.id.displayTwo);



        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                button[i][j] = findViewById(resID);
                button[i][j].setOnClickListener(this);
            }
        }
        //Reset board
        resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }

        });

    }


    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")){
            return;
        }
        if (firstMove){

            ((Button) view).setText("X");

        }else {

            ((Button) view).setText("O");
        }

        checkDraw++;

        if (checkWinner()){

            if (firstMove){

                winnerOneMessage();

            }else {

                winnerTwoMessage();
            }

        }else if (checkDraw == 9){

            draw();

        }else {

            firstMove = !firstMove ;
        }

    }

    private boolean checkWinner(){

        String[][] board = new String[3][3];
        for (int i=0 ; i<3 ; i++){
            for (int j=0 ; j<3 ; j++){
                board[i][j] = button[i][j].getText().toString();
            }
        }
        //check for the 3 winning positions on board rows and check for empty fields
        for (int i=0 ; i<3 ; i++) {

            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals("")) {
                return true;
            }
        }
        //Checking for the 3 winning positions on board columns and also for empty fields
        for (int i=0 ; i<3 ; i++){

            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals("")) {
                return true;
            }
        }
        //Checking for the two winning positions in our diagonals and also checking for empty fields.
        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals("")) {

            return true;
        }
        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals("")) {

            return true;
        }

        return false;
    }
    private void winnerOneMessage(){
        playerOneScore++;
        Toast winMessage = Toast.makeText(ThreeBoardActivity.this, "Player One Wins!", Toast.LENGTH_SHORT);
        winMessage.show();
        updateScore();
        resetBoard();
    }

    private void winnerTwoMessage(){
        playerTwoScore++;
        Toast winMessage = Toast.makeText(ThreeBoardActivity.this, "Player Two Wins!", Toast.LENGTH_SHORT);
        winMessage.show();
        updateScore();
        resetBoard();
    }

    private void draw(){

        Toast drawMessage = Toast.makeText(ThreeBoardActivity.this, "It's a Draw!", Toast.LENGTH_SHORT);
        drawMessage.show();
        resetBoard();
    }
    private void updateScore(){

        displayOne.setText(getString(R.string.scoreDisplay, + playerOneScore));
        displayTwo.setText(getString(R.string.scoreDisplay, + playerTwoScore));


    }
    private void resetBoard(){

        for (int i=0 ; i<3 ; i++){
            for (int j=0 ; j<3; j++){
                button[i][j].setText("");
            }
        }
        checkDraw = 0;
        firstMove = true;
    }
    private void resetGame(){

        playerOneScore = 0;
        playerTwoScore = 0;
        updateScore();
        resetBoard();
    }
}
