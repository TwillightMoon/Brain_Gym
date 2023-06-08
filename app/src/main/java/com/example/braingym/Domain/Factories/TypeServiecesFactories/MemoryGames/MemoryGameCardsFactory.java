package com.example.braingym.Domain.Factories.TypeServiecesFactories.MemoryGames;

import android.content.Context;

import com.example.braingym.Domain.Factories.CardServiceFactory;
import com.example.braingym.Data.Games.GameCardInfo;
import com.example.braingym.Data.TypeService;
import com.example.braingym.R;

public class MemoryGameCardsFactory implements CardServiceFactory {
    private Context _context;

    public MemoryGameCardsFactory(Context _context){
        this._context = _context;
    }

    @Override
    public TypeService<GameCardInfo> create() {
        TypeService<GameCardInfo> cardService = new TypeService<GameCardInfo>();

        cardService.addCard(new GameCardInfo(
                _context.getString(R.string.text_game_memory),
                R.drawable.banner_memory_game,
                0
        ));
        cardService.addCard(new GameCardInfo(
                _context.getString(R.string.text_game_sequence),
                R.drawable.banner_sequence_game,
                0
        ));

        return cardService;
    }
}
