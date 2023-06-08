package com.example.braingym.Domain.Factories.TypeServiecesFactories.AttentivenessGames;

import android.content.Context;

import com.example.braingym.Domain.Factories.CardServiceFactory;
import com.example.braingym.Data.Games.GameCardInfo;
import com.example.braingym.Data.TypeService;
import com.example.braingym.R;

public class AttentivenessGameCardsFactory implements CardServiceFactory {
    private Context _context;

    public AttentivenessGameCardsFactory(Context _context){
        this._context = _context;
    }

    @Override
    public TypeService<GameCardInfo> create() {
        TypeService<GameCardInfo> cardService = new TypeService<GameCardInfo>();

        cardService.addCard(new GameCardInfo(
                _context.getString(R.string.text_game_Colors),
                R.drawable.banner_colors_game,
                2
        ));

        return cardService;
    }
}
