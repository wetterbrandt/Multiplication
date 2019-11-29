package com.example.multiplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;
    private final String[] resultArray;

    public CustomListAdapter(Activity context, String[] resultArrayParam){
        super(context, R.layout.resultview_row, resultArrayParam);

        this.context = context;
        this.resultArray = resultArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.resultview_row, null, true);

        TextView resultTextField = (TextView) rowView.findViewById(R.id.resultView);

        resultTextField.setText(resultArray[position]);

        return rowView;
    }

}
