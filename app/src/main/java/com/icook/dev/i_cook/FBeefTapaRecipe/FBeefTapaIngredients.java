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
    private ListView fbeeftapaListView;
    FBeefTapaAdapter adapter;
    List<ListFBeefTapaIngredients> listIngredient;

    public static final String[] ingredientsArray = new String[] {"½ cup soy sauce","¼ cup calamansi juice, " +
            "1 head garlic, minced","2 tablespoons sugar","½ teaspoon salt"
                ,"¼ teaspoon pepper","3 pounds sirloin, thinly sliced","oil"};


    public FBeefTapaIngredients() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fbeeftapa_ingredients, container, false);

        fbeeftapaListView = (ListView) view.findViewById(R.id.fbeeftapaListView);

        listIngredient = new ArrayList<ListFBeefTapaIngredients>();

        for(int i=0; i<ingredientsArray.length; i++){
            ListFBeefTapaIngredients listIng = new ListFBeefTapaIngredients(ingredientsArray[i]);
            listIngredient.add(listIng);
        }

        FBeefTapaAdapter adapter = new FBeefTapaAdapter(getActivity(),R.layout.list_fbeeftapa_ingredients,listIngredient);
        fbeeftapaListView.setAdapter(adapter);

        return view;
    }
}
