package com.example.braingym.Domain.Factories.VMFactories;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.example.braingym.UI.Activities.MainActivity.MainActivity;
import com.example.braingym.UI.Fragments.Collections.CollectionsViewModel;

import androidx.lifecycle.ViewModelProvider.Factory;

public class CollectionsViewModelFactory implements Factory {

    private MainActivity mainActivity;

    public CollectionsViewModelFactory(MainActivity parent){
        mainActivity = parent;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        // Создайте и верните экземпляр вашей модели представления
        if (modelClass.isAssignableFrom(CollectionsViewModel.class)) {
            return (T) new CollectionsViewModel(mainActivity);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
