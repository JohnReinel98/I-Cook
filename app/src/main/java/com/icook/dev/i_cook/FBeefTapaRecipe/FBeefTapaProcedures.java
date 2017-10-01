package com.icook.dev.i_cook.FBeefTapaRecipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icook.dev.i_cook.R;

/**
 * Created by Win8.1 on 9/23/2017.
 */

public class FBeefTapaProcedures extends Fragment {
    public FBeefTapaProcedures() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fbeeftapa_procedures, container, false);


        return view;
    }
}
