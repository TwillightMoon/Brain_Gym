package com.example.braingym.UI.Fragments.Settings;

import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;

import com.example.braingym.Domain.Factories.VMFactories.SettingViewModelFactory;
import com.example.braingym.Domain.Factories.VMFactories.TaskViewModelFactory;
import com.example.braingym.R;
import com.example.braingym.UI.Activities.MainActivity.MainActivity;
import com.example.braingym.UI.Fragments.Tasks.TasksViewModel;

public class Settings extends Fragment {

    private SettingsViewModel mViewModel;

    private CheckBox _musicCheckBox;
    private CheckBox _soundCheckBox;
    private CheckBox _vibrationCheckBox;

    private SeekBar _volumeSlider;

    private SwitchCompat _targetSwitch;
    private SwitchCompat _appThemeSwitch;

    private Button _rateUs;
    private Button _supportUs;
    private Button _faq;
    private Button _authors;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findAll(view);
        createViewModel();
        settingUpViews();
        setObservers();
    }

    private void findAll(View view){
        _musicCheckBox = view.findViewById(R.id.musicToggle);
        _soundCheckBox = view.findViewById(R.id.soundToggle);
        _vibrationCheckBox = view.findViewById(R.id.vibrationToggle);

        _volumeSlider = view.findViewById(R.id.volumeSeek);

        _targetSwitch = view.findViewById(R.id.targetAdsSwitch);
        _appThemeSwitch = view.findViewById(R.id.themeSwitch);

        _rateUs = view.findViewById(R.id.rateButton);
        _supportUs = view.findViewById(R.id.supportButton);
        _faq = view.findViewById(R.id.faqButton);
        _authors = view.findViewById(R.id.authorsButton);

    }
    private void createViewModel(){
        MainActivity parent = (MainActivity) getActivity();
        mViewModel = new ViewModelProvider(
                this,
                new SettingViewModelFactory(parent.getApplicationContext()))
                .get(SettingsViewModel.class);
    }

    private void settingUpViews(){
        mViewModel.programmingChange = true;

        _musicCheckBox.setOnCheckedChangeListener(mViewModel.onMusicToggleChange);
        _soundCheckBox.setOnCheckedChangeListener(mViewModel.onSoundToggleChange);
        _vibrationCheckBox.setOnCheckedChangeListener(mViewModel.onVibrationToggleChange);
        _targetSwitch.setOnCheckedChangeListener(mViewModel.onTargetToggleChange);
        _appThemeSwitch.setOnCheckedChangeListener(mViewModel.onThemeToggleChange);

        _volumeSlider.setOnSeekBarChangeListener(mViewModel.onVolumeChangeListener);


        _musicCheckBox.setChecked(Boolean.TRUE.equals(mViewModel.musicMode.getValue()));
        _soundCheckBox.setChecked(Boolean.TRUE.equals(mViewModel.soundMode.getValue()));
        _vibrationCheckBox.setChecked(Boolean.TRUE.equals(mViewModel.vibrationMode.getValue()));
        _targetSwitch.setChecked(Boolean.TRUE.equals(mViewModel.targetMode.getValue()));
        _appThemeSwitch.setChecked(Boolean.TRUE.equals(mViewModel.themeNight.getValue()));

        _volumeSlider.setProgress(mViewModel.volumeVal.getValue());

        mViewModel.programmingChange = false;
    }

    private void setObservers(){

    }
}