package com.example.braingym.Data.ImageTheme;

public class ImageThemeInfo {
    public int imageID;
    public int cost;

    public int mode;

    public ImageThemeInfo(int imageID, int cost){
        this.imageID = imageID;
        this.cost = cost;
        this.mode = 0;
    }

    public ImageThemeInfo(int imageID, int cost, int mode){
        this.imageID = imageID;
        this.cost = cost;
        this.mode = mode;
    }
}
