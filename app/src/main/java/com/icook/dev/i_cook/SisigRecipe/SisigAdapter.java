package com.icook.dev.i_cook.SisigRecipe;

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

public class SisigAdapter extends ArrayAdapter<ListSisigIngredients>{
    private Context context;

    public SisigAdapter(Context context, int resourceId, List<ListSisigIngredients> items){
        super(context,resourceId, items);
        this.context = context;
    }

    public class ViewHolder{
        public TextView sisigIngredient;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        ListSisigIngredients rowItem = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(getContext().LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_sisig_ingredients, null);
            holder = new ViewHolder();
            holder.sisigIngredient = (TextView)convertView.findViewById(R.id.sisigIngredient);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.sisigIngredient.setText(rowItem.getIngredient());
        return convertView;
    }
}
