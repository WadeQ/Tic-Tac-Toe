package com.example.wadeq.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FiveBoardActivity extends AppCompatActivity implements View.OnClickListener{

    private Button[][] button = new Button[5][5];

    Button resetButton;

    private int checkDraw;

    private boolean firstMove = true;

    private TextView displayOne, displayTwo ;

    private int playerOneScore;
    private int playerTwoScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_board);

        //Create references to our variables
        displayOne = findViewById(R.id.displayOne);
        displayTwo = findViewById(R.id.displayTwo);



        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                button[i][j] = findViewById(resID);
                button[i][j].setOnClickListener(this);
            }
        }
        //Reset board
        resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
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

        }else if (checkDraw == 25){

            draw();

        }else {

            firstMove = !firstMove ;
        }

    }

    private boolean checkWinner(){

        String[][] board = new String[5][5];
        for (int i=0 ; i<5 ; i++){
            for (int j=0 ; j<5 ; j++){
                board[i][j] = button[i][j].getText().toString();
            }
        }
        //check for the 12 winning positions on board rows and check for empty fields
        for (int i=0 ; i<5 ; i++) {

            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][3]) && board[i][0].equals(board[i][2]) && !board[i][0].equals("")) {
                return true;
            }
        }
        //Checking for the winning positions from the second field of our array in the rows
        for (int i=0 ; i<5 ; i++){

            if (board[i][1].equals(board[i][2]) && board[i][1].equals(board[i][3]) && board[i][1].equals(board[i][4]) && !board[i][1].equals("")){
                return true;
            }
        }
        for (int i=0 ; i<5 ; i++){

            if (board[1][i].equals(board[2][i]) && board[1][i].equals(board[3][i]) && board[1][i].equals(board[4][i]) && !board[1][i].equals("")){
                return true;
            }
        }
        //Checking for the 12 winning positions on board columns and also for empty fields
        for (int i=0 ; i<5 ; i++){
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && board[0][i].equals(board[3][i]) && !board[0][i].equals("")) {
                return true;
            }

        }
        //Checking for the six winning positions in our diagonals and also checking for empty fields.
        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && board[0][0].equals(board[3][3]) && !board[0][0].equals("")) {

            return true;
        }
        if (board[0][1].equals(board[1][2]) && board[0][1].equals(board[2][3]) && board[0][1].equals(board[3][4]) && !board[0][1].equals("")) {

            return true;
        }
        if (board[1][0].equals(board[2][1]) && board[1][0].equals(board[3][2]) && board[1][0].equals(board[4][3]) && !board[1][0].equals("")){
            return true;
        }
        if (board[0][4].equals(board[1][3]) && board[0][4].equals(board[2][2]) && board[0][4].equals(board[3][1]) && !board[0][4].equals("")) {

            return true;
        }
        if (board[0][3].equals(board[1][2]) && board[0][3].equals(board[2][1]) && board[0][3].equals(board[3][0]) && !board[0][3].equals("")) {
            return true;
        }
        if (board[1][4].equals(board[2][3]) && board[1][4].equals(board[3][2]) && board[1][4].equals(board[4][1]) && !board[1][4].equals("")){
            return true;
        }
        if (board[1][1].equals(board[2][2]) && board[1][1].equals(board[3][3]) && board[1][1].equals(board[4][4]) && !board[1][1].equals("")) {
            return true;
        }
        if (board[1][3].equals(board[2][2]) && board[1][3].equals(board[3][1]) && board[1][3].equals(board[4][0]) && !board[1][3].equals("")) {
            return true;
        }

        return false;

    }
    private void winnerOneMessage(){
        playerOneScore++;
        Toast winMessage = Toast.makeText(FiveBoardActivity.this, "Player One Wins!", Toast.LENGTH_SHORT);
        winMessage.show();
        updateScore();
        resetBoard();
    }

    private void winnerTwoMessage(){
        playerTwoScore++;
        Toast winMessage = Toast.makeText(FiveBoardActivity.this, "Player Two Wins!", Toast.LENGTH_SHORT);
        winMessage.show();
        updateScore();
        resetBoard();
    }

    private void draw(){

        Toast drawMessage = Toast.makeText(FiveBoardActivity.this, "It's a Draw!", Toast.LENGTH_SHORT);
        drawMessage.show();
        resetBoard();
    }
    private void updateScore(){

        displayOne.setText(getString(R.string.scoreDisplay, + playerOneScore));
        displayTwo.setText(   getString(R.string.scoreDisplay, + playerTwoScore));

    }
    private void resetBoard(){

        for (int i=0 ; i<5 ; i++){
            for (int j=0 ; j<5; j++){
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
