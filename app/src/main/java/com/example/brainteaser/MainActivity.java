package com.example.brainteaser;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int correct_location;
    int score=0,total=0;
    int cnt=0;
    TextView scoret ;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sum;
    TextView timer;


    List<Integer> answers = new ArrayList<Integer>();
    TextView  ans ;
    Button play;

    public void playagain(View view)
    {
       score =0;
       cnt++;
       total =0;
       play.setText("Play Again");
       timer.setText("15s");
       scoret.setText(Integer.toString(score) + "/"+Integer.toString(total));
       q();
       play.setVisibility(View.INVISIBLE);
        new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText( String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                ans.setText("Done");
                play.setVisibility(View.VISIBLE);

            }
        }.start();



    }


    public void choose(View view)
    {

        if(Integer.toString(correct_location).equals(view.getTag().toString()))
        {
            ans.setText("Correct!");
            score++;

        }
        else{
            ans.setText("Incorrect");
        }
          total++;
          scoret.setText(Integer.toString(score) + "/"+Integer.toString(total));
          q();

    }

    public void q()
    {
        Random rand = new Random();
        int a= rand.nextInt(21);
        int b=rand.nextInt(21);

        sum.setText(Integer.toString(a) + " + " + Integer.toString(b));
        correct_location=rand.nextInt(4);
        answers.clear();

        for(int i=0;i<4;i++)
        {
            if(i==correct_location)
            {
                answers.add( a+b );
            }
            else
            {
                int wa = rand.nextInt(50);
                while( wa == a+b)
                {
                    wa = rand.nextInt(50);
                }
                answers.add(wa);

            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoret= findViewById(R.id.score);
         sum = findViewById(R.id.sum);
        ans = findViewById(R.id.correct);
        timer =findViewById(R.id.time);
        play=findViewById(R.id.play);
        timer.setText("15s");

         button0 =findViewById(R.id.ans);
         button1 =findViewById(R.id.ans1);
         button2 =findViewById(R.id.ans2);
         button3 =findViewById(R.id.ans3);

             play.setText("Play");

    }
}