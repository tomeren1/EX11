package com.example.magshimim.ex11;

import android.content.Context;
import android.content.res.AssetManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country> {
    ArrayList<Country> allCountries;
   // CountryAdapterListener listener;

    public CountryAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_1);
        InputStream inputStream = openAssetDataStream(context);
        this.allCountries = XMLParser.parseFromStream(inputStream);
        for (Country country:allCountries)
        {
            add(country);
        }
        try{
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static InputStream openAssetDataStream(Context context){
        AssetManager assetManager = context.getAssets();
        InputStream in =null;
        try {
            in = assetManager.open("countries.xml");
        } catch (IOException e) {e.printStackTrace();}
        return in;
    }
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        if(listItem == null)

            listItem = LayoutInflater.from(getContext()).inflate(R.layout.row_item,parent,false);


        Country currCountry = getItem(position);//allCountries.get(position);

        int resId = parent.getResources().getIdentifier(currCountry.getFlag(), "drawable", getContext().getPackageName());


        ImageView image = (ImageView)listItem.findViewById(R.id.imageView);

        image.setImageResource(resId);


        TextView name = (TextView) listItem.findViewById(R.id.name);

        name.setText(currCountry.getName());


        TextView release = (TextView) listItem.findViewById(R.id.info);

        release.setText(currCountry.getShorty());

        listItem.setTag(currCountry.getDetails());


        return listItem;

    }
    public void removeItem(int pos)
    {
        remove(getItem(pos));
        allCountries.remove(pos);
    }


}
