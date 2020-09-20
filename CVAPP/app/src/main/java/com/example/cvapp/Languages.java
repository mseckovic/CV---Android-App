package com.example.cvapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Languages extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        findViewById(R.id.imageHome).setOnClickListener(this);

        TextView engleski = (TextView) findViewById(R.id.editEngleski);
        TextView italijanski = (TextView) findViewById(R.id.editItalijanski);
        TextView nemacki = (TextView) findViewById(R.id.editNemacki);
        TextView ruski = (TextView) findViewById(R.id.editRuski);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("jezici");
            JSONObject c = null;
            try {
                c = new JSONObject(j);
                String engleskistr = c.getString("engleski");
                String italijanskistr = c.getString("italijanski");
                String nemackistr = c.getString("nemacki");
                String ruskistr = c.getString("ruski");

                engleski.setText(engleskistr);
                italijanski.setText(italijanskistr);
                nemacki.setText(nemackistr);
                ruski.setText(ruskistr);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    public void onClick(View v) {
        if (v.getId() == R.id.imageHome) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
