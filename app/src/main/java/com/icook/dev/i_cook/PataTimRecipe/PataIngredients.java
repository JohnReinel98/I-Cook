package com.icook.dev.i_cook.PataTimRecipe;

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

public class PataIngredients extends Fragment {
    private ListView pataListView;
    FBeefTapaAdapter adapter;
    List<ListPataIngredients> listIngredient;

    public static final String[] ingredientsArray = new String[] {"3 pounds whole pork leg","3 tablespoons oil" +
            "1/2 cup Chinese cooking wine","1/4 cup vinegar","1 cup soy sauce"
                ,"1/2 cup sugar","3 pieces star anise","4 cups water","4 pieces shitake mushrooms","1 bundle bok choy, ends trimmed and leaves separated"};


    public PataIngredients() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pata_ingredients, container, false);

        pataListView = (ListView) view.findViewById(R.id.pataListView);

        listIngredient = new ArrayList<ListPataIngredients>();

        for(int i=0; i<ingredientsArray.length; i++){
            ListPataIngredients listIng = new ListPataIngredients(ingredientsArray[i]);
            listIngredient.add(listIng);
        }

        PataAdapter adapter = new PataAdapter(getActivity(),R.layout.list_pata_ingredients,listIngredient);
        pataListView.setAdapter(adapter);

        return view;
    }
}
