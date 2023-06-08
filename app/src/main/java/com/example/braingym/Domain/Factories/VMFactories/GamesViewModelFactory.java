package com.example.braingym.Domain.Factories.VMFactories;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;

import com.example.braingym.UI.Activities.MainActivity.MainActivity;
import com.example.braingym.UI.Fragments.Games.GamesViewModel;

public class GamesViewModelFactory implements Factory {

    private MainActivity _parent;
    public GamesViewModelFactory(MainActivity mainActivity){
        this._parent = mainActivity;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        // Создайте и верните экземпляр вашей модели представления
        if (modelClass.isAssignableFrom(GamesViewModel.class)) {
            return (T) new GamesViewModel(_parent);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
