package com.example.cvapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class TechnicalKnowledge extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical_knowledge);

        findViewById(R.id.imageHome).setOnClickListener(this);

        TextView word = (TextView) findViewById(R.id.editWord);
        TextView excel = (TextView) findViewById(R.id.editExcel);
        TextView powerpoint = (TextView) findViewById(R.id.editPowerPoint);
        TextView java = (TextView) findViewById(R.id.editJava);
        TextView python = (TextView) findViewById(R.id.editPython);
        TextView html = (TextView) findViewById(R.id.editHtml);


        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("tehnickoZnanje");
            JSONObject c = null;
            try {
                c = new JSONObject(j);
                String wordstr = c.getString("word");
                String excelstr = c.getString("excel");
                String powerpointstr = c.getString("powerpoint");
                String javastr = c.getString("java");
                String pythonstr = c.getString("python");
                String htmlstr = c.getString("html");

                word.setText(wordstr);
                excel.setText(excelstr);
                powerpoint.setText(powerpointstr);
                java.setText(javastr);
                python.setText(pythonstr);
                html.setText(htmlstr);

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
