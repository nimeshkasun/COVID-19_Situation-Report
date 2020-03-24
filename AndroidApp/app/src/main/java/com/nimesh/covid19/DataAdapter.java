package com.nimesh.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public DataAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);
        holder.lastUpdated.setText(listItem.getLastUpdated());
        holder.locTotalCases.setText(listItem.getLocTotalCases());
        holder.locNewCases.setText(listItem.getLocNewCases());
        holder.locHospitalized.setText(listItem.getLocHospitalized());
        holder.locDeaths.setText(listItem.getLocDeaths());
        holder.locRecovered.setText(listItem.getLocRecovered());
       /* holder.gloTotalCases.setText(listItem.getGloTotalCases());
        holder.gloNewCases.setText(listItem.getGloNewCases());
        holder.gloDeaths.setText(listItem.getGloDeaths());
        holder.gloRecovered.setText(listItem.getGloRecovered());*/
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView lastUpdated;
        public TextView locTotalCases;
        public TextView locNewCases;
        public TextView locHospitalized;
        public TextView locDeaths;
        public TextView locRecovered;
        /*public TextView gloTotalCases;
        public TextView gloNewCases;
        public TextView gloDeaths;
        public TextView gloRecovered;*/

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lastUpdated = (TextView) itemView.findViewById(R.id.lastUpdated);
            locTotalCases = (TextView) itemView.findViewById(R.id.locTotalCases);
            locNewCases = (TextView) itemView.findViewById(R.id.locNewCases);
            locHospitalized = (TextView) itemView.findViewById(R.id.locHospitalized);
            locDeaths = (TextView) itemView.findViewById(R.id.locDeaths);
            locRecovered = (TextView) itemView.findViewById(R.id.locRecovered);
            /*gloTotalCases = (TextView) itemView.findViewById(R.id.gloTotalCases);
            gloNewCases = (TextView) itemView.findViewById(R.id.gloNewCases);
            gloDeaths = (TextView) itemView.findViewById(R.id.gloDeaths);
            gloRecovered = (TextView) itemView.findViewById(R.id.gloRecovered);*/
        }
    }
}
