package com.icook.dev.i_cook.ChickenTocinoRecipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.icook.dev.i_cook.FBeefTapaRecipe.FBeefTapaAdapter;
import com.icook.dev.i_cook.FBeefTapaRecipe.ListFBeefTapaIngredients;
import com.icook.dev.i_cook.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win8.1 on 9/23/2017.
 */

public class ChickenTocinoIngredients extends Fragment {
    private ListView chicktocinoListView;
    FBeefTapaAdapter adapter;
    List<ListChickenTocinoIngredients> listIngredient;

    public static final String[] ingredientsArray = new String[] {"2 pounds chicken thigh meat, boneless and skinless","1 cup pineapple juice" +
            "¼ cup banana ketchup","1 tablespoon salt","1 tablespoon garlic powder"
                ,"½ cup sugar","water","2 tablespoons oil"};


    public ChickenTocinoIngredients() {
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

        listIngredient = new ArrayList<ListChickenTocinoIngredients>();

        for(int i=0; i<ingredientsArray.length; i++){
            ListChickenTocinoIngredients listIng = new ListChickenTocinoIngredients(ingredientsArray[i]);
            listIngredient.add(listIng);
        }

        ChickenTocinoAdapter adapter = new ChickenTocinoAdapter(getActivity(),R.layout.list_ctocino_ingredients,listIngredient);
        chicktocinoListView.setAdapter(adapter);

        return view;
    }
}
