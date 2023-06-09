package com.example.braingym.UI.Fragments.Tasks;

import androidx.lifecycle.ViewModel;

import com.example.braingym.Domain.App;
import com.example.braingym.R;
import com.example.braingym.UI.Activities.MainActivity.MainActivity;
import com.example.braingym.UI.Adapters.TaskCardAdapter;

public class TasksViewModel extends ViewModel {

    private TaskCardAdapter _taskCardAdapter;
    private MainActivity _parent;

    public TasksViewModel(MainActivity parent){
        _parent = parent;

        _taskCardAdapter = new TaskCardAdapter(
                App.getTasks().getCardsInfo(),
                R.layout.item_task_card);
    }

    public TaskCardAdapter getTaskCardAdapter(){
        return _taskCardAdapter;
    }
}