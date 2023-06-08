package com.example.braingym.UI.Fragments.AttentivenessGames;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.braingym.Domain.Factories.VMFactories.AttentivenessGamesViewModelFactory;
import com.example.braingym.R;
import com.example.braingym.UI.Activities.MainActivity.MainActivity;

public class AttentivenessGames extends Fragment {

    private AttentivenessGamesViewModel mViewModel;
    private RecyclerView _recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_attentiveness_games, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findAll(view);
        createVM();
        settingUpRecycler();
    }

    private void createVM(){
        mViewModel = new ViewModelProvider(
                this,
                new AttentivenessGamesViewModelFactory((MainActivity) getActivity()))
                .get(AttentivenessGamesViewModel.class);
    }

    private void findAll(View view){
        _recyclerView = view.findViewById(R.id.gameCategoryList);
    }
    private void settingUpRecycler(){
        _recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        _recyclerView.setAdapter(mViewModel.getGameCategoryAdapter());
    }
}