package com.mycompany.myapp;

import android.graphics.drawable.*;

public interface GameMap
{
    void load();
    int[][] getMap();
    Drawable getImg(int x, int y);
    int getMapValue(int x, int y);
}
