package com.example.braingym.Domain.Factories.TypeServiecesFactories.ImageThemes;

import android.content.Context;

import com.example.braingym.Data.ImageTheme.ImageThemeInfo;
import com.example.braingym.Data.TypeService;
import com.example.braingym.Domain.Factories.CardServiceFactory;
import com.example.braingym.R;

public class ImageThemesServiceFactory implements CardServiceFactory {

    private Context _context;

    public ImageThemesServiceFactory(Context context){
        this._context = context;
    }

    @Override
    public TypeService<ImageThemeInfo> create() {
        TypeService<ImageThemeInfo> imageThemeInfoTypeService = new TypeService<ImageThemeInfo>();

        imageThemeInfoTypeService.addCard(new ImageThemeInfo(
                R.drawable.cat_and_kite,
                0
        ));
        imageThemeInfoTypeService.addCard(new ImageThemeInfo(
                R.drawable.cat_on_roof,
                0
        ));
        imageThemeInfoTypeService.addCard(new ImageThemeInfo(
                R.drawable.cat_in_forest,
                0
        ));
        imageThemeInfoTypeService.addCard(new ImageThemeInfo(
                R.drawable.cat_and_food,
                0
        ));
        imageThemeInfoTypeService.addCard(new ImageThemeInfo(
                R.drawable.cat_and_rain,
                0
        ));
        imageThemeInfoTypeService.addCard(new ImageThemeInfo(
                R.drawable.cat_and_moon,
                0,
                1
        ));
        return imageThemeInfoTypeService;
    }
}
