package com.android.elliotmiller.projectapp.models;

/**
 * Created by azeezolaniran on 26/08/2017.
 */

public final class Report {

    public final String reportName;
    public final String reportDistance;
    public final String reportDate;

    public Report(String rName, String rDistance, String rDate) {
        super();
        this.reportName = rName;
        this.reportDistance = rDistance;
        this.reportDate = rDate;
    }
}
