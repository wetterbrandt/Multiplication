package com.example.multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button game1;
    private Button game2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game1 = (Button) findViewById(R.id.modeOneButton);
        game2 = (Button) findViewById(R.id.modeTwoButton);

        game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        game2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }
        private void openActivity1(){
            Intent intent = new Intent(this, Game1Activity.class);
            startActivity(intent);
        }


        private void openActivity2(){
        Intent intent = new Intent(this, Game2Activity.class);
        startActivity(intent);
    }
}
