package com.example.braingym.Domain.Factories.VMFactories;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;

import com.example.braingym.UI.Activities.MainActivity.MainActivity;
import com.example.braingym.UI.Activities.MainActivity.MainActivityViewModel;
import com.example.braingym.UI.Fragments.Games.GamesViewModel;
import com.example.braingym.UI.Fragments.Tasks.TasksViewModel;

public class TaskViewModelFactory implements Factory {

    private MainActivity mainActivity;

    public TaskViewModelFactory(MainActivity parent){
        mainActivity = parent;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        // Создайте и верните экземпляр вашей модели представления
        if (modelClass.isAssignableFrom(TasksViewModel.class)) {
            return (T) new TasksViewModel(mainActivity);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
