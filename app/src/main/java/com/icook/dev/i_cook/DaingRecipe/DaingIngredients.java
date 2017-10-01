package com.icook.dev.i_cook.DaingRecipe;

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

public class DaingIngredients extends Fragment {
    private ListView curryListView;
    DaingAdapter adapter;
    List<ListDaingIngredients> listIngredient;

    public static final String[] ingredientsArray = new String[] {"3 pounds boneless, skinless chicken thigh meat","½ cup soy sauce",
            "juice of 2 lemons","1 head garlic, peeled and minced","2 tablespoons brown sugar",
            "½ teaspoon salt","¼ teaspoon pepper"};


    public DaingIngredients() {
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

        listIngredient = new ArrayList<ListDaingIngredients>();

        for(int i=0; i<ingredientsArray.length; i++){
            ListDaingIngredients listIng = new ListDaingIngredients(ingredientsArray[i]);
            listIngredient.add(listIng);
        }

        DaingAdapter adapter = new DaingAdapter(getActivity(),R.layout.list_curry_ingredients,listIngredient);
        curryListView.setAdapter(adapter);

        return view;
    }
}
