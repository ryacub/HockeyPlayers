package com.wip.rayyacub.hockeyplayers;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PlayerProfileFragment extends Fragment {

    private ImageView playerImage;
    private TextView playerName;
    private TextView playerRole;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.player_profile_fragment,container,false);
        playerImage = (ImageView) rootview.findViewById(R.id.player_image);
        playerName = (TextView) rootview.findViewById(R.id.player_name);
        playerRole = (TextView) rootview.findViewById(R.id.player_role);
        profileSetUp();
        return rootview;
    }

    //loading the information for each profile
    private void profileSetUp() {
        String imageUrl = getArguments().getString("IMAGE");
        Glide.with(getContext()).load(imageUrl).into(playerImage);
        playerName.setText(getArguments().getString("NAME"));
        playerRole.setText(getArguments().getString("ROLE"));
    }
}
