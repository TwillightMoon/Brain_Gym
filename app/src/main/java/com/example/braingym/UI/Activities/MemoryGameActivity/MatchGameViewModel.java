package com.example.braingym.UI.Activities.MemoryGameActivity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.braingym.Data.Card;
import com.example.braingym.R;
import com.example.braingym.UI.Adapters.MatchCardAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MatchGameViewModel extends ViewModel {

    private static final int CARD_PAIRS_COUNT = 8; // Количество пар карточек

    private MutableLiveData<List<Card>> cardsLiveData;
    private MutableLiveData<GameStatus> gameStatusLiveData;

    private List<Card> cards;
    private Card openedCard1;
    private Card openedCard2;

    public LiveData<List<Card>> getCards() {
        if (cardsLiveData == null) {
            cardsLiveData = new MutableLiveData<>();
            generateCards();
        }
        return cardsLiveData;
    }

    public LiveData<GameStatus> getGameStatus() {
        if (gameStatusLiveData == null) {
            gameStatusLiveData = new MutableLiveData<>();
        }
        return gameStatusLiveData;
    }

    public void startNewGame() {
        generateCards();
        gameStatusLiveData.setValue(GameStatus.IN_PROGRESS);
    }

    public void endGame() {
        gameStatusLiveData.setValue(GameStatus.LOSE);
    }

    public boolean isGameEnded() {
        return gameStatusLiveData.getValue() != GameStatus.IN_PROGRESS;
    }

    public void onCardClicked(int position) {
        Card card = cards.get(position);
        if (openedCard1 == null) {
            openedCard1 = card;
        } else if (openedCard2 == null) {
            openedCard2 = card;
        }

        if (openedCard1 != null && openedCard2 != null) {
            checkCardsMatch();
        }
    }

    public boolean isTwoCardsOpened() {
        return openedCard1 != null && openedCard2 != null;
    }

    public boolean checkCardsMatch() {
        boolean isMatch = openedCard1 != null && openedCard2 != null &&
                openedCard1.getId() == openedCard2.getId();

        if (isMatch) {
            openedCard1.setMatched(true);
            openedCard2.setMatched(true);

            openedCard1 = null;
            openedCard2 = null;

            if (isAllCardsMatched()) {
                gameStatusLiveData.setValue(GameStatus.WIN);
            }
        }

        return isMatch;
    }

    public void closeOpenedCards(MatchCardAdapter cardAdapter) {
        cardAdapter.setCardVisible(openedCard1, false);
        cardAdapter.setCardVisible(openedCard2, false);

        openedCard1 = null;
        openedCard2 = null;
    }

    private void generateCards() {
        cards = new ArrayList<>();

        cards.add(new Card(1, R.drawable.card_bear));
        cards.add(new Card(1, R.drawable.card_bear));

        cards.add(new Card(2, R.drawable.card_beaver));
        cards.add(new Card(2, R.drawable.card_beaver));

        cards.add(new Card(3, R.drawable.card_hedgehog));
        cards.add(new Card(3, R.drawable.card_hedgehog));

        cards.add(new Card(4, R.drawable.card_raccon));
        cards.add(new Card(4, R.drawable.card_raccon));

        cards.add(new Card(5, R.drawable.card_koala));
        cards.add(new Card(5, R.drawable.card_koala));

        cards.add(new Card(6, R.drawable.card_penguin));
        cards.add(new Card(6, R.drawable.card_penguin));

        // Перемешиваем карточки
        Collections.shuffle(cards);

        cardsLiveData.setValue(cards);
    }

    private boolean isAllCardsMatched() {
        for (Card card : cards) {
            if (!card.isMatched()) {
                return false;
            }
        }
        return true;
    }
}
