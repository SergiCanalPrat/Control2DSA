package dsa.upc.edu.examendsa2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class CitiesRecyclerViewAdapter extends RecyclerView.Adapter<CitiesRecyclerViewAdapter.ViewHolder> {
    private List<Element> data;
    private Context context;



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ine;
        public TextView nom;
        public ImageView escut;


        public ViewHolder(View v) {
            super(v);
            ine = (TextView) v.findViewById(android.R.id.ine);
            nom = (TextView) v.findViewById(android.R.id.nom);
            escut = (ImageView) v.findViewById(android.R.id.escut);

        }
    }

    //Constructor
    public CitiesRecyclerViewAdapter(List<Element> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public CitiesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.recyclercities, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CitiesRecyclerViewAdapter.ViewHolder holder, int position) {
        Element element = ((Element) data.get(position));
        holder.ine.setText(element.getIne());
        holder.nom.setText(element.getMunicipiNom());
        Picasso.with(context).load(element.getMunicipiEscut()).into(holder.escut);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}