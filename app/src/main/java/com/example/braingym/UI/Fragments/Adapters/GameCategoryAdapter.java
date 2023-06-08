package com.example.braingym.UI.Fragments.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.braingym.Data.Games.GameCardInfo;
import com.example.braingym.R;

import java.util.ArrayList;

public class GameCategoryAdapter extends RecyclerView.Adapter<GameCategoryAdapter.ViewHolder> implements View.OnClickListener {
    private ArrayList<GameCardInfo> _games;

    private onCardActionListener actionListener;
    private int _itemLayoutID;

    public GameCategoryAdapter(ArrayList<GameCardInfo> _games, int itemLayoutID) {
        _itemLayoutID = itemLayoutID;
        this._games = _games;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(_itemLayoutID, parent, false);

        view.getRootView().setOnClickListener(this);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GameCardInfo gameCategory = _games.get(position);

        holder.itemView.setTag(gameCategory);
        holder._cardBackground.setImageResource(gameCategory.gameImageID);
        holder._cardName.setText(gameCategory.categoryName);
    }

    @Override
    public int getItemCount() {
        return _games.size();
    }

    public void setActionListener(onCardActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @Override
    public void onClick(View view) {
        GameCardInfo gameCategory = (GameCardInfo) view.getTag();
        Log.i("TEST", String.valueOf(gameCategory == null));
        actionListener.onCardClickListener(gameCategory);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView _cardBackground;
        private TextView _cardName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            _cardBackground = itemView.findViewById(R.id.cardBackground);
            _cardName = itemView.findViewById(R.id.cardName);

        }
    }
}
