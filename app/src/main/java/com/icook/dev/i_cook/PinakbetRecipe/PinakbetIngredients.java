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

    public static final String[] ingredientsArray = new String[] {"1 tablespoon oil","1 small onion, peeled and chopped" +
            "2 cloves garlic, peeled and minced","2 tablespoons fish sauce","2 medium tomatoes, chopped"
                ,"1-1/2 cups water","½ small kabocha (calabasa) peeled and cut into pieces","6 to 8 okra, ends trimmed","½ bunch long beans, ends trimmed and cut into into 3-inch lengths",
    "1 bitter melon, seeded, halved and cut into 1-inch thick","1 large eggplant, ends trimmed and cut into 1-inch thick",
    "salt and pepper to taste","2 cups lechon kawali, cut into 1-inch pieces"};


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
