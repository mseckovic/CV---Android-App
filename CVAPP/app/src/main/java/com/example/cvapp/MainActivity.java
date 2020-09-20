package com.example.cvapp;

import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    HashMap<String, String> post = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imageOpstiPodaci).setOnClickListener(this);
        findViewById(R.id.imageObrazovanje).setOnClickListener(this);
        findViewById(R.id.imageRadnoIskustvo).setOnClickListener(this);
        findViewById(R.id.imageJezici).setOnClickListener(this);
        findViewById(R.id.imageTehnickoZnanje).setOnClickListener(this);
        findViewById(R.id.imageDrugeInformacije).setOnClickListener(this);
        findViewById(R.id.imageFotografije).setOnClickListener(this);

        new GetPosts().execute();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageOpstiPodaci){
            Intent i = new Intent(this, BasicInfo.class);
            i.putExtra("ime",post.get("ime"));
            i.putExtra("prezime",post.get("prezime"));
            i.putExtra("datumRodjenja",post.get("datumRodjenja"));
            i.putExtra("mestoRodjenja",post.get("mestoRodjenja"));
            i.putExtra("telefon",post.get("telefon"));
            i.putExtra("email",post.get("email"));
            i.putExtra("skype",post.get("skype"));
            startActivity(i);
        }

        else if (v.getId() == R.id.imageObrazovanje){
            Intent i = new Intent(this, Education.class);
            i.putExtra("osnovnaSkola",post.get("osnovnaSkola"));
            i.putExtra("srednjaSkola",post.get("srednjaSkola"));
            i.putExtra("fakultet",post.get("fakultet"));
            startActivity(i);
        }

        else if (v.getId() == R.id.imageRadnoIskustvo){
            Intent i = new Intent(this, WorkExperience.class);
            i.putExtra("radnoIskustvo",post.get("radnoIskustvo"));
            startActivity(i);

        }

        else if (v.getId() == R.id.imageJezici){
            Intent i = new Intent(this, Languages.class);
            i.putExtra("jezici",post.get("jezici"));
            startActivity(i);
        }

        else if (v.getId() == R.id.imageTehnickoZnanje){
            Intent i = new Intent(this, TechnicalKnowledge.class);
            i.putExtra("tehnickoZnanje",post.get("tehnickoZnanje"));
            startActivity(i);
        }

        else if (v.getId() == R.id.imageDrugeInformacije){
            Intent i = new Intent(this, OtherInfo.class);
            i.putExtra("brojNaucnihRadova",post.get("brojNaucnihRadova"));
            i.putExtra("brojSertifikata",post.get("brojSertifikata"));
            i.putExtra("brojNagrada",post.get("brojNagrada"));
            startActivity(i);
        }

        else if (v.getId() == R.id.imageFotografije){
            Intent i = new Intent(this, Photos.class);
            startActivity(i);
        }
    }

    private class GetPosts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "Json Data is downloading", Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "http://10.0.2.2:8080/students/findAll";
            String jsonStr = sh.makeServiceCall(url);

            if (jsonStr != null) {
                try {
                    JSONObject c = new JSONObject(jsonStr);
                        String ime = c.getString("ime");
                        String prezime = c.getString("prezime");
                        String datumRodjenja = c.getString("datumRodjenja");
                        String brojNagrada = c.getString("brojNagrada");
                        String brojSertifikata = c.getString("brojSertifikata");
                        String tehnickoZnanje = c.getString("tehnickoZnanje");
                        String skype = c.getString("skype");
                        String fakultet = c.getString("fakultet");
                        String mestoRodjenja = c.getString("mestoRodjenja");
                        String telefon = c.getString("telefon");
                        String osnovnaSkola = c.getString("osnovnaSkola");
                        String jezici = c.getString("jezici");
                        String srednjaSkola = c.getString("srednjaSkola");
                        String radnoIskustvo = c.getString("radnoIskustvo");
                        String brojNaucnihRadova = c.getString("brojNaucnihRadova");
                        String email = c.getString("email");


                        post.put("ime", ime);
                        post.put("prezime", prezime);
                        post.put("datumRodjenja", datumRodjenja);
                        post.put("mestoRodjenja", mestoRodjenja);
                        post.put("radnoIskustvo", radnoIskustvo);
                        post.put("jezici", jezici);
                        post.put("brojNagrada", brojNagrada);
                        post.put("brojSertifikata", brojSertifikata);
                        post.put("tehnickoZnanje", tehnickoZnanje);
                        post.put("skype", skype);
                        post.put("fakultet", fakultet);
                        post.put("telefon", telefon);
                        post.put("osnovnaSkola", osnovnaSkola);
                        post.put("srednjaSkola", srednjaSkola);
                        post.put("brojNaucnihRadova", brojNaucnihRadova);
                        post.put("email", email);


                } catch (final JSONException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            e.printStackTrace();
                        }
                    });

                }

            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
//            ListAdapter adapter = new SimpleAdapter(MainActivity.this, postList,
//                    R.layout.list_item, new String[]{ "title","body"},
//                    new int[]{R.id.title, R.id.body});
//            lv.setAdapter(adapter);
        }
    }
}
