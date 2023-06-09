package com.example.braingym.UI.Fragments.ArithmeticGames;

import androidx.lifecycle.ViewModel;

import com.example.braingym.Data.Games.GameCardInfo;
import com.example.braingym.Domain.App;
import com.example.braingym.R;
import com.example.braingym.UI.Activities.MainActivity.MainActivity;
import com.example.braingym.UI.Adapters.GameCategoryAdapter;
import com.example.braingym.UI.Adapters.onCardActionListener;

public class ArithmeticGamesViewModel extends ViewModel {
    private MainActivity _parent;
    private GameCategoryAdapter _gameCategoryAdapter;

    public ArithmeticGamesViewModel(MainActivity _parent){
        this._gameCategoryAdapter = new GameCategoryAdapter(
                App.getArithmeticGameCard().getCardsInfo(),
                R.layout.item_game_card);

        this._parent = _parent;

        _gameCategoryAdapter.setActionListener(new onCardActionListener() {
            @Override
            public void onCardClickListener(GameCardInfo gameCategory) {
                _parent.Navigate(gameCategory.destinationID);
            }
        });
    }

    public GameCategoryAdapter getGameCategoryAdapter(){
        return _gameCategoryAdapter;
    }
}