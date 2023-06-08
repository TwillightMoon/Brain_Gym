package com.example.braingym.Domain.Factories.TypeServiecesFactories.Task;

import android.content.Context;

import com.example.braingym.Data.Games.GameCardInfo;
import com.example.braingym.Data.Tasks.TaskInfo;
import com.example.braingym.Data.TypeService;
import com.example.braingym.Domain.Factories.CardServiceFactory;
import com.example.braingym.R;

public class TaskInfoServiceFactory implements CardServiceFactory {

    private Context _context;

    public TaskInfoServiceFactory(Context context) {
        _context = context;
    }

    @Override
    public TypeService<TaskInfo> create() {
        TypeService<TaskInfo> taskInfoTypeService = new TypeService<TaskInfo>();

        taskInfoTypeService.addCard(new TaskInfo(
                _context.getString(R.string.welcome_title),
                _context.getString(R.string.welcome_description),
                R.drawable.ic_coin,
                50
        ));
        taskInfoTypeService.addCard(new TaskInfo(
                _context.getString(R.string.first_time_title),
                _context.getString(R.string.first_time_description),
                R.drawable.ic_coin,
                50
        ));
        taskInfoTypeService.addCard(new TaskInfo(
                _context.getString(R.string.victory_title),
                _context.getString(R.string.victory_description),
                R.drawable.ic_coin,
                100
        ));
        taskInfoTypeService.addCard(new TaskInfo(
                _context.getString(R.string.good_job_title),
                _context.getString(R.string.good_job_description),
                R.drawable.ic_coin,
                200,
                5
        ));

        return taskInfoTypeService;
    }
}
