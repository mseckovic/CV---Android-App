package com.example.cvapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Education extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        findViewById(R.id.imageHome).setOnClickListener(this);

        TextView osnovnaSkola = (TextView) findViewById(R.id.editOsnovnaSkola);
        TextView srednjaSkola = (TextView) findViewById(R.id.editSrednjaSkola);
        TextView fakultet = (TextView) findViewById(R.id.editFakultet);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String osnovnaSkolastr =(String) b.get("osnovnaSkola");
            String srednjaSkolastr = (String) b.get("srednjaSkola");
            String fakultetstr = (String) b.get("fakultet");

            osnovnaSkola.setText(osnovnaSkolastr);
            srednjaSkola.setText(srednjaSkolastr);
            fakultet.setText(fakultetstr);

        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.imageHome) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
