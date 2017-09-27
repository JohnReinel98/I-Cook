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

public class TabDinner extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public static final String[] titleArray = new String[] {"Chicken Curry","Temp1","Temp2","Temp3"};
    public static final String[] descArray = new String[] {"Chicken Curry","TempDesc1", "TempDesc2","TempDesc3"};
    public static final Integer[] imageArray = {R.drawable.chicken_curry,R.drawable.chicken_curry,R.drawable.chicken_curry,R.drawable.chicken_curry};

    private List<ListBFast> listRecipes;

    public TabDinner() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_dinner, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.dinnerRecylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        listRecipes = new ArrayList<ListBFast>();


        for(int i=0; i<titleArray.length;i++){
            ListBFast listRecipe = new ListBFast(titleArray[i], imageArray[i]);
            listRecipes.add(listRecipe);
        }

        adapter = new BFastAdapter(listRecipes, getActivity());

        recyclerView.setAdapter(adapter);

        return view;
    }
}
