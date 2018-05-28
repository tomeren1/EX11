package com.example.magshimim.ex11;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CountriesFragment extends ListFragment {
    CountryAdapter adapter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ListView lv = getListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),view.getTag().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                Toast.makeText(getContext(),"c in line"+ pos+" de", Toast.LENGTH_SHORT).show();

                adapter.removeItem(pos);
              //  adapter.notifyDataSetChanged();

               // lv.remove(pos);
              //  adpater.notifyDataSetChanged();

                return true;
            }
        });
    }

    public CountriesFragment()
    {
        super();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        adapter = new CountryAdapter(context);
        setListAdapter(adapter);
    }


}
