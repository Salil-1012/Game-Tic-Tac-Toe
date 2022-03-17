package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    boolean emptySquare = false;
    int player_one_win = 0;
    int player_two_win = 0;


    // O - X means X diagram is represented zero in program
    // 1- O means O diagram is represent 1 in program

    int active_player = 0;   // first player is active i.e X when we tap 0 image is there
    int[] gameState = {2,2,2,2,2,2,2,2,2};
//     0 ---> X
//     1 ---> O
    // 2 ---> NULL
    int [] [] winPosition= {{0,1,2},{3,4,5},{6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}};
    public void playerTap(View view)
    {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
            reset(view);
        }
        if(gameState[tappedImage] == 2)
        {
            gameState[tappedImage]=active_player;
            if(active_player == 0)
            {
                img.setImageResource(R.drawable.x);
                active_player = 1;
                TextView status = findViewById(R.id.status);
                status.setText("Second Player Turn ");
            }
            else
            {
                img.setImageResource(R.drawable.zero);
                active_player = 0;
                TextView status = findViewById(R.id.status);
                status.setText("First Player Turn ");
            }
        }

        for (int[] winPosition : winPosition)
        {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2)
            {
                String winnerStr;
                gameActive = false;
                if (gameState[winPosition[0]] == 0)
                {
                    winnerStr = "1st Player Won";
                    player_one_win++;
                    TextView status = findViewById(R.id.player_one_id);
                    status.setText("Player 1-: "+player_one_win);
                }
                else
                {
                    winnerStr = "2nd Player Won";
                    player_two_win++;
                    TextView status = findViewById(R.id.player_two_id);
                    status.setText("Player 2-: "+player_two_win);
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void reset(View view)
    {
        gameActive = true;
        active_player =0 ;
        for(int i =0; i<gameState.length;i++)
        {
            gameState[i] =2;
        }
        ((ImageView)findViewById(R.id.image01)).setImageResource(0);
        ((ImageView)findViewById(R.id.image02)).setImageResource(0);
        ((ImageView)findViewById(R.id.image03)).setImageResource(0);
        ((ImageView)findViewById(R.id.image04)).setImageResource(0);
        ((ImageView)findViewById(R.id.image05)).setImageResource(0);
        ((ImageView)findViewById(R.id.image06)).setImageResource(0);
        ((ImageView)findViewById(R.id.image07)).setImageResource(0);
        ((ImageView)findViewById(R.id.image08)).setImageResource(0);
        ((ImageView)findViewById(R.id.image09)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("TAP TO PLAY");
    }


}