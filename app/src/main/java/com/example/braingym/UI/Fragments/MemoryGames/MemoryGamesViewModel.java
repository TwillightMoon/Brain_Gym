package com.example.braingym.UI.Fragments.MemoryGames;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.braingym.Data.Games.GameCardInfo;
import com.example.braingym.Domain.App;
import com.example.braingym.R;
import com.example.braingym.UI.Activities.MainActivity.MainActivity;
import com.example.braingym.UI.Activities.MemoryGameActivity.MatchGameActivity;
import com.example.braingym.UI.Adapters.GameCategoryAdapter;
import com.example.braingym.UI.Adapters.onCardActionListener;

public class MemoryGamesViewModel extends ViewModel {
    private MainActivity _parent;
    private GameCategoryAdapter _gameCategoryAdapter;

    public MemoryGamesViewModel(MainActivity _parent){
        this._gameCategoryAdapter = new GameCategoryAdapter(
                App.getMemoryGameCards().getCardsInfo(),
                R.layout.item_game_card);

        this._parent = _parent;

        _gameCategoryAdapter.setActionListener(new onCardActionListener() {
            @Override
            public void onCardClickListener(GameCardInfo gameCategory) {
                String cardName = gameCategory.categoryName;
                Context context = _parent.getApplicationContext();

                if(context.getString(R.string.text_game_memory).endsWith(cardName)){
                    _parent.ActivityNavigate(MatchGameActivity.class);
                }
                else
                    _parent.Navigate(gameCategory.destinationID);
            }
        });
    }

    public GameCategoryAdapter getGameCategoryAdapter(){
        return _gameCategoryAdapter;
    }
}