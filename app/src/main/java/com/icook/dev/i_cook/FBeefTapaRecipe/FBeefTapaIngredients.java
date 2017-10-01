package com.icook.dev.i_cook.FBeefTapaRecipe;

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

public class FBeefTapaIngredients extends Fragment {
    private ListView curryListView;
    FBeefTapaAdapter adapter;
    List<ListFBeefTapaIngredients> listIngredient;

    public static final String[] ingredientsArray = new String[] {"¼ cup oil","2 medium potatoes, " +
            "peeled and quartered","2 large carrots, peeled and cubed","1 small onion, peeled and chopped"
                ,"2 to 3 cloves garlic, peeled and minced","1 (3 to 4 pounds) whole chicken, cut into serving parts"
                ,"1 tablespoon fish sauce","2 cups coconut milk","1 cup water","½ green bell pepper, seeded and cut into cubes",
                "½ red bell pepper, seeded and cut into cubes","2 tablespoons curry powder","salt to taste"};


    public FBeefTapaIngredients() {
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

        listIngredient = new ArrayList<ListFBeefTapaIngredients>();

        for(int i=0; i<ingredientsArray.length; i++){
            ListFBeefTapaIngredients listIng = new ListFBeefTapaIngredients(ingredientsArray[i]);
            listIngredient.add(listIng);
        }

        FBeefTapaAdapter adapter = new FBeefTapaAdapter(getActivity(),R.layout.list_curry_ingredients,listIngredient);
        curryListView.setAdapter(adapter);

        return view;
    }
}
