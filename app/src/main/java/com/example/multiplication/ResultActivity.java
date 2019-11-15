package com.example.multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collections;


public class ResultActivity extends AppCompatActivity {
    ListView resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_result, Collections.singletonList(Game.getAnswerList()));
        resultList = (ListView) findViewById(R.id.resultList);
        resultList.setAdapter(adapter);

    }
}
