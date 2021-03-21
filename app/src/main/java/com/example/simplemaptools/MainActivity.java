package com.example.simplemaptools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText lInput;
    TextView lType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lInput = findViewById(R.id.etInput);
        lType = findViewById(R.id.tvType);
        lInput.addTextChangedListener(tw1);
    }

    private TextWatcher tw1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Pattern ptnDec = Pattern.compile("^[0-9]+[\\.][0-9]+[, ]+[0-9]+[\\.][0-9]+$");
            Pattern ptnNW = Pattern.compile("^([\\d]{2}.)[\\s]([\\d]{2}.)\\s([\\d]{2}.[ N]+)([\\d]{2}.)[\\s]([\\d]{2}.)\\s([\\d]{2}.[ W]+)$");
            Pattern ptnNWD = Pattern.compile("^([\\d]{2}[°])[\\s]([\\d]{2}[\\.][\\d]+[ N]+)([\\d]{2}[°])[\\s]([\\d]{2}[\\.][\\d]+[ W]+)$");
            String inStr = s.toString();
            //Matcher m = ptnDec.matcher(test);
            if (ptnDec.matcher(inStr).matches()) {
                lType.setText(getString(R.string.fmtDec));
            } else if (ptnNW.matcher(inStr).matches()) {
                lType.setText(R.string.fmtNw);
            } else if (ptnNWD.matcher(inStr).matches()) {
                lType.setText(R.string.fmtNwd);
            } else {
                lType.setText(R.string.fmtErr);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}