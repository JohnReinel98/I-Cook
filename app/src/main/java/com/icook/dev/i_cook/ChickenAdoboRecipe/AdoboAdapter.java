package com.icook.dev.i_cook.ChickenAdoboRecipe;

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

public class AdoboAdapter extends ArrayAdapter<ListAdoboIngredients>{
    private Context context;

    public AdoboAdapter(Context context, int resourceId, List<ListAdoboIngredients> items){
        super(context,resourceId, items);
        this.context = context;
    }

    public class ViewHolder{
        public TextView adoboIngredient;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        ListAdoboIngredients rowItem = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(getContext().LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_adobo_ingredients, null);
            holder = new ViewHolder();
            holder.adoboIngredient = (TextView)convertView.findViewById(R.id.adoboIngredient);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.adoboIngredient.setText(rowItem.getIngredient());
        return convertView;
    }
}
