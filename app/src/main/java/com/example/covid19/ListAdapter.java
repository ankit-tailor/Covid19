package com.example.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Covid> covidArrayList;

    public ListAdapter(Context context, ArrayList<Covid> covidArrayList) {

        this.context = context;
        this.covidArrayList = covidArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return covidArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return covidArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_list, null, true);

            holder.tvcountry = (TextView) convertView.findViewById(R.id.country);
            holder.tvNewConfirmed = (TextView) convertView.findViewById(R.id.newConfirmed);
            holder.tvTotalConfirmed = (TextView) convertView.findViewById(R.id.totalConfirmed);
            holder.tvNewDeaths = (TextView) convertView.findViewById(R.id.newDeaths);
            holder.tvTotalDeaths = (TextView) convertView.findViewById(R.id.totalDeaths);
            holder.tvNewRecovered = (TextView) convertView.findViewById(R.id.newRecovered);
            holder.tvTotalRecovered = (TextView) convertView.findViewById(R.id.totalRecovered);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvcountry.setText("Country: "+covidArrayList.get(position).getCountry());
        holder.tvNewConfirmed.setText("New Confirmed: "+covidArrayList.get(position).getNewConfirmed());
        holder.tvTotalConfirmed.setText("City: "+covidArrayList.get(position).getTotalConfirmed());
        holder.tvNewDeaths.setText("City: "+covidArrayList.get(position).getNewdDeaths());
        holder.tvTotalDeaths.setText("City: "+covidArrayList.get(position).getTotalDeaths());
        holder.tvNewRecovered.setText("City: "+covidArrayList.get(position).getNewRecovered());
        holder.tvTotalRecovered.setText("City: "+covidArrayList.get(position).getTotalRecovered());

        return convertView;
    }

    private class ViewHolder {

        protected TextView tvcountry, tvNewConfirmed, tvTotalConfirmed, tvNewDeaths, tvTotalDeaths, tvNewRecovered, tvTotalRecovered;
    }

}
