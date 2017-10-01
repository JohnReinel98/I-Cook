package com.icook.dev.i_cook.PaksiwRecipe;

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

public class PaksiwIngredients extends Fragment {
    private ListView pinakbetListView;
    FBeefTapaAdapter adapter;
    List<ListPaksiwIngredients> listIngredient;

    public static final String[] ingredientsArray = new String[] {"1 tablespoon oil","1 large onion, peeled and sliced thinly" +
            "1 head garlic, peeled and minced","¾ cup vinegar","2 cups water"
                ,"2 cups (homemade or store-bought) lechon sauce","¾ cup brown sugar","2 to 3 pounds (about 4 cups) leftover lechon or lechon kawali, chopped into 1-inch pieces",
    "3 bay leaves","½ cup liver spread","salt and pepper to taste"};


    public PaksiwIngredients() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pinakbet_ingredients, container, false);

        pinakbetListView = (ListView) view.findViewById(R.id.pinakbetListView);

        listIngredient = new ArrayList<ListPaksiwIngredients>();

        for(int i=0; i<ingredientsArray.length; i++){
            ListPaksiwIngredients listIng = new ListPaksiwIngredients(ingredientsArray[i]);
            listIngredient.add(listIng);
        }

        PaksiwAdapter adapter = new PaksiwAdapter(getActivity(),R.layout.list_pinakbet_ingredients,listIngredient);
        pinakbetListView.setAdapter(adapter);

        return view;
    }
}
