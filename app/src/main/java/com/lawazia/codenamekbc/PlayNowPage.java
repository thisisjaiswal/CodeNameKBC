package com.lawazia.codenamekbc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lawazia.codenamekbc.components.Option;
import com.lawazia.codenamekbc.components.Settings;
import com.lawazia.codenamekbc.components.Status;

import java.util.Arrays;

public class PlayNowPage extends ActionBarActivity {

    PlayNowPage activity;
    TextView questionView;
    ListView optionsView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_now_layout);

        init();

        questionView.setText(getQuestion());
        optionsView.setAdapter(new ArrayAdapter<Option>(this, android.R.layout.simple_list_item_1, android.R.id.text1, getOptions()));
    }

    private void init()  {
        activity = this;
        questionView = (TextView) findViewById(R.id.questionView);
        optionsView = (ListView) findViewById(R.id.optionsView);
        optionsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Option selectedOption = (Option) optionsView.getItemAtPosition(position);
                ifConfirm(selectedOption,  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) { submitAnswer(selectedOption.Pos);}
                });
            }
        });
    }

    private String getQuestion() {
        return "Who is the host of the game show 'Kaun Banega Crorepati' ?";
    }

    private Option[] getOptions() {
        Option[] options = new Option[4];

        Option optionA = new Option();
        optionA.Pos = 'A';
        optionA.Text = "Amitabh Bachchan";
        options[0] = optionA;

        Option optionB = new Option();
        optionB.Pos = 'B';
        optionB.Text = "Shah Rukh Khan";
        options[1] = optionB;

        Option optionC = new Option();
        optionC.Pos = 'C';
        optionC.Text = "Hrithik Roshan";
        options[2] = optionC;

        Option optionD = new Option();
        optionD.Pos = 'D';
        optionD.Text = "Ranbir Kapoor";
        options[3] = optionD;

        return options;
    }

    private void ifConfirm(Option selectedOption, DialogInterface.OnClickListener callback) {
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle("Confirm ??");
        alert.setMessage(selectedOption.toString());
        alert.setPositiveButton("YES", callback);
        alert.setNegativeButton("NO", null);
        AlertDialog dialog_card = alert.create();
        dialog_card.show();
    }

    private void submitAnswer(char answer) {
        Toast.makeText(getApplicationContext(),"Submitting: " + answer ,Toast.LENGTH_SHORT).show();
        //Submit Ans

        startActivity(new Intent(getApplicationContext(), HomePage.class));
    }
}


