package com.example.braingym.Domain.Factories.VMFactories;

import androidx.lifecycle.ViewModel;

import com.example.braingym.UI.Activities.MainActivity.MainActivity;
import com.example.braingym.UI.Fragments.AttentivenessGames.AttentivenessGamesViewModel;

import androidx.lifecycle.ViewModelProvider.Factory;

public class AttentivenessGamesViewModelFactory implements Factory {

    private MainActivity _parent;
    public AttentivenessGamesViewModelFactory(MainActivity mainActivity){
        this._parent = mainActivity;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        // Создайте и верните экземпляр вашей модели представления
        if (modelClass.isAssignableFrom(AttentivenessGamesViewModel.class)) {
            return (T) new AttentivenessGamesViewModel(_parent);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
