package com.android.elliotmiller.projectapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.elliotmiller.projectapp.models.Report;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by azeezolaniran on 27/08/2017.
 */

public class SharedPreferenceUtil {
    public static final String PREFS_NAME = "PRODUCT_APP";
    public static final String REPORTS = "activity_reports";

    public SharedPreferenceUtil() {
        super();
    }

    // This four methods are used for maintaining reports.
    public void saveReports(Context context, List<Report> reports) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(reports);

        editor.putString(REPORTS, jsonFavorites);

        editor.commit();
    }

    public void addReport(Context context, Report report) {
        List<Report> favorites = getReports(context);
        if (favorites == null)
            favorites = new ArrayList<Report>();
        favorites.add(report);
        saveReports(context, favorites);
    }

    public void removeReport(Context context, Report report) {
        ArrayList<Report> favorites = getReports(context);
        if (favorites != null) {
            favorites.remove(report);
            saveReports(context, favorites);
        }
    }

    public ArrayList<Report> getReports(Context context) {
        SharedPreferences settings;
        List<Report> reports;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(REPORTS)) {
            String jsonFavorites = settings.getString(REPORTS, null);
            Gson gson = new Gson();
            Report[] favoriteItems = gson.fromJson(jsonFavorites,
                    Report[].class);

            reports = Arrays.asList(favoriteItems);
            reports = new ArrayList<>(reports);
        } else
            return null;

        return (ArrayList<Report>) reports;
    }
}
