package com.bindesh.aryaveerdalchattisgarh.anime;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bindesh.aryaveerdalchattisgarh.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SecondActivity2 extends AppCompatActivity {

    private List<com.bindesh.aryaveerdalchattisgarh.anime.Anime> lstAnime ;
    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        lstAnime = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);

        jsonrequest();

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstAnime) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }



    //online use json file

    private void jsonrequest() {
        String JSON_URL = "https://aryaveerdal.in/anime.json";
        JsonArrayRequest request = new JsonArrayRequest(JSON_URL, response -> {
            JSONObject jsonObject;
            for (int i = 0; i < response.length(); i++) {
                try {
                    jsonObject = response.getJSONObject(i);
                    Anime anime = new Anime();
                    anime.setName(jsonObject.getString("name"));
                    anime.setDescription(jsonObject.getString("description"));
                    anime.setCategorie(jsonObject.getString("categorie"));
                    anime.setImage_url(jsonObject.getString("img"));
                    lstAnime.add(anime);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            setuprecyclerview(lstAnime);
        }, error -> {

        });

        RequestQueue requestQueue = Volley.newRequestQueue(SecondActivity2.this);
        requestQueue.add(request) ;


    }


    private void setuprecyclerview(List<com.bindesh.aryaveerdalchattisgarh.anime.Anime> lstAnime) {
        com.bindesh.aryaveerdalchattisgarh.anime.RecyclerViewAdapter myadapter = new com.bindesh.aryaveerdalchattisgarh.anime.RecyclerViewAdapter(this,lstAnime) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }


}

