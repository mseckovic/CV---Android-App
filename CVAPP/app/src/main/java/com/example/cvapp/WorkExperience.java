package com.example.cvapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class WorkExperience extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_experience);

        findViewById(R.id.imageHome).setOnClickListener(this);

        TextView firmaA = (TextView) findViewById(R.id.editFirma);
        TextView pozicijaA = (TextView) findViewById(R.id.editPozicija);
        TextView firmaB = (TextView) findViewById(R.id.editFirma2);
        TextView pozicijaB = (TextView) findViewById(R.id.editPozicija2);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("radnoIskustvo");
            JSONObject c = null;
            try {
                c = new JSONObject(j);
                String firmaAstr = c.getString("firmaA");
                String firmaBstr = c.getString("firmaB");
                String pozicijaAstr = c.getString("pozicijaA");
                String pozicijaBstr = c.getString("pozicijaB");

                firmaA.setText(firmaAstr);
                firmaB.setText(firmaBstr);
                pozicijaA.setText(pozicijaAstr);
                pozicijaB.setText(pozicijaBstr);
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
