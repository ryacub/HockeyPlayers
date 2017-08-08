package com.wip.rayyacub.hockeyplayers.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Roster {
    @SerializedName("roster")
    @Expose
    private List<HockeyPlayers> roster = null;

    public List<HockeyPlayers> getRoster() {
        return roster;
    }

    public void setRoster(List<HockeyPlayers> roster) {
        this.roster = roster;
    }
}
