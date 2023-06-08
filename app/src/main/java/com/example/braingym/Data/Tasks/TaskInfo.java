package com.example.braingym.Data.Tasks;

public class TaskInfo {
    public String taskName;
    public String description;
    public int progress;
    public int currentProgress;
    public int drawableID;
    public int award;

    public TaskInfo(String taskName, String description, int drawableID, int award, int progress){
        this.taskName = taskName;
        this.description = description;
        this.drawableID = drawableID;
        this.award = award;
        this.progress = progress;
    }
    public TaskInfo(String taskName, String description, int drawableID, int award){
        this.taskName = taskName;
        this.description = description;
        this.drawableID = drawableID;
        this.award = award;
        this.progress = 1;
    }
}
