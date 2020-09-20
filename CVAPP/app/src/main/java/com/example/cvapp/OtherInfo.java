package com.example.cvapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OtherInfo extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_info);

        findViewById(R.id.imageHome).setOnClickListener(this);

        TextView brojSertifikata = (TextView) findViewById(R.id.editBrojSertifikata);
        TextView brojNagrada = (TextView) findViewById(R.id.editBrojNagrada);
        TextView brojNaucnihRadova = (TextView) findViewById(R.id.editBrojNaucnihRadova);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String brojSertifikatastr =(String) b.get("brojSertifikata");
            String brojNaucnihRadovastr = (String) b.get("brojNaucnihRadova");
            String brojNagradastr = (String) b.get("brojNagrada");

            brojNagrada.setText(brojNagradastr);
            brojSertifikata.setText(brojSertifikatastr);
            brojNaucnihRadova.setText(brojNaucnihRadovastr);

        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.imageHome) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
