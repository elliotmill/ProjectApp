package com.android.elliotmiller.projectapp.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.elliotmiller.projectapp.R;
import com.android.elliotmiller.projectapp.fragments.Form;
import com.android.elliotmiller.projectapp.fragments.Results;
import com.android.elliotmiller.projectapp.models.Report;

public class MainActivity extends AppCompatActivity implements Form.FormInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_top, Form.newInstance());
        ft.add(R.id.layout_bottom, Results.newInstance());
        ft.commit();
    }

    @Override
    public void sumbitReport(Report report) {

    }
}
