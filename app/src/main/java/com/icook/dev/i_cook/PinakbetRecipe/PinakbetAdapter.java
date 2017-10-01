package com.icook.dev.i_cook.PinakbetRecipe;

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

public class PinakbetAdapter extends ArrayAdapter<ListPinakbetIngredients>{
    private Context context;

    public PinakbetAdapter(Context context, int resourceId, List<ListPinakbetIngredients> items){
        super(context,resourceId, items);
        this.context = context;
    }

    public class ViewHolder{
        public TextView pinakbetIngredient;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        ListPinakbetIngredients rowItem = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(getContext().LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_pinakbet_ingredients, null);
            holder = new ViewHolder();
            holder.pinakbetIngredient = (TextView)convertView.findViewById(R.id.pinakbetIngredient);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.pinakbetIngredient.setText(rowItem.getIngredient());
        return convertView;
    }
}
