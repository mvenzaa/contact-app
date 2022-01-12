package com.android.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.contactapp.adapter.ContactListAdapter;
import com.android.contactapp.api.API;
import com.android.contactapp.api.APIClient;
import com.android.contactapp.model.Model;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.textToolbar)
    public TextView textToolbar;

    @BindView(R.id.imageToolbar)
    public ImageView imageToolbar;

    @BindView(R.id.swipeRefreshLayout)
    public SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.rv)
    RecyclerView recyclerView;

    ContactListAdapter contactListAdapter;

    API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        imageToolbar.setVisibility(View.GONE);
        textToolbar.setText("Pilih Kontak");

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getContactList();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        contactListAdapter = new ContactListAdapter(getLayoutInflater(), MainActivity.this);
        recyclerView.setAdapter(contactListAdapter);

        getContactList();
    }

    public void getContactList() {
        api = APIClient.getAPI().create(API.class);
        Call<Model> call = api.getResults("5", "login,registered,id,nat", "us", "");
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful()) {
                    swipeRefreshLayout.setRefreshing(false);
                    Model body = response.body();
                    if (body!=null) {
                        contactListAdapter.setData(body.getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}