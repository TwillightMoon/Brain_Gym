package com.example.braingym.Data;

import java.util.ArrayList;

public class TypeService<Type> {
    private ArrayList<Type> _typeInfo;

    public TypeService(){
        _typeInfo = new ArrayList<Type>();
    }

    public ArrayList<Type> getCardsInfo(){
        return _typeInfo;
    }
    public int getCount(){
        return _typeInfo.size();
    }
    public Type getByIndex(int index){
        return _typeInfo.get(index);
    }
    public void addCard(Type info){
        _typeInfo.add(info);
    }
}
