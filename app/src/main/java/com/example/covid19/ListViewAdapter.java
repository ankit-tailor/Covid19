package com.example.covid19;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.Response;

import org.json.JSONObject;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<Covid> {
    public ListViewAdapter(Activity context, ArrayList<Covid> covid) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, covid);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;

        if(listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list,
                    parent,
                    false
            );
        }

        Covid currentList = getItem(position);
        TextView country = (TextView) listView.findViewById(R.id.country);
        country.setText(currentList.getCountry());
        TextView newConfirmed = (TextView) listView.findViewById(R.id.newConfirmed);
        String s1 = "New Confiremed: " + (currentList.getNewConfirmed());
        newConfirmed.setText(s1);
        TextView totalConfirmed = (TextView) listView.findViewById(R.id.totalConfirmed);
        String s2 = "Total Confirmed: " + (currentList.getTotalConfirmed());
        totalConfirmed.setText(s2);
        TextView newDeaths = (TextView) listView.findViewById(R.id.newDeaths);
        String s3 = "New Deaths: " + (currentList.getNewdDeaths());
        newDeaths.setText(s3);
        TextView totalDeaths = (TextView) listView.findViewById(R.id.totalDeaths);
        String s4 = "Total Deaths: " + (currentList.getTotalDeaths());
        totalDeaths.setText(s4);
        TextView newRecovered = (TextView) listView.findViewById(R.id.newRecovered);
        String s5 = "New Recovered: " + (currentList.getNewRecovered());
        newRecovered.setText(s5);
        TextView totalRecovered = (TextView) listView.findViewById(R.id.totalRecovered);
        String s6 = "Total Recovered: " + (currentList.getTotalRecovered());
        totalRecovered.setText(s6);

        return listView;
    }
}
