package com.example.braingym.Domain.Factories.TypeServiecesFactories.ArithmeticGames;

import android.content.Context;

import com.example.braingym.Domain.Factories.CardServiceFactory;
import com.example.braingym.Data.Games.GameCardInfo;
import com.example.braingym.Data.TypeService;
import com.example.braingym.R;

public class ArithmeticGameCardsFactory implements CardServiceFactory {

    private Context _context;

    public ArithmeticGameCardsFactory(Context _context){
        this._context = _context;
    }

    @Override
    public TypeService<GameCardInfo> create() {
        TypeService<GameCardInfo> cardService = new TypeService<GameCardInfo>();

        cardService.addCard(new GameCardInfo(
                _context.getString(R.string.text_game_quick_account),
                R.drawable.banner_account_game,
                0
        ));
        cardService.addCard(new GameCardInfo(
                _context.getString(R.string.text_game_ticket),
                R.drawable.banner_ticket_game,
                0
        ));

        return cardService;
    }
}
