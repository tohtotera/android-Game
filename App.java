package com.mycompany.myapp;

import android.graphics.drawable.*;
import android.view.*;
public class App
{
    protected Env env;
    
    App(Env env){
        this.env = env;
    }
    //共通メソッド（画像取得）
    Drawable img(int id){
        return env.activity.getResources().getDrawable(id);
    }
    //共通メソッド（view取得）
    View view(int id){
        return env.activity.findViewById(id);
    }
    //ゲームマップを戻す
    GameMap gameMap(){
        return env.gameMap;
    }
    //カメラを戻す
    Camera camera(){
        return env.camera;
    }
    //カメラのX座標を戻す
    int cameraX(){
        return camera().cameraRect.left;
    }
    //カメラのY座標を戻す
    int cameraY(){
        return camera().cameraRect.top;
    }
    //アイテムサイズを戻す
    int itemSize(){
        return env.itemSize;
    }
    //ステージのSurfaceViewの座標を戻す
    int stageOffset(){
        return env.stageX;
    }
    //マップの横サイズを戻す
    int gameMapWidth(){
        return gameMap().getMap()[0].length * env.itemSize;
    }
    //マップの縦サイズを戻す
    int gameMapHeight(){
        return gameMap().getMap().length * env.itemSize;
    }
}
