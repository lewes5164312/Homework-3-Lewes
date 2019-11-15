package com.example.hwk3cats;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CatDetailActivity extends AppCompatActivity {
    private TextView nameTV;
    private TextView weightTV;
    private TextView temperamentTV;
    private TextView originTV;
    private TextView descriptionTV;
    private TextView urlTV;
    private TextView lifespanTV;
    private TextView dogTV;
    private ImageView imageIV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_detail);

        Intent intent = getIntent();

        String catID = intent.getStringExtra("CatID");

        nameTV = findViewById(R.id.cat_name_tv);
        weightTV = findViewById(R.id.cat_weight_tv);
        temperamentTV = findViewById(R.id.cat_temperament_tv);
        originTV = findViewById(R.id.cat_origin_tv);
        descriptionTV = findViewById(R.id.cat_description_tv);
        urlTV = findViewById(R.id.cat_wikipedia_url_tv);
        lifespanTV = findViewById(R.id.cat_life_span_tv);
        dogTV = findViewById(R.id.cat_dog_friendliness_tv);
        imageIV = findViewById(R.id.cat_image_iv);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
            String url = "https://api.thecatapi.com/v1/images/search?breed_ids="+ catID;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Type arrayListType = new TypeToken<ArrayList<CatDetail>>(){}.getType();
                ArrayList<CatDetail> data = gson.fromJson(response, arrayListType);
                    Cat cat = data.get(0).getBreeds();
                    nameTV.setText(cat.getName());
                    weightTV.setText(cat.getWeight().metric + " kg");
                    temperamentTV.setText(cat.getTemperament());
                    originTV.setText(cat.getOrigin());
                    descriptionTV.setText(cat.getDescription());
                    urlTV.setText(cat.getWikipedia_Url());
                    lifespanTV.setText(cat.getLife_span() + " years");
                    dogTV.setText(String.valueOf(cat.getDog_friendly()) + " / 5");
                    Glide.with(getBaseContext()).load(data.get(0).getUrl()).into(imageIV);

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        requestQueue.add(stringRequest);

    }
}
