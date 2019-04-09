package com.election_commission.votingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class DashboardActivityAdapter extends RecyclerView.Adapter<DashboardActivityAdapter.ViewHolder> {

    private Context context;
    private View view;
    ArrayList<Elements> arrayList;

    public DashboardActivityAdapter(Context context, ArrayList<Elements> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitems_dashboard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(arrayList.get(position).getElement_name());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            findIds();
        }

        public void findIds(){
            tvTitle = (TextView) view.findViewById(R.id.tvTitle1);
        }
    }
}
