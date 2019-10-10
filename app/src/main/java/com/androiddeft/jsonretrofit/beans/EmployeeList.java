package com.androiddeft.jsonretrofit.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Abhi on 06 Sep 2017 006.
 */

public class EmployeeList {

    @SerializedName("employee")
    @Expose
    private ArrayList<Employee> employee = null;

    public ArrayList<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(ArrayList<Employee> employee) {
        this.employee = employee;
    }

}
