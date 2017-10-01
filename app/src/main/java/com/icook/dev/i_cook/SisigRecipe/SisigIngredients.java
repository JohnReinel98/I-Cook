package com.icook.dev.i_cook.SisigRecipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.icook.dev.i_cook.FBeefTapaRecipe.FBeefTapaAdapter;
import com.icook.dev.i_cook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win8.1 on 9/23/2017.
 */

public class SisigIngredients extends Fragment {
    private ListView chicktocinoListView;
    FBeefTapaAdapter adapter;
    List<ListSisigIngredients> listIngredient;

    public static final String[] ingredientsArray = new String[] {"4 cups lechon kawali, chopped","1 red bell pepper, seeded, cored and diced" +
            "1 medium onion, peeled and diced","5 Thai chili peppers, minced","1/2 cup calamansi juice"
                ,"salt and pepper to taste"};


    public SisigIngredients() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ctocino_ingredients, container, false);

        chicktocinoListView = (ListView) view.findViewById(R.id.ctocinoListView);

        listIngredient = new ArrayList<ListSisigIngredients>();

        for(int i=0; i<ingredientsArray.length; i++){
            ListSisigIngredients listIng = new ListSisigIngredients(ingredientsArray[i]);
            listIngredient.add(listIng);
        }

        SisigAdapter adapter = new SisigAdapter(getActivity(),R.layout.list_ctocino_ingredients,listIngredient);
        chicktocinoListView.setAdapter(adapter);

        return view;
    }
}
