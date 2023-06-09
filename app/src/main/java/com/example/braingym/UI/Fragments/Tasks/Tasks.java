package com.example.braingym.UI.Fragments.Tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.braingym.Domain.Factories.VMFactories.TaskViewModelFactory;
import com.example.braingym.R;
import com.example.braingym.UI.Activities.MainActivity.MainActivity;

public class Tasks extends Fragment {

    private TasksViewModel mViewModel;
    private RecyclerView _recyclerView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tasks, container, false);
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
                new TaskViewModelFactory(parent))
                .get(TasksViewModel.class);
    }


    private void findAll(View view){
        _recyclerView = view.findViewById(R.id.taskList);
    }
    private void settingUpRecycler(){
        _recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        _recyclerView.setAdapter(mViewModel.getTaskCardAdapter());
    }
}