package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Covid> covid;
    private ListView listView;
    private ListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        covid = new ArrayList<>();
        listView = (ListView) findViewById(R.id.list);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://api.covid19api.com/summary",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("Countries");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        String country = String.valueOf(obj.getString("Country"));
                        String newConfirmed = String.valueOf(obj.getInt("NewConfirmed"));
                        String totalConfirmed = String.valueOf(obj.getInt("TotalConfirmed"));
                        String totalDeath = String.valueOf(obj.getInt("TotalDeaths"));
                        String newDeath = String.valueOf(obj.getInt("NewDeaths"));
                        String newRecovered = String.valueOf(obj.getInt("NewRecovered"));
                        String totalRecovered = String.valueOf(obj.getInt("TotalRecovered"));
                        covid.add(new Covid(country, newConfirmed, totalConfirmed, newDeath, totalDeath, newRecovered, totalRecovered));
//                        Log.d("myapp", "COuntry: " + "\n"+ country + "Total Death: " + totalDeath + "\n" +
//                                "New confirmed: " + newConfirmed+"\n"+ "Total confirmed: " + totalConfirmed);
                        }
                    setUp();
//                    for (Covid c: covid) {
//                        Log.d("akki", c.getNewdDeaths());
//                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener()
        {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Unable to fetch data", Toast.LENGTH_SHORT).show();
            }
        });

//        for (Covid c: covid) {
//            Log.d("akkis", c.getCountry());
//        }
        requestQueue.add(jsonObjectRequest);
    }
    public void setUp() {
        adapter = new ListViewAdapter(this, covid);
        listView.setAdapter(adapter);
    }
}

