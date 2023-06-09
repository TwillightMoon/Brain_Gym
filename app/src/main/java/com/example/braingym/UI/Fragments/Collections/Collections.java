package com.example.braingym.UI.Fragments.Collections;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.braingym.Domain.Factories.VMFactories.CollectionsViewModelFactory;
import com.example.braingym.Domain.Factories.VMFactories.TaskViewModelFactory;
import com.example.braingym.R;
import com.example.braingym.UI.Activities.MainActivity.MainActivity;
import com.example.braingym.UI.Fragments.Tasks.TasksViewModel;

public class Collections extends Fragment {

    private CollectionsViewModel mViewModel;
    private RecyclerView _recyclerView;

    public static Collections newInstance() {
        return new Collections();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collections, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findAll(view);
        createVM();
        settingUpRecycler();
    }


    private void createVM() {
        MainActivity parent = (MainActivity) getActivity();
        mViewModel = new ViewModelProvider(
                this,
                new CollectionsViewModelFactory((MainActivity) getActivity()))
                .get(CollectionsViewModel.class);
    }


    private void findAll(View view){
        _recyclerView = view.findViewById(R.id.themeList);
    }
    private void settingUpRecycler(){
        _recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        _recyclerView.setAdapter(mViewModel.getImageThemeAdapter());
    }
}