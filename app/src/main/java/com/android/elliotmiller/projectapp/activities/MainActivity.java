package com.android.elliotmiller.projectapp.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.elliotmiller.projectapp.R;
import com.android.elliotmiller.projectapp.fragments.Form;
import com.android.elliotmiller.projectapp.fragments.Results;
import com.android.elliotmiller.projectapp.models.Report;
import com.android.elliotmiller.projectapp.models.ReportsStore;

public class MainActivity extends AppCompatActivity implements Form.FormInterface {
    private ReportsStore reportsStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_top, Form.newInstance());
        ft.add(R.id.layout_bottom, Results.newInstance());
        ft.commit();
        reportsStore = ReportsStore.getReportStore(this);
    }

    @Override
    public void sumbitReport(Report report) {
        Toast.makeText(this, "Submitted Report!", Toast.LENGTH_SHORT).show();
        reportsStore.addReportToStore(report);
    }
}
