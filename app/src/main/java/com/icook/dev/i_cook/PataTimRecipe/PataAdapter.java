package com.icook.dev.i_cook.PataTimRecipe;

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

public class PataAdapter extends ArrayAdapter<ListPataIngredients>{
    private Context context;

    public PataAdapter(Context context, int resourceId, List<ListPataIngredients> items){
        super(context,resourceId, items);
        this.context = context;
    }

    public class ViewHolder{
        public TextView pataIngredient;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        ListPataIngredients rowItem = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(getContext().LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_pata_ingredients, null);
            holder = new ViewHolder();
            holder.pataIngredient = (TextView)convertView.findViewById(R.id.pataIngredient);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.pataIngredient.setText(rowItem.getIngredient());
        return convertView;
    }
}
