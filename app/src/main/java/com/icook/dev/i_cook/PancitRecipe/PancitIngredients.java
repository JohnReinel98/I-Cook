package com.icook.dev.i_cook.PancitRecipe;

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

public class PancitIngredients extends Fragment {
    private ListView pancitListView;
    FBeefTapaAdapter adapter;
    List<ListPancitIngredients> listIngredient;

    public static final String[] ingredientsArray = new String[] {"4 cups chicken stock","1/4 cup soy sauce" +
            "8 ounces rice noodles","1/2 pound boneless, skinless chicken breast or thigh meat, diced","1/2 pound large shrimp, peeled and deveined"
                ,"2 tablespoons cornstarch","1 onion, peeled and sliced thinly","2 cloves garlic, peeled and minced","16 ounces pork hamonado, cut thinly on a bias",
            "2 large carrots, peeled and sliced thinly on a bias","2 stalks celery, sliced thinly on a bias","1 small cabbage, chopped","salt and pepper to taste"};


    public PancitIngredients() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pancit_ingredients, container, false);

        pancitListView = (ListView) view.findViewById(R.id.pancitListView);

        listIngredient = new ArrayList<ListPancitIngredients>();

        for(int i=0; i<ingredientsArray.length; i++){
            ListPancitIngredients listIng = new ListPancitIngredients(ingredientsArray[i]);
            listIngredient.add(listIng);
        }

        PancitAdapter adapter = new PancitAdapter(getActivity(),R.layout.list_pancit_ingredients,listIngredient);
        pancitListView.setAdapter(adapter);

        return view;
    }
}
