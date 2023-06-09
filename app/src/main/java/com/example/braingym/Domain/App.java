package com.example.braingym.Domain;

import android.app.Application;
import android.content.Context;

import com.example.braingym.Data.Games.GameCardInfo;
import com.example.braingym.Data.ImageTheme.ImageThemeInfo;
import com.example.braingym.Data.Tasks.TaskInfo;
import com.example.braingym.Data.TypeService;
import com.example.braingym.Domain.Factories.TypeServiecesFactories.ArithmeticGames.ArithmeticGameCardsFactory;
import com.example.braingym.Domain.Factories.TypeServiecesFactories.AttentivenessGames.AttentivenessGameCardsFactory;
import com.example.braingym.Domain.Factories.TypeServiecesFactories.GameCategories.GameCategoriesFactory;
import com.example.braingym.Domain.Factories.TypeServiecesFactories.ImageThemes.ImageThemesServiceFactory;
import com.example.braingym.Domain.Factories.TypeServiecesFactories.MemoryGames.MemoryGameCardsFactory;
import com.example.braingym.Domain.Factories.TypeServiecesFactories.Task.TaskInfoServiceFactory;

public class App extends Application {
    private static TypeService<GameCardInfo> _gameCategories;

    private static TypeService<GameCardInfo> _memoryGameCards;
    private static TypeService<GameCardInfo> _attentivenessGameCards;
    private static TypeService<GameCardInfo> _arithmeticGameCard;

    private static TypeService<TaskInfo> _tasks;
    private static TypeService<ImageThemeInfo> _imageThemes;
    private static Context _appContext;

    public static TypeService<GameCardInfo> getGameCategories(){
        if(_gameCategories == null)
            _gameCategories = new GameCategoriesFactory(_appContext).create();

        return _gameCategories;
    }

    public static TypeService<GameCardInfo> getMemoryGameCards() {
        if(_memoryGameCards == null)
            _memoryGameCards = new MemoryGameCardsFactory(_appContext).create();
        return _memoryGameCards;
    }

    public static TypeService<GameCardInfo> getAttentivenessGameCards() {
        if(_attentivenessGameCards == null)
            _attentivenessGameCards = new AttentivenessGameCardsFactory(_appContext).create();

        return _attentivenessGameCards;
    }

    public static TypeService<GameCardInfo> getArithmeticGameCard() {
        if(_arithmeticGameCard == null)
            _arithmeticGameCard = new ArithmeticGameCardsFactory(_appContext).create();

        return _arithmeticGameCard;
    }

    public static TypeService<TaskInfo> getTasks() {
        if(_tasks == null)
            _tasks = new TaskInfoServiceFactory(_appContext).create();

        return _tasks;
    }

    public static TypeService<ImageThemeInfo> getImageThemes() {
        if(_imageThemes == null)
            _imageThemes = new ImageThemesServiceFactory(_appContext).create();

        return _imageThemes;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        _appContext = getApplicationContext();
    }
}