package com.wip.rayyacub.hockeyplayers.Adapter;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wip.rayyacub.hockeyplayers.MainActivity;
import com.wip.rayyacub.hockeyplayers.Model.HockeyPlayers;
import com.wip.rayyacub.hockeyplayers.PlayerProfileFragment;
import com.wip.rayyacub.hockeyplayers.R;

import java.util.ArrayList;
import java.util.List;

public class HockeyAdapter extends RecyclerView.Adapter<HockeyAdapter.HockeyViewHolder> {

    private Context context;
    private List<HockeyPlayers> hockeyPlayers = new ArrayList<>();

    public HockeyAdapter(Context context, List<HockeyPlayers> hockeyPlayers) {
        this.context = context;
        this.hockeyPlayers = hockeyPlayers;
    }

    @Override
    public HockeyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new HockeyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HockeyViewHolder holder, int position) {
        String imageString = hockeyPlayers.get(position).getImageUrl();
        Glide.with(context).load(imageString).into(holder.playerImage);
        holder.playerName.setText(hockeyPlayers.get(position).getName());
        holder.playerPosition.setText(hockeyPlayers.get(position).getPosition());
        holder.cardView.setOnClickListener(new profileClick(position));

    }

    public int getItemCount() {
        return hockeyPlayers.size();
    }

    //profile view holders
    public class HockeyViewHolder extends RecyclerView.ViewHolder {

        private ImageView playerImage;
        private TextView playerName;
        private TextView playerPosition;
        private CardView cardView;

        public HockeyViewHolder(View itemView) {
            super(itemView);
            playerImage = (ImageView) itemView.findViewById(R.id.player_image);
            playerName = (TextView) itemView.findViewById(R.id.player_name);
            playerPosition = (TextView) itemView.findViewById(R.id.player_role);
            cardView = (CardView) itemView.findViewById(R.id.player_card);
        }
    }

    //card Click Listener
    private class profileClick implements View.OnClickListener {

        private int position;

        public profileClick(int postion) {
            this.position = postion;
        }

        @Override
        public void onClick(View v) {

            PlayerProfileFragment playerProfileFragment = new PlayerProfileFragment();
            Bundle playerBundle = new Bundle();
            playerBundle.putString("NAME", (hockeyPlayers.get(position).getName()));
            playerBundle.putString("ROLE", (hockeyPlayers.get(position).getPosition()));
            playerBundle.putString("IMAGE", (hockeyPlayers.get(position).getImageUrl()));
            playerProfileFragment.setArguments(playerBundle);
            FragmentTransaction transaction = ((MainActivity) context).getSupportFragmentManager()
                    .beginTransaction();
            transaction.replace(R.id.main, playerProfileFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
