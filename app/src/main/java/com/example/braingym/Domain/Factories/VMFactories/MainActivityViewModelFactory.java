package com.example.braingym.Domain.Factories.VMFactories;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.braingym.R;
import com.example.braingym.UI.Activities.MainActivity.MainActivityViewModel;
import com.example.braingym.UI.Fragments.Games.GamesViewModel;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {

    private NavController _navController;
    private FragmentManager _fragmentManager;

    public MainActivityViewModelFactory(AppCompatActivity activity){
        _navController = Navigation.findNavController(activity, R.id.fragment_container);
        _fragmentManager = activity.getSupportFragmentManager();
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        // Создайте и верните экземпляр вашей модели представления
        if (modelClass.isAssignableFrom(MainActivityViewModel.class)) {
            return (T) new MainActivityViewModel(_navController, _fragmentManager);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
