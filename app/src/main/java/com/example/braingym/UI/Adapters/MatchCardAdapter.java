package com.example.braingym.UI.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.braingym.Data.Card;
import com.example.braingym.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchCardAdapter extends BaseAdapter {

    private Context context;
    private List<Card> cards;
    private boolean[] cardVisibility;

    public MatchCardAdapter(Context context) {
        this.context = context;
        this.cards = new ArrayList<>();
        this.cardVisibility = new boolean[0];
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
        this.cardVisibility = new boolean[cards.size()];
        notifyDataSetChanged();
    }

    public void setCardVisible(int position, boolean isVisible) {
        cardVisibility[position] = isVisible;
    }
    public void setCardVisible(Card card, boolean isVisible) {
        int index = cards.indexOf(card);
        cardVisibility[index] = isVisible;
    }

    public boolean isCardVisible(int position) {
        return cardVisibility[position];
    }

    public void setCardsVisible(boolean isVisible) {
        Arrays.fill(cardVisibility, isVisible);
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
        if (cardVisibility[position]) {
            viewHolder.imageView.setImageResource(card.getFrontImageResId());
        } else {
            viewHolder.imageView.setImageResource(card.getBackImageResId());
        }

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
    }
}
