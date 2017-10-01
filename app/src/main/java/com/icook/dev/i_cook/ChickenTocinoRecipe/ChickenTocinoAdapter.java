package com.icook.dev.i_cook.ChickenTocinoRecipe;

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

public class ChickenTocinoAdapter extends ArrayAdapter<ListChickenTocinoIngredients>{
    private Context context;

    public ChickenTocinoAdapter(Context context, int resourceId, List<ListChickenTocinoIngredients> items){
        super(context,resourceId, items);
        this.context = context;
    }

    public class ViewHolder{
        public TextView ctocinoIngredient;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        ListChickenTocinoIngredients rowItem = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(getContext().LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_ctocino_ingredients, null);
            holder = new ViewHolder();
            holder.ctocinoIngredient = (TextView)convertView.findViewById(R.id.ctocinoIngredient);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.ctocinoIngredient.setText(rowItem.getIngredient());
        return convertView;
    }
}
