package com.icook.dev.i_cook.ChickTapaRecipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.icook.dev.i_cook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win8.1 on 9/23/2017.
 */

public class ChickTapaIngredients extends Fragment {
    private ListView curryListView;
    ChickTapaAdapter adapter;
    List<ListChickTapaIngredients> listIngredient;

    public static final String[] ingredientsArray = new String[] {"3 pounds boneless, skinless chicken thigh meat","½ cup soy sauce",
            "juice of 2 lemons","1 head garlic, peeled and minced","2 tablespoons brown sugar",
            "½ teaspoon salt","¼ teaspoon pepper"};


    public ChickTapaIngredients() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.curry_ingredients, container, false);

        curryListView = (ListView) view.findViewById(R.id.curryListView);

        listIngredient = new ArrayList<ListChickTapaIngredients>();

        for(int i=0; i<ingredientsArray.length; i++){
            ListChickTapaIngredients listIng = new ListChickTapaIngredients(ingredientsArray[i]);
            listIngredient.add(listIng);
        }

        ChickTapaAdapter adapter = new ChickTapaAdapter(getActivity(),R.layout.list_curry_ingredients,listIngredient);
        curryListView.setAdapter(adapter);

        return view;
    }
}
