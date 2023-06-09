package com.example.braingym.UI.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.braingym.Data.ImageTheme.ImageThemeInfo;
import com.example.braingym.R;

import java.util.ArrayList;

public class ImageThemeAdapter extends RecyclerView.Adapter<ImageThemeAdapter.ViewHolder> implements View.OnClickListener{
    private ArrayList<ImageThemeInfo> _themeCard;

    private onCardActionListener actionListener;
    private int _itemLayoutID;

    public ImageThemeAdapter(ArrayList<ImageThemeInfo> cards, int itemLayoutID) {
        _itemLayoutID = itemLayoutID;
        this._themeCard = cards;
    }

    @NonNull
    @Override
    public ImageThemeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(_itemLayoutID, parent, false);

        view.getRootView().setOnClickListener(this);

        return new ImageThemeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageThemeAdapter.ViewHolder holder, int position) {
        ImageThemeInfo themeCard = _themeCard.get(position);

        holder.itemView.setTag(themeCard);
        holder.cardBackground.setImageResource(themeCard.imageID);
        holder.costText.setText(String.valueOf(themeCard.cost));

        if(themeCard.mode == 0)
            holder.cardThemeMode.setImageResource(R.drawable.ic_sun);
        else
            holder.cardThemeMode.setImageResource(R.drawable.ic_moon);

        if(themeCard.cost == 0){
            holder.progressBar.setProgress(100);
        }
    }

    @Override
    public int getItemCount() {
        return _themeCard.size();
    }

    public void setActionListener(onCardActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView cardBackground;
        private ImageView cardThemeMode;
        private TextView costText;

        private ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardBackground = itemView.findViewById(R.id.cardBackground);
            cardThemeMode = itemView.findViewById(R.id.themeModeImage);
            costText = itemView.findViewById(R.id.themeCostText);

            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
