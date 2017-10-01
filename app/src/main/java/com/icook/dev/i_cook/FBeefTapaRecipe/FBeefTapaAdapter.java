package com.icook.dev.i_cook.FBeefTapaRecipe;

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

public class FBeefTapaAdapter extends ArrayAdapter<ListFBeefTapaIngredients>{
    private Context context;

    public FBeefTapaAdapter(Context context, int resourceId, List<ListFBeefTapaIngredients> items){
        super(context,resourceId, items);
        this.context = context;
    }

    public class ViewHolder{
        public TextView fbeeftapaIngredient;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        ListFBeefTapaIngredients rowItem = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(getContext().LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_fbeeftapa_ingredients, null);
            holder = new ViewHolder();
            holder.fbeeftapaIngredient = (TextView)convertView.findViewById(R.id.fbeeftapaIngredient);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.fbeeftapaIngredient.setText(rowItem.getIngredient());
        return convertView;
    }
}
