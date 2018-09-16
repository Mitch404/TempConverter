package com.duggan.tempconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import java.text.NumberFormat;

public class TempConverterActivity extends AppCompatActivity
    implements OnEditorActionListener {
    private EditText input;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_converter);

        input = (EditText) findViewById(R.id.txtInput);
        result = (TextView) findViewById(R.id.txtResult);

        input.setOnEditorActionListener(this);
        calculateAndDisplay();
    }

    @Override
    public boolean onEditorAction(TextView v, int ActionId, KeyEvent event){
        calculateAndDisplay();
        return true;
    }

    public void calculateAndDisplay() {
        float tempF = 0;
        String tempFString = input.getText().toString();

        try {
            tempF = Float.parseFloat(tempFString);
        }
        catch(Exception e) {

        }

        float tempC = (tempF - 32f) / 1.8f;
        result.setText(Float.toString(tempC));
    }
}
