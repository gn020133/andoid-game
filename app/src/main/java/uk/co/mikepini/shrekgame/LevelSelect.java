package uk.co.mikepini.shrekgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LevelSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Button Level1Btn = (Button) findViewById(R.id.level1Btn);
        Button Level2Btn = (Button) findViewById(R.id.level2Btn);
        Button Level3Btn = (Button) findViewById(R.id.level3Btn);
        Button BackBtn = (Button) findViewById(R.id.backBtn);

        Level1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent level1Intent = new Intent(getApplicationContext(),start.class);
                level1Intent.putExtra("uk.co.mikepini.shrekgame.level",1);
                startActivity(level1Intent);
            }
        });
        Level2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent level2Intent = new Intent(getApplicationContext(),start.class);
                level2Intent.putExtra("uk.co.mikepini.shrekgame.level",2);
                startActivity(level2Intent);
            }
        });
        Level3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent level3Intent = new Intent(getApplicationContext(),start.class);
                level3Intent.putExtra("uk.co.mikepini.shrekgame.level",3);
                startActivity(level3Intent);
            }
        });
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getApplicationContext(),MainMenu.class);
                startActivity(backIntent);
            }
        });
    }

}
