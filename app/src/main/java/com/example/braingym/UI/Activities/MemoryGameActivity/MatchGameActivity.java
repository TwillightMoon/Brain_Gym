package com.example.braingym.UI.Activities.MemoryGameActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.widget.GridView;

import com.example.braingym.Data.Card;
import com.example.braingym.R;
import com.example.braingym.UI.Adapters.MatchCardAdapter;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;

public class MatchGameActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final int GAME_DURATION = 60000; // Длительность игры в миллисекундах (1 минута)

    private MatchGameViewModel gameViewModel;
    private MatchCardAdapter cardAdapter;
    private CountDownTimer timer;

    private int currentScore = 0;

    private Handler handler;

    private TextView timeLeft;
    private TextView time;
    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);

        handler = new Handler();

        GridView gridView = findViewById(R.id.grid_view);
        gridView.setOnItemClickListener(this);

        cardAdapter = new MatchCardAdapter(this);
        gridView.setAdapter(cardAdapter);

        gameViewModel = new ViewModelProvider(this).get(MatchGameViewModel.class);
        gameViewModel.getCards().observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(List<Card> cards) {
                cardAdapter.setCards(cards);
            }

        });

        gameViewModel.getGameStatus().observe(this, new Observer<GameStatus>() {
            @Override
            public void onChanged(GameStatus gameStatus) {
                if (gameStatus == GameStatus.WIN) {
                    showGameResult("Congratulations! You won!");
                } else if (gameStatus == GameStatus.LOSE) {
                    showGameResult("Game over! You lost!");
                }
            }
        });

        timeLeft = findViewById(R.id.timeleft);
        time = findViewById(R.id.time);
        score = findViewById(R.id.score);

        score.setText(String.format("%d", currentScore));

        startNewGame();
    }

    private void startNewGame() {
        gameViewModel.startNewGame();
        startGameTimer();
    }

    private void startGameTimer() {
        timer = new CountDownTimer(GAME_DURATION, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long millisStart = GAME_DURATION - millisUntilFinished;
                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(minutes);

                timeLeft.setText(String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds));

                minutes = TimeUnit.MILLISECONDS.toMinutes(millisStart);
                seconds = TimeUnit.MILLISECONDS.toSeconds(millisStart) - TimeUnit.MINUTES.toSeconds(minutes);

                time.setText(String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds));

            }

            @Override
            public void onFinish() {
                gameViewModel.endGame();
            }
        };
        timer.start();
    }


    private void showGameResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        timer.cancel();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                recreate();
            }
        }, 5000); // Задержка в 2 секунды перед переворотом карточек
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (cardAdapter.isCardVisible(position) || gameViewModel.isGameEnded()) {
            return; // Не обрабатывать клики на уже открытых карточках или после окончания игры
        }

        gameViewModel.onCardClicked(position);
        cardAdapter.setCardVisible(position, true);
        cardAdapter.notifyDataSetChanged();

        if (gameViewModel.isTwoCardsOpened()) {
            handleTwoOpenedCards();
        }
    }

    private void handleTwoOpenedCards() {
        boolean isMatch = gameViewModel.checkCardsMatch();
        if (isMatch) {
            currentScore = currentScore + 15;
            score.setText(String.format("%d", 15));

            if (gameViewModel.isGameEnded()) {
                gameViewModel.endGame();
            }
        } else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    gameViewModel.closeOpenedCards(cardAdapter);
                    cardAdapter.notifyDataSetChanged();
                }
            }, 500); // Задержка в 2 секунды перед переворотом карточек

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }
}


