package com.icook.dev.i_cook.PancitRecipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.icook.dev.i_cook.R;

import java.util.List;

/**
 * Created by Win8.1 on 9/23/2017.
 */

public class PancitAdapter extends ArrayAdapter<ListPancitIngredients>{
    private Context context;

    public PancitAdapter(Context context, int resourceId, List<ListPancitIngredients> items){
        super(context,resourceId, items);
        this.context = context;
    }

    public class ViewHolder{
        public TextView pancitIngredient;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        ListPancitIngredients rowItem = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(getContext().LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_pancit_ingredients, null);
            holder = new ViewHolder();
            holder.pancitIngredient = (TextView)convertView.findViewById(R.id.pancitIngredient);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.pancitIngredient.setText(rowItem.getIngredient());
        return convertView;
    }
}
