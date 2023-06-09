package com.example.braingym.UI.Activities.MemoryGameActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.GridView;

import com.example.braingym.Data.Card;
import com.example.braingym.R;
import com.example.braingym.UI.Fragments.Adapters.MatchGameAdapter;

import java.util.List;

public class MemoryGameActivity extends AppCompatActivity {
    private GridView gridView;
    private MemoryGameActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);

        gridView = findViewById(R.id.grid_view);
        viewModel = new ViewModelProvider(this).get(MemoryGameActivityViewModel.class);

        setupGridView();
    }

    private void setupGridView() {
        List<Card> cards = viewModel.getCards();

        MatchGameAdapter adapter = new MatchGameAdapter(this, cards, position -> {
            Card card = cards.get(position);
            viewModel.onCardClicked(card);
            ((MatchGameAdapter) gridView.getAdapter()).notifyDataSetChanged();
        });

        gridView.setAdapter(adapter);
    }
}

