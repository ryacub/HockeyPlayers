package com.wip.rayyacub.hockeyplayers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.wip.rayyacub.hockeyplayers.Adapter.HockeyAdapter;
import com.wip.rayyacub.hockeyplayers.Model.HockeyPlayers;
import com.wip.rayyacub.hockeyplayers.Model.Roster;
import com.wip.rayyacub.hockeyplayers.Network.ApiClient;
import com.wip.rayyacub.hockeyplayers.Network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<HockeyPlayers> hockeyList;
    private HockeyAdapter hockeyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvInit();
        networkCall();
    }

    //recycler view initialization
    private void rvInit() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);
    }

    //network call to get hockey roster
    private void networkCall() {
        ApiClient.getClient()
                .create(ApiService.class)
                .getRoster()
                .enqueue(new Callback<Roster>() {
                    @Override
                    public void onResponse(Call<Roster> call, Response<Roster> response) {
                        hockeyList = response.body().getRoster();
                        hockeyAdapter = new HockeyAdapter(MainActivity.this,hockeyList);
                        recyclerView.setAdapter(hockeyAdapter);

                    }

                    @Override
                    public void onFailure(Call<Roster> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "list failure" + call.request().url(), Toast.LENGTH_LONG).show();

                    }
                });

    }
}
