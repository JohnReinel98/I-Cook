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
import com.icook.dev.i_cook.CurryRecipe.CurryFragment;

import java.util.List;

/**
 * Created by Win8.1 on 9/23/2017.
 */

public class BFastAdapter extends RecyclerView.Adapter<BFastAdapter.ViewHolder>{
    private List<ListBFast> listBfast;
    private Context context;
    CardView bfastCardView;

    public BFastAdapter(List<ListBFast> listBurgers, Context context) {
        this.listBfast = listBurgers;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_bfast, parent, false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ListBFast listBurger = listBfast.get(position);


        holder.bPic.setImageResource(listBurger.getPic());
        holder.bTitle.setText(listBurger.getTitle());

        holder.linearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Title",listBfast.get(position).getTitle());

                CharSequence tmpCheck = holder.bTitle.getText();
                if(tmpCheck.equals("Chicken Tapa")) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    ChickTapaFragment fragment = new ChickTapaFragment();
                    fragment.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_home, fragment).addToBackStack(null).commit();
                }
                if(tmpCheck.equals("Filipino Beef Tapa")){
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    CurryFragment burgerConfFrag = new CurryFragment();
                    burgerConfFrag.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_home, burgerConfFrag).addToBackStack(null).commit();
                }
                if(tmpCheck.equals("Chicken Tocino")){
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    CurryFragment burgerConfFrag = new CurryFragment();
                    burgerConfFrag.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_home, burgerConfFrag).addToBackStack(null).commit();

                }
                if(tmpCheck.equals("Daing na Bangus")){
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    CurryFragment burgerConfFrag = new CurryFragment();
                    burgerConfFrag.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_home, burgerConfFrag).addToBackStack(null).commit();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return listBfast.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView bTitle;
        public ImageView bPic;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            bPic = (ImageView) itemView.findViewById(R.id.bfastPic);
            bTitle = (TextView) itemView.findViewById(R.id.bfastTitle);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            bfastCardView = (CardView) itemView.findViewById(R.id.bfastCardView);
        }
    }
}
