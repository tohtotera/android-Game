package com.mycompany.myapp;

import android.graphics.drawable.*;
import java.util.*;

public class GameMap1 extends App implements GameMap
{
    GameMap1(Env env){
        super(env);
    }
    //マップ情報
    int[][]map = {
        {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
        {2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,1,2,2,2,2},
        {2,2,1,1,2,2,1,1,1,1,1,2,1,1,1,1,1,1,2,2},
        {2,2,1,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,2,2},
        {2,2,2,2,1,2,1,2,2,1,2,1,1,2,2,2,1,1,2,2},
        {2,2,2,2,1,1,1,1,2,2,2,2,2,2,2,2,1,1,2,2},
        {2,2,2,2,1,1,1,2,2,2,2,2,2,2,2,2,1,1,2,2},
        {2,2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2},
        {2,2,2,2,1,2,2,2,1,1,1,1,1,1,1,1,1,1,2,2},
        {2,2,2,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,2,2},
        {2,2,2,1,2,2,2,1,1,2,2,2,2,2,2,2,1,1,2,2},
        {2,2,2,1,1,1,1,1,1,2,2,2,2,2,2,2,1,1,2,2},
        {2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2},
        {2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2},
        {2,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2},
    };
    //マッピング情報
    Map<Integer,Drawable>mapping;
    //移動可能なマップ値を管理
    List<Integer>moveValue;
    
    public void load(){
        //CSVファイルからmapの値を作成
        mapping = new HashMap<Integer,Drawable>();
        //マッピング情報を作成
        mapping.put(1,img(R.drawable.bg_g));
        mapping.put(2,img(R.drawable.bg_m));
        mapping.put(98,img(R.drawable.bg_end));
        mapping.put(99,img(R.drawable.bg_none));
        //移動可能マップ値を設定
        moveValue = new ArrayList<Integer>();
        moveValue.add(1);
        moveValue.add(98);
    }
    
    //マップを戻す
    public int[][] getMap(){
        return map;
    }
    
    //指定した座標の画像を戻す
    public Drawable getImg(int x, int y){
        return mapping.get(getMapValue(x,y));
    }
    
    //指定した座標のマップ値を戻す
    public int getMapValue(int x, int y){
        //座標が０以下の場合はマップ値９９を戻す
        if (x < 0 || y < 0){
            return 99;
        }
        //マップ座標を算出
        int mapX = x / env.itemSize;
        int mapY = y / env.itemSize;
        //マップ座標がマップを超える場合はマップ値９９を戻す
        if (mapX >= map[0].length || mapY >= map.length){
            return 99;
        }
        return map[mapY][mapX];
    }
    
}

