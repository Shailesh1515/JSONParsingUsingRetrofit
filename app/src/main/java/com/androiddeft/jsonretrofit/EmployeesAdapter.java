package com.androiddeft.jsonretrofit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androiddeft.jsonretrofit.beans.Employee;

import java.util.List;

/**
 * Created by Abhi on 23 Sep 2017 023.
 */

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.CustomViewHolder> {
    private List<Employee> employees;

    public EmployeesAdapter(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Employee employee = employees.get(position);
        holder.employeeName.setText(employee.getName());
        holder.email.setText(employee.getEmail());
        holder.designation.setText(employee.getDesignation());
        holder.salary.setText(employee.getSalary());
        holder.dob.setText(employee.getDob());
        holder.contactNumber.setText(employee.getContactNumber());
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView employeeName, designation, email, salary, dob,contactNumber;

        public CustomViewHolder(View view) {
            super(view);
            employeeName = (TextView) view.findViewById(R.id.employeeName);
            email = (TextView) view.findViewById(R.id.email);
            designation = (TextView) view.findViewById(R.id.designation);
            salary = (TextView) view.findViewById(R.id.salary);
            dob = (TextView) view.findViewById(R.id.dob);
            contactNumber = (TextView) view.findViewById(R.id.contactNumber);
        }
    }
}
