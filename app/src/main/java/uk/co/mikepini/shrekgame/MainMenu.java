package uk.co.mikepini.shrekgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);


        Button startBtn = (Button) findViewById(R.id.startBtn);
        Button levelBtn = (Button) findViewById(R.id.levelBtn);
        Button highscoreBtn = (Button) findViewById(R.id.highscoreBtn);
        Button exitBtn = (Button) findViewById(R.id.exitBtn);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent level1Intent = new Intent(getApplicationContext(),start.class);
                level1Intent.putExtra("uk.co.mikepini.shrekgame.level",1);
                startActivity(level1Intent);
            }
        });

        levelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent levelSelIntent = new Intent(getApplicationContext(),LevelSelect.class);
                startActivity(levelSelIntent);
            }
        });

       highscoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent highscoreIntent = new Intent(getApplicationContext(),Highscores.class);
                startActivity(highscoreIntent);
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }
}
