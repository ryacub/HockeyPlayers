package com.wip.rayyacub.hockeyplayers.Network;



import com.wip.rayyacub.hockeyplayers.Model.Roster;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("android_eval.json")
    Call<Roster> getRoster();
}
