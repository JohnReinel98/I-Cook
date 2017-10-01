package com.icook.dev.i_cook.ChickenAdoboRecipe;

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

public class AdoboIngredients extends Fragment {
    private ListView adoboListView;
    FBeefTapaAdapter adapter;
    List<ListAdoboIngredients> listIngredient;

    public static final String[] ingredientsArray = new String[] {"1 tablespoon vegetable oil","1 onion, peeled and sliced thinly" +
            "5 cloves garlic, peeled and minced","3 pounds chicken wings, cut into cut into drummettes and wingettes","1 packet (1.4 ounces) tamarind powder"
                ,"1 cup water","1/4 cup soy sauce","salt and pepper to taste"};


    public AdoboIngredients() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adobo_ingredients, container, false);

        adoboListView = (ListView) view.findViewById(R.id.adoboListView);

        listIngredient = new ArrayList<ListAdoboIngredients>();

        for(int i=0; i<ingredientsArray.length; i++){
            ListAdoboIngredients listIng = new ListAdoboIngredients(ingredientsArray[i]);
            listIngredient.add(listIng);
        }

        AdoboAdapter adapter = new AdoboAdapter(getActivity(),R.layout.list_adobo_ingredients,listIngredient);
        adoboListView.setAdapter(adapter);

        return view;
    }
}
