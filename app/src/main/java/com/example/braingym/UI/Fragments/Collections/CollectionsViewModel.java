package com.example.braingym.UI.Fragments.Collections;

import androidx.lifecycle.ViewModel;

import com.example.braingym.Domain.App;
import com.example.braingym.R;
import com.example.braingym.UI.Activities.MainActivity.MainActivity;
import com.example.braingym.UI.Adapters.ImageThemeAdapter;

public class CollectionsViewModel extends ViewModel {

    private MainActivity _parent;
    private ImageThemeAdapter _imageThemeAdapter;

    public CollectionsViewModel(MainActivity parent){
        _parent = parent;

        _imageThemeAdapter = new ImageThemeAdapter(
                App.getImageThemes().getCardsInfo(),
                R.layout.item_card_theme
        );

    }

    public ImageThemeAdapter getImageThemeAdapter() {
        return _imageThemeAdapter;
    }
}