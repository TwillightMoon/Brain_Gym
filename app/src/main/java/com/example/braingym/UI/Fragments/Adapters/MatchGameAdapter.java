package com.example.braingym.UI.Fragments.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.braingym.Data.Card;
import com.example.braingym.R;
import com.example.braingym.UI.Activities.MemoryGameActivity.MemoryGameActivityViewModel;

import java.util.List;

public class MatchGameAdapter extends BaseAdapter {
    private Context context;
    private List<Card> cards;
    private OnItemClickListener itemClickListener;

    public MatchGameAdapter(Context context, List<Card> cards, OnItemClickListener itemClickListener) {
        this.context = context;
        this.cards = cards;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Object getItem(int position) {
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_memory_card, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.image_view_card);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Card card = cards.get(position);
        if (card.isVisible()) {
            viewHolder.imageView.setImageResource(card.getImageResId());
        } else {
            viewHolder.imageView.setImageResource(R.drawable.bg_cardback);
        }

        convertView.setOnClickListener(v -> itemClickListener.onItemClick(position));

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}


