package uk.co.mikepini.shrekgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Highscores extends AppCompatActivity {
    protected int highscore1;
    protected int highscore2;
    protected int highscore3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscores);

        Button updateHSBtn = (Button) findViewById(R.id.updateHSBtn);
        updateHSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView level1 = (TextView) findViewById(R.id.enteredScore1);
                TextView level2 = (TextView) findViewById(R.id.enteredScore2);
                TextView level3 = (TextView) findViewById(R.id.enteredScore3);

               // highscore1=Integer.parseInt((String)level1.getText());
               // highscore2=Integer.parseInt((String)level2.getText());
               // highscore3=Integer.parseInt((String)level3.getText());
               try {
                   CharSequence val1 = level1.getText();
                   highscore1 = Integer.parseInt(val1.toString());
               }catch(NumberFormatException ex){
                   return;
               }
                try {
                    CharSequence val2 = level2.getText();
                    highscore2 = Integer.parseInt(val2.toString());
                }catch(NumberFormatException ex){
                    return;
                }
                try {
                    CharSequence val3 = level3.getText();
                    highscore3 = Integer.parseInt(val3.toString());
                }catch(NumberFormatException ex){
                    return;
                }



                if (highscore1>0) {

                    level1.setText(highscore1 + "");
                }else level1.setText("");
                if (highscore2>0) {

                    level2.setText(highscore2 + "");
                }else level2.setText("");
                if (highscore3>0) {

                    level3.setText(highscore3 + "");
                }else level3.setText("");
            }
        });
if (highscore1>0) {
    TextView level1 = (TextView) findViewById(R.id.enteredScore1);
    level1.setText(highscore1 + "");
}
if (highscore2>0) {
    TextView level2 = (TextView) findViewById(R.id.enteredScore2);
    level2.setText(highscore2 + "");
}
if (highscore3>0) {
    TextView level3 = (TextView) findViewById(R.id.enteredScore3);
    level3.setText(highscore3 + "");
}

    }



    public void updateScore1(float score){
        if (score<highscore1)
            highscore1=(int)score;
    }
    public void updateScore2(float score){
        if (score<highscore2)
            highscore2=(int)score;
    }
    public void updateScore3(float score){
        if (score<highscore3)
            highscore3=(int)score;
    }
}
