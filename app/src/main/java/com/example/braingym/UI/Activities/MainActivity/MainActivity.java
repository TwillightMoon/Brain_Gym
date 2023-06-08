package com.example.braingym.UI.Activities.MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.braingym.Domain.Factories.VMFactories.MainActivityViewModelFactory;
import com.example.braingym.R;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;

    private NavigationBarView _bottomNavView;
    private NavController _navController;

    private TextView _titleView;
    private ImageButton _settingButton;

    public void Navigate(int destinationID){
        if(!viewModel.TryNavigate(destinationID))
            Toast.makeText(this, "Раздел ещё в разработке", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findAll();

        createVM();
        createNavigationBar();

        setObservers();
    }

    private void createVM() {
        viewModel = new ViewModelProvider(this,
                new MainActivityViewModelFactory(this))
                .get(MainActivityViewModel.class);
    }

    private void createNavigationBar() {
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_games, R.id.navigation_tasks)
                .build();

        _settingButton.setOnClickListener(viewModel.toSetting);

        NavigationUI.setupWithNavController(_bottomNavView, _navController);

        _bottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                viewModel.NavClearStack(item.getItemId());

                _navController.navigate(item.getItemId());
                return false;
            }
        });
    }

    private void findAll(){
        _titleView = findViewById(R.id.fragment_title);

        _bottomNavView = findViewById(R.id.bottom_nav);
        _navController = Navigation.findNavController(this, R.id.fragment_container);

        _settingButton = findViewById(R.id.settingButton);
    }

    private void setObservers(){
        viewModel.title.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String titleText) {
                _titleView.setText(titleText);
            }
        });

        viewModel.isSetting.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean flag) {
                if(flag){
                    _settingButton.setEnabled(false);
                    _settingButton.setVisibility(View.GONE);
                }
                else{
                    _settingButton.setEnabled(true);
                    _settingButton.setVisibility(View.VISIBLE);
                }
            }
        });
    }
 }