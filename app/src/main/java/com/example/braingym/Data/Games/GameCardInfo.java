package com.example.braingym.Data.Games;

public class GameCardInfo {
    public GameCardInfo(String categoryName, int gameImageID, int destinationID){
        this.categoryName = categoryName;
        this.gameImageID = gameImageID;
        this.destinationID = destinationID;
    }

    public String categoryName;
    public int gameImageID;
    public int destinationID;
}
