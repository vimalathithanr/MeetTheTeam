package com.example.vraja03.meettheteam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vraja03.meettheteam.parser.ContactJsonParsing;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContactJsonParsing dataParsing = new ContactJsonParsing();
        dataParsing.loadJSONFromAsset(this);
    }
}
