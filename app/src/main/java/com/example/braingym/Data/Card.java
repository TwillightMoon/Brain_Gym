package com.example.braingym.Data;

public class Card {
    private int id;
    private int imageResId;
    private boolean isVisible;

    public Card(int id, int imageResId) {
        this.id = id;
        this.imageResId = imageResId;
        this.isVisible = false;
    }

    public int getId() {
        return id;
    }

    public int getImageResId() {
        return imageResId;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
