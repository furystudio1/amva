package com.agntic.waves.khadamat;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agntic.waves.Music.Music;
import com.agntic.waves.Music.MusicAdapter;
import com.agntic.waves.Music.MusicModels;
import com.agntic.waves.R;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bugsnag.android.Bugsnag;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Returant extends Activity {

    static ImageView imageView1,imageView2;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    SharedPreferences one_play_preferences;
    static String IPserver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.restaurant);


        one_play_preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
        IPserver = one_play_preferences.getString("IPweb", "109.125.130.155:2560");


        imageView1 = findViewById(R.id.backres);
        imageView2 = findViewById(R.id.imgres);

        recyclerView = (RecyclerView) findViewById(R.id.RecycleList_res_child);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(Returant.this, LinearLayoutManager.VERTICAL,
                        false));
        videolist();


    }




    RequestQueue requestQueue;
    public void videolist() {
        try {

            String url = "http://" + IPserver + "/Amvaj/service/res/json.php";
            //String url = "http://188.158.121.78/Amvaj/service/res/json.php";
            //String url = "http://amvaj.airfinance.org/VOD/muzic/json.php";

            // Instantiate the cache
            Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024 * 10); // 10MB cap

// Set up the network to use HttpURLConnection as the HTTP client.
            Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
            requestQueue = new RequestQueue(cache, network);
// Start the queue
            requestQueue.start();

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    try {
                        //VolleyLog.v("Response:%n %s", response.toString(4));

                        JSONArray students = response.getJSONArray("data");

                        List<RecModels> oneplusMobiles = new ArrayList<RecModels>();
                        oneplusMobiles.clear();
                        oneplusMobiles = new ArrayList<>();
                        //oneplusMobiles = null;
                        // looping through All Students
                        for (int i = 0; i < students.length(); i++) {
                            JSONObject c = students.getJSONObject(i);


                                    String name = null;
                                    String imgUrl = null;

                                    if (!c.isNull("img")) {
                                        imgUrl = c.getString("img");
                                    }

                                    if (!c.isNull("name")) {
                                            name = c.getString("name");
                                    }


                                    ///MusicManager.Music music = new MusicManager.Music(title, uri, artist, author, album, year, cover);

                                    oneplusMobiles.add(new RecModels(name, imgUrl));
                                }




                            //musicList.add(music);

                        adapter = new recAdapter(Returant.this,oneplusMobiles);
                        recyclerView.setAdapter(adapter);

                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        Bugsnag.notify(e);
                        e.printStackTrace();
                    }


                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Bugsnag.notify(error);
                            // Log.e("VOLLEY", "ERROR");
                        }
                    });

            requestQueue.add(jsonObjectRequest);

        } catch (Exception e) {
            Bugsnag.notify(e);
            e.printStackTrace();
        }
    }



    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

        Intent uou = new Intent(Returant.this, khadamat.class);
        startActivity(uou);
        Returant.this.finish();

        super.onBackPressed();

    }
}
