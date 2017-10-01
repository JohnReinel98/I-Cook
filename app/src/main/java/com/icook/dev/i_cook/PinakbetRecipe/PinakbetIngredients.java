package com.icook.dev.i_cook.PinakbetRecipe;

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

public class PinakbetIngredients extends Fragment {
    private ListView pinakbetListView;
    FBeefTapaAdapter adapter;
    List<ListPinakbetIngredients> listIngredient;

    public static final String[] ingredientsArray = new String[] {"4 cups lechon kawali, chopped","1 red bell pepper, seeded, cored and diced" +
            "1 medium onion, peeled and diced","5 Thai chili peppers, minced","1/2 cup calamansi juice"
                ,"salt and pepper to taste"};


    public PinakbetIngredients() {
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

        listIngredient = new ArrayList<ListPinakbetIngredients>();

        for(int i=0; i<ingredientsArray.length; i++){
            ListPinakbetIngredients listIng = new ListPinakbetIngredients(ingredientsArray[i]);
            listIngredient.add(listIng);
        }

        PinakbetAdapter adapter = new PinakbetAdapter(getActivity(),R.layout.list_pinakbet_ingredients,listIngredient);
        pinakbetListView.setAdapter(adapter);

        return view;
    }
}
