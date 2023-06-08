package com.example.braingym.Domain.Factories.TypeServiecesFactories.GameCategories;

import android.content.Context;

import com.example.braingym.Data.Games.GameCardInfo;
import com.example.braingym.Data.TypeService;
import com.example.braingym.Domain.Factories.CardServiceFactory;
import com.example.braingym.R;

public class GameCategoriesFactory implements CardServiceFactory {
    private Context _context;

    public GameCategoriesFactory(Context _context){
        this._context = _context;
    }

    @Override
    public TypeService<GameCardInfo> create() {
        TypeService<GameCardInfo> cardService = new TypeService<GameCardInfo>();

        cardService.addCard(new GameCardInfo(
                _context.getString(R.string.text_category_memory),
                R.drawable.banner_memory,
                R.id.navigation_memoryGames
        ));
        cardService.addCard(new GameCardInfo(
                _context.getString(R.string.text_category_arithmetic),
                R.drawable.banner_arithmetic,
                R.id.navigation_arithmeticGames
        ));
        cardService.addCard(new GameCardInfo(
                _context.getString(R.string.text_category_attentiveness),
                R.drawable.banner_attentiveness,
                R.id.navigation_attentivenessGames
        ));

        return cardService;
    }
}
