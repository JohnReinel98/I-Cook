package com.icook.dev.i_cook.TacoRiceRecipe;

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

public class TacoAdapter extends ArrayAdapter<ListTacoIngredients>{
    private Context context;

    public TacoAdapter(Context context, int resourceId, List<ListTacoIngredients> items){
        super(context,resourceId, items);
        this.context = context;
    }

    public class ViewHolder{
        public TextView tacoIngredient;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        ListTacoIngredients rowItem = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(getContext().LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_taco_ingredients, null);
            holder = new ViewHolder();
            holder.tacoIngredient = (TextView)convertView.findViewById(R.id.tacoIngredient);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tacoIngredient.setText(rowItem.getIngredient());
        return convertView;
    }
}
