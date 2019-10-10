package com.androiddeft.jsonretrofit;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androiddeft.jsonretrofit.api.ApiService;
import com.androiddeft.jsonretrofit.beans.Employee;
import com.androiddeft.jsonretrofit.beans.EmployeeList;
import com.androiddeft.jsonretrofit.helper.RetroClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Employee> employeeList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private EmployeesAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<EmployeeList> call = api.getMyJSON();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                //Dismiss Dialog
                pDialog.dismiss();

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    employeeList = response.body().getEmployee();
                    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    eAdapter = new EmployeesAdapter(employeeList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);
                }
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }
}
