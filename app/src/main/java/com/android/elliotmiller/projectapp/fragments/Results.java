package com.android.elliotmiller.projectapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.elliotmiller.projectapp.R;
import com.android.elliotmiller.projectapp.adapters.ResultsAdapter;
import com.android.elliotmiller.projectapp.models.Report;
import com.android.elliotmiller.projectapp.models.ReportsStore;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Results#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Results extends Fragment implements ReportsStore.Client {

    private RecyclerView rv;
    private TextView tv;


    public Results() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Results.
     */
    public static Results newInstance() {
        Results fragment = new Results();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_results, container, false);
        rv = view.findViewById(R.id.rv);
        tv = view.findViewById(R.id.tv_rv_empty);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        ReportsStore.getReportStore(getContext()).addReportListener(this);
        rv.setAdapter(new ResultsAdapter(null));
        return view;
    }

    @Override
    public void reportsUpdated(List<Report> newReports) {
        rv.setAdapter(new ResultsAdapter(newReports));
        if (newReports.size() <= 0) {
            tv.setVisibility(View.VISIBLE);
        } else {
            tv.setVisibility(View.GONE);
        }
    }
}
