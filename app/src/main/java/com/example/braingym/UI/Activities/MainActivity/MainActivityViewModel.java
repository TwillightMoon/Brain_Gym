package com.example.braingym.UI.Activities.MainActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;

import com.example.braingym.R;

public class MainActivityViewModel extends ViewModel {

    private final String TITLE_KEY = "title";
    private final String SETTING_KEY = "setting";

    private final NavController _navController;

    private final MutableLiveData<String> titleMutable = new MutableLiveData<String>();
    public LiveData<String> title = titleMutable;

    private final MutableLiveData<Boolean> isSettingMutable = new MutableLiveData<Boolean>();
    public LiveData<Boolean> isSetting = isSettingMutable;

    public MainActivityViewModel(NavController navController, FragmentManager fragmentManager) {
        _navController = navController;

        NavObserveSet();
    }

    private void NavObserveSet() {
        _navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(arguments == null) return;

                setTitle(arguments.getString(TITLE_KEY));
                setIsSetting(arguments.containsKey(SETTING_KEY));
            }
        });
    }

    public void NavClearStack(int fragmentId) {
        _navController.popBackStack(fragmentId, false);

        Log.i("TEST", "clear");
    }
    public boolean TryNavigate(int destinationID){
        NavDestination destination = _navController.getGraph().findNode(destinationID);
        if(destination != null){
            _navController.navigate(destinationID);
        }

        return (destination != null);

    }

    private void setTitle(String title) {
        titleMutable.setValue(title);
    }
    private void setIsSetting(Boolean flag){
        if(isSettingMutable.getValue() == flag) return;
        isSettingMutable.setValue(flag);
    }

    public View.OnClickListener toSetting = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            _navController.navigate(R.id.navigation_settings);
        }
    };
}
