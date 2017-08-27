package com.android.elliotmiller.projectapp.models;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azeezolaniran on 27/08/2017.
 */

public class ReportsStore {
    private static ReportsStore reportsStore;
    private Context context;
    private List<Client> reportClients = new ArrayList<>();
    private List<Report> reports = new ArrayList<>();

    private ReportsStore(Context ctx){
        super();
        this.context = ctx;
    }

    public static ReportsStore getReportStore(Context ctx) {
        if (reportsStore == null ) {
            Log.e(ReportsStore.class.getSimpleName(), "Reports Store is null sir");
            reportsStore = new ReportsStore(ctx);
            return reportsStore;
        }

        Log.e(ReportsStore.class.getSimpleName(), "Reports Store is NOT null sir");
        return reportsStore;
    }

    public void addReportListener(Client client) {
        this.reportClients.add(client);
        client.reportsUpdated(this.reports);
    }

    public void saveReports() {

    }

    public void getReports() {

    }

    // ToDO: I need to find a way to unregister the Store clients

    public void addReportToStore(Report report) {
        this.reports.add(report);
        for (Client c : this.reportClients) {
            c.reportsUpdated(this.reports);
            Log.e(
                    getClass().getSimpleName(), "Reports added. Reports Lenght -> " + this.reports.size() +
                            "\n" + report.reportName + " - " + report.reportMiles
            );
        }
        Log.e(getClass().getSimpleName(), "Reports added. Reports Lenght -> " + this.reports.size());
    }



    public interface Client {
        public void reportsUpdated(List<Report> newReports);
    }
}
