package com.android.elliotmiller.projectapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.elliotmiller.projectapp.R;
import com.android.elliotmiller.projectapp.models.Report;

import java.util.List;

/**
 * Created by azeezolaniran on 27/08/2017.
 */

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.Holder> {
    private List<Report> reports;
    private Context context;

    public ResultsAdapter(Context ctx, List<Report> r) {
        super();
        this.context = ctx;
        this.reports = r;
        if (r != null)
            Log.e("Yo YO size", String.valueOf(r.size()));
        if (this.context == null) {
            Log.e("yo yo", "Context is null");
        }
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("hey", String.valueOf(this.reports.size()));
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        Log.e("hey", String.valueOf(this.reports.size()));
        return new Holder(view);
    }

    @Override
    public int getItemCount() {
        if (this.reports == null) {
            return 0;
        }
        return this.reports.size();
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.e("hey", String.valueOf(this.reports.size()) + " position - " + String.valueOf(position));
        Report report = reports.get(position);
        holder.tvDate.setText(report.reportDate);
        holder.tvAcitivity.setText(report.reportName);
        holder.tvMiles.setText(report.reportMiles);
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView tvAcitivity, tvMiles, tvDate;
        public Holder(View itemView) {
            super(itemView);
            this.tvAcitivity = itemView.findViewById(R.id.tv_activity);
            this.tvMiles = itemView.findViewById(R.id.tv_miles);
            this.tvDate = itemView.findViewById(R.id.tv_date);
        }
    }
}
