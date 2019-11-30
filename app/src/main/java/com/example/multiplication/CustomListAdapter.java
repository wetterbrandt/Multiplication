package com.example.multiplication;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;
    private final String[] resultArray;
    private final String[] correctAnswers;
    private final String[] answers;

    public CustomListAdapter(Activity context, String[] resultArrayParam, String[] correctAnswers, String[] answers){
        super(context, R.layout.resultview_row, resultArrayParam);

        this.context = context;
        this.resultArray = resultArrayParam;
        this.correctAnswers = correctAnswers;
        this.answers = answers;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.resultview_row, null, true);

        TextView resultTextField = (TextView) rowView.findViewById(R.id.resultView);

        resultTextField.setText(resultArray[position]);

        if(position != 0){
            if(correctAnswers[position - 1].equals(answers[position - 1])){
                rowView.setBackgroundColor(Color.GREEN);
            }else{
                rowView.setBackgroundColor(Color.RED);
            }
        }

        return rowView;
    }

}
