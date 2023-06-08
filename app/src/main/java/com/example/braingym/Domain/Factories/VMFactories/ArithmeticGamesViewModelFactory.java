package com.example.braingym.Domain.Factories.VMFactories;

import androidx.lifecycle.ViewModel;

import com.example.braingym.UI.Activities.MainActivity.MainActivity;
import com.example.braingym.UI.Fragments.ArithmeticGames.ArithmeticGamesViewModel;

import androidx.lifecycle.ViewModelProvider.Factory;

public class ArithmeticGamesViewModelFactory implements Factory {

    private MainActivity _parent;
    public ArithmeticGamesViewModelFactory(MainActivity mainActivity){
        this._parent = mainActivity;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        // Создайте и верните экземпляр вашей модели представления
        if (modelClass.isAssignableFrom(ArithmeticGamesViewModel.class)) {
            return (T) new ArithmeticGamesViewModel(_parent);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
