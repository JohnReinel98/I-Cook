package com.icook.dev.i_cook;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.icook.dev.i_cook.ChickTapaRecipe.ChickTapaFragment;
import com.icook.dev.i_cook.ChickenTocinoRecipe.ChickenTocinoFragment;
import com.icook.dev.i_cook.CurryRecipe.CurryAdapter;
import com.icook.dev.i_cook.CurryRecipe.CurryFragment;
import com.icook.dev.i_cook.DaingRecipe.DaingFragment;
import com.icook.dev.i_cook.FBeefTapaRecipe.FBeefTapaFragment;
import com.icook.dev.i_cook.PaksiwRecipe.PaksiwFragment;
import com.icook.dev.i_cook.PinakbetRecipe.PinakbetFragment;
import com.icook.dev.i_cook.SisigRecipe.SisigAdapter;
import com.icook.dev.i_cook.SisigRecipe.SisigFragment;

import java.util.List;

/**
 * Created by Win8.1 on 9/23/2017.
 */

public class LunchAdapter extends RecyclerView.Adapter<LunchAdapter.ViewHolder>{
    private List<ListLunch> listLunch;
    private Context context;
    CardView lunchCardView;

    public LunchAdapter(List<ListLunch> listLunch, Context context) {
        this.listLunch = listLunch;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_lunch, parent, false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ListLunch listlunch = listLunch.get(position);


        holder.lPic.setImageResource(listlunch.getPic());
        holder.lTitle.setText(listlunch.getTitle());

        holder.llinearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Title",listLunch.get(position).getTitle());

                CharSequence tmpCheck = holder.lTitle.getText();
                if(tmpCheck.equals("Chicken Curry")) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    CurryFragment fragment = new CurryFragment();
                    fragment.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_home, fragment).addToBackStack(null).commit();
                }
                if(tmpCheck.equals("Crunchy Sisig")){
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    SisigFragment fragment = new SisigFragment();
                    fragment.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_home, fragment).addToBackStack(null).commit();
                }
                if(tmpCheck.equals("Pinakbet")){
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    PinakbetFragment fragment = new PinakbetFragment();
                    fragment.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_home, fragment).addToBackStack(null).commit();

                }
                if(tmpCheck.equals("Paksiw na Lechon")){
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    PaksiwFragment fragment = new PaksiwFragment();
                    fragment.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_home, fragment).addToBackStack(null).commit();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return listLunch.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView lTitle;
        public ImageView lPic;
        public LinearLayout llinearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            lPic = (ImageView) itemView.findViewById(R.id.lunchPic);
            lTitle = (TextView) itemView.findViewById(R.id.lunchTitle);
            llinearLayout = (LinearLayout) itemView.findViewById(R.id.lunchlinearLayout);
            lunchCardView = (CardView) itemView.findViewById(R.id.lunchCardView);
        }
    }
}
