package com.icook.dev.i_cook.ChickTapaRecipe;

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

public class ChickTapaAdapter extends ArrayAdapter<ListChickTapaIngredients>{
    private Context context;

    public ChickTapaAdapter(Context context, int resourceId, List<ListChickTapaIngredients> items){
        super(context,resourceId, items);
        this.context = context;
    }

    public class ViewHolder{
        public TextView ctapaIngredient;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        ListChickTapaIngredients rowItem = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(getContext().LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_ctapa_ingredients, null);
            holder = new ViewHolder();
            holder.ctapaIngredient = (TextView)convertView.findViewById(R.id.ctapaIngredient);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.ctapaIngredient.setText(rowItem.getIngredient());
        return convertView;
    }
}
