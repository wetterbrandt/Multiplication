package com.example.multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Activity for choosing practice mode.
 * <p>
 *  This activity lets you choose what mode you want to use the multiplication trainer in.
 *
 * @author Gustav & Markus
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mode1 = findViewById(R.id.modeOneButton);
        Button mode2 = findViewById(R.id.modeTwoButton);

        mode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        mode2.setOnClickListener(new View.OnClickListener() {
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
