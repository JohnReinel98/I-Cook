package com.icook.dev.i_cook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JohnReinel on 9/23/2017.
 */

public class Profile extends Fragment {
    SQLiteDataBaseAdapter sq;
    TextView txtusername,txtemail,txtcontact;
    public Profile(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        sq = new SQLiteDataBaseAdapter(getActivity());

        txtusername = (TextView) view.findViewById(R.id.pusername);
        txtemail = (TextView) view.findViewById(R.id.pcontact);
        txtcontact = (TextView) view.findViewById(R.id.pemail);

        String id = "1";
        String [] data = sq.helper.searchData(id);
        txtusername.setText(data[1]);
        txtemail.setText(data[3]);
        txtcontact.setText(data[4]);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Profile");
    }
}
