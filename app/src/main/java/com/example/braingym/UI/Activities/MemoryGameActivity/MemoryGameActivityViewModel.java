package com.example.braingym.UI.Activities.MemoryGameActivity;

import android.os.CountDownTimer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.braingym.Data.Card;
import com.example.braingym.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 public class MemoryGameActivityViewModel extends ViewModel {
        private List<Card> cards;
        private List<Card> openedCards;

        public MemoryGameActivityViewModel() {
            cards = generateCards();
            openedCards = new ArrayList<>();
            shuffleCards();
        }

        public List<Card> getCards() {
            return cards;
        }

        public void onCardClicked(Card card) {
            if (openedCards.size() < 2 && !card.isVisible()) {
                card.setVisible(true);
                openedCards.add(card);
                if (openedCards.size() == 2) {
                    handleOpenedCards();
                }
            }
        }

        private void handleOpenedCards() {
            Card card1 = openedCards.get(0);
            Card card2 = openedCards.get(1);
            if (card1.getId() == card2.getId()) {
                // Карточки совпали
                card1.setVisible(true);
                card2.setVisible(true);
                openedCards.clear();
            } else {
                // Карточки не совпали
                card1.setVisible(false);
                card2.setVisible(false);
                openedCards.clear();
            }
        }

        private List<Card> generateCards() {
            List<Card> cards = new ArrayList<>();
            // Добавьте сюда свою логику для генерации карточек
            // Например, создайте пары карточек с одинаковыми идентификаторами, но разными изображениями
            cards.add(new Card(1, R.drawable.card_bear));
            cards.add(new Card(1, R.drawable.card_bear));
            cards.add(new Card(2, R.drawable.card_raccon));
            cards.add(new Card(2, R.drawable.card_raccon));
            cards.add(new Card(3, R.drawable.card_koala));
            cards.add(new Card(3, R.drawable.card_koala));
            cards.add(new Card(4, R.drawable.card_hedgehog));
            cards.add(new Card(4, R.drawable.card_hedgehog));
            cards.add(new Card(5, R.drawable.card_penguin));
            cards.add(new Card(5, R.drawable.card_penguin));
            cards.add(new Card(6, R.drawable.card_beaver));
            cards.add(new Card(6, R.drawable.card_beaver));
            return cards;
        }

        private void shuffleCards() {
            Collections.shuffle(cards);
        }
    }


