package edu.ub.pis2016.mmanjarrez.practica2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by orla_ on 05/07/2016.
 */
public class AsignaturaaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Asignatura> items;

    public AsignaturaaAdapter(Context context, ArrayList<Asignatura> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.activity_objeto2, parent, false);
        }

        // Set data into the view.
        TextView nom = (TextView) rowView.findViewById(R.id.nombre);
        TextView des = (TextView) rowView.findViewById(R.id.desc);

        Asignatura item = this.items.get(position);
        nom.setText(item.getNombre());
        if (item.isFinalizada()) {
            des.setText("Nota: "+item.getNota());
        } else {
            des.setText("Cursando");
        }
        return rowView;
    }
}
