package com.example.braingym.Domain.Factories.TypeServiecesFactories.ImageThemes;

import android.content.Context;

import com.example.braingym.Data.ImageTheme.ImageThemeInfo;
import com.example.braingym.Data.TypeService;
import com.example.braingym.Domain.Factories.CardServiceFactory;

public class ImageThemesServiceFactory implements CardServiceFactory {

    private Context _context;

    public ImageThemesServiceFactory(Context context){
        this._context = context;
    }

    @Override
    public TypeService<ImageThemeInfo> create() {
        TypeService<ImageThemeInfo> imageThemeInfoTypeService = new TypeService<ImageThemeInfo>();

        imageThemeInfoTypeService.addCard(new ImageThemeInfo(

        ));
    }
}
