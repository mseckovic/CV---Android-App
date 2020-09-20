package com.example.cvapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.LocalDateTime;

public class BasicInfo extends AppCompatActivity implements View.OnClickListener {


    String message;
    String subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_info);

        findViewById(R.id.imageHome).setOnClickListener(this);
        findViewById(R.id.imageDialler).setOnClickListener(this);
        findViewById(R.id.imageCompass).setOnClickListener(this);
        findViewById(R.id.imageMail).setOnClickListener(this);

        TextView ime = (TextView) findViewById(R.id.editIme);
        TextView prezime = (TextView) findViewById(R.id.editPrezime);
        TextView datumRodjenja = (TextView) findViewById(R.id.editDatumRodjenja);
        TextView mestoRodjenja = (TextView) findViewById(R.id.editMestoRodjenja);
        TextView telefon = (TextView) findViewById(R.id.editTelefon);
        TextView email = (TextView) findViewById(R.id.editEmail);
        TextView skype = (TextView) findViewById(R.id.editSkype);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String imestr =(String) b.get("ime");
            String prezimestr = (String) b.get("prezime");
            String datumRodjenjastr = (String) b.get("datumRodjenja");
            String mestoRodjenjastr = (String) b.get("mestoRodjenja");
            String telefonstr = (String) b.get("telefon");
            String skypestr = (String) b.get("skype");
            String emailstr = (String) b.get("email");


            ime.setText(imestr);
            prezime.setText(prezimestr);
            datumRodjenja.setText(datumRodjenjastr);
            mestoRodjenja.setText(mestoRodjenjastr);
            telefon.setText(telefonstr);
            skype.setText(skypestr);
            email.setText(emailstr);

        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.imageHome) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

        if (v.getId() == R.id.imageDialler) {
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:0123456789"));
            startActivity(i);
        }
        if (v.getId() == R.id.imageMail) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","email@email.com", null));
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        }

        if (v.getId() == R.id.imageCompass) {
            String uri = "http://maps.google.com/maps?saddr=" + "9982878"+","+"76285774"+"&daddr="+"9992084"+","+"76286455";
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            startActivity(intent);
        }
    }


}