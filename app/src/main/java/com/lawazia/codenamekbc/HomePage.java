package com.lawazia.codenamekbc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.lawazia.codenamekbc.components.Settings;
import com.lawazia.codenamekbc.components.Status;

import java.util.Date;

public class HomePage extends ActionBarActivity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        Date today  = new Date();

        Button btn_play_now = (Button) findViewById(R.id.btn_play);
        btn_play_now.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PlayNowPage.class));
            }
        });
    }
}