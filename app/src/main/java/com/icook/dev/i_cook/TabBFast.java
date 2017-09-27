package com.icook.dev.i_cook;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win8.1 on 9/23/2017.
 */

public class TabBFast extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public static final String[] titleArray = new String[] {"Chicken Tapa","Filipino Beef Tapa","Chicken Tocino","Daing na Bangus"};
    public static final Integer[] imageArray = {R.drawable.tapa_manok,R.drawable.beef_tapa,R.drawable.chicken_tocino,R.drawable.daing_bangus};

    private List<ListBFast> listBfasts;

    public TabBFast() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_bfast, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.bfastRecylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        listBfasts = new ArrayList<ListBFast>();


        for(int i=0; i<titleArray.length;i++){
            ListBFast listBfast = new ListBFast(titleArray[i], imageArray[i]);
            listBfasts.add(listBfast);
        }

        adapter = new BFastAdapter(listBfasts, getActivity());

        recyclerView.setAdapter(adapter);

        return view;
    }
}
