package com.github.yangkangli.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.github.yangkangli.x.log.XLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View view) {
        XLog.d("AAAAAAAAAAAAAAAAAAAAAAAA");
        try {
            int i = 0;

            int b = 100 / i;
        } catch (Exception ex) {
            XLog.e(ex);
        }

        XLog.v("CCCCC");
    }
}
