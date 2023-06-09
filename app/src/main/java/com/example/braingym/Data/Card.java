package com.example.braingym.Data;

import com.example.braingym.R;

public class Card {

    private final int id;
    private final int imageID;
    private boolean matched;

    public Card(int id, int imageID) {
        this.id = id;
        this.matched = false;
        this.imageID = imageID;
    }

    public int getId() {
        return id;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public int getFrontImageResId() {
        return imageID;
    }

    public int getBackImageResId() {
        return R.drawable.bg_cardback;
    }
}

