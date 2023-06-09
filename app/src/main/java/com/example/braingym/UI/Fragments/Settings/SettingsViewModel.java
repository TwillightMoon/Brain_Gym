package com.example.braingym.UI.Fragments.Settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.braingym.R;


public class SettingsViewModel extends ViewModel {

    private Context _context;
    private SharedPreferences settingsPref;

    public boolean programmingChange = false;

    private final String MUSIC_MODE_KEY = "music_mode";
    private final String SOUND_MODE_KEY = "sound_mode";
    private final String VIBRATION_MODE_KEY = "vibration_mode";

    private final String VOLUME_VAL_KEY = "volume_val";

    private final String TARGET_MODE_KEY = "target_mode";
    private final String THEME_MODE_KEY = "theme_mode";

    private final MutableLiveData<Boolean> musicModeMutable = new MutableLiveData<Boolean>();
    public LiveData<Boolean> musicMode = musicModeMutable;

    private final MutableLiveData<Boolean> soundModeMutable = new MutableLiveData<Boolean>();
    public LiveData<Boolean> soundMode = soundModeMutable;

    private final MutableLiveData<Boolean> vibrationModeMutable = new MutableLiveData<Boolean>();
    public LiveData<Boolean> vibrationMode = vibrationModeMutable;

    private final MutableLiveData<Boolean> targetModeMutable = new MutableLiveData<Boolean>();
    public LiveData<Boolean> targetMode = targetModeMutable;

    private final MutableLiveData<Boolean> themeNightMutable = new MutableLiveData<Boolean>();
    public LiveData<Boolean> themeNight = themeNightMutable;

    private final MutableLiveData<Integer> volumeValMutable = new MutableLiveData<Integer>();
    public LiveData<Integer> volumeVal = volumeValMutable;

    public SettingsViewModel(Context context){
        _context = context;
        String sharedName = _context.getString(R.string.SETTING_PREF_NAME);

        settingsPref = context.getSharedPreferences(sharedName, Context.MODE_PRIVATE);

        recoverySetting();
    }


    public CompoundButton.OnCheckedChangeListener onMusicToggleChange = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isCheked) {
            settingsPref.edit().putBoolean(MUSIC_MODE_KEY, isCheked).apply();

            musicModeMutable.setValue(isCheked);

            if(programmingChange) return;

            if(isCheked)
                Toast.makeText(_context, "Музыка включена", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(_context, "Музыка выключена", Toast.LENGTH_SHORT).show();
        }
    };
    public CompoundButton.OnCheckedChangeListener onSoundToggleChange = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isCheked) {
            settingsPref.edit().putBoolean(SOUND_MODE_KEY, isCheked).apply();
            soundModeMutable.setValue(isCheked);

            if(programmingChange) return;

            if(isCheked)
                Toast.makeText(_context, "Звук включен", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(_context, "Звук выключен", Toast.LENGTH_SHORT).show();
        }
    };
    public CompoundButton.OnCheckedChangeListener onVibrationToggleChange = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isCheked) {
            settingsPref.edit().putBoolean(VIBRATION_MODE_KEY, isCheked).apply();
            vibrationModeMutable.setValue(isCheked);

            if(programmingChange) return;

            if(isCheked)
                Toast.makeText(_context, "вибрация включена", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(_context, "вибрация выключена", Toast.LENGTH_SHORT).show();
        }
    };

    public CompoundButton.OnCheckedChangeListener onTargetToggleChange = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isCheked) {
            settingsPref.edit().putBoolean(TARGET_MODE_KEY, isCheked).apply();
            targetModeMutable.setValue(isCheked);

            if(programmingChange) return;

            if(isCheked)
                Toast.makeText(_context, "Таргетовая реклама включена", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(_context, "Таргетовая реклама выключена", Toast.LENGTH_SHORT).show();
        }
    };
    public CompoundButton.OnCheckedChangeListener onThemeToggleChange = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isCheked) {
            settingsPref.edit().putBoolean(THEME_MODE_KEY, isCheked).apply();
            themeNightMutable.setValue(isCheked);

            if(programmingChange) return;

            if(isCheked)
                Toast.makeText(_context, "Темная тема", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(_context, "Светлая тема", Toast.LENGTH_SHORT).show();
        }
    };

    public SeekBar.OnSeekBarChangeListener onVolumeChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            settingsPref.edit().putInt(VOLUME_VAL_KEY, progress).apply();
            volumeValMutable.setValue(progress);

            if(fromUser)
                Toast.makeText(_context, String.format("Текущий уровень звука: %d", progress), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void recoverySetting(){
        musicModeMutable.setValue(settingsPref.getBoolean(MUSIC_MODE_KEY, true));
        soundModeMutable.setValue(settingsPref.getBoolean(SOUND_MODE_KEY, true));
        vibrationModeMutable.setValue(settingsPref.getBoolean(VIBRATION_MODE_KEY, true));
        targetModeMutable.setValue(settingsPref.getBoolean(TARGET_MODE_KEY, true));
        themeNightMutable.setValue(settingsPref.getBoolean(THEME_MODE_KEY, false));

        volumeValMutable.setValue(settingsPref.getInt(VOLUME_VAL_KEY, 100));
    }
}