package com.mycompany.myapp;

import android.app.*;
import android.graphics.*;
public class Env
{
    public Activity activity;
    public Rect stageRect;
    //描画するキャンバスのサイズ（ピクセル）
    public int stageSize;
    //キャンバスのセルサイズ（セルの個数）
    public int stageCellSize = 5;
    //ステージのX座標（SurfaceViewの座標）
    public int stageX;
    //描画する画像のサイズ（ピクセル数）
    public int itemSize;
    //コントローラのサイズ（ピクセル数）
    public int ctrlSize;
    //背景Bitmapのサイズ（ピクセル数）
    public int bmpSize;
    //背景Bitmapのセルサイズ
    public int bmpCellSize;
    //カメラ
    Camera camera;
    //ゲームマップ
    GameMap gameMap;
    //環境依存の値を作成（ピクセル数）
    public static Env cook(int width,int height){
        Env env = new Env();
        //ステージのサイズ（ピクセル数）
        env.stageSize = cookStageSize(height);
        //１セルのサイズ（ピクセル数）
        env.itemSize = env.stageSize / env.stageCellSize;
        //コントローラのサイズ（ピクセル数）
        env.ctrlSize = (width - env.stageSize) / 2;
        //ステージを描画するSurfaceView座標
        env.stageX = env.ctrlSize;
        //背景Bitmapの大きさ（ピクセル）
        env.bmpSize = env.stageSize * 3;
        //背景Bitmapの大きさ（セル個数）
        env.bmpCellSize = env.stageCellSize * 3;
        //ステージの描画範囲
        env.stageRect = new Rect(env.stageX,0,env.stageX + env.stageSize,env.stageSize);
        return env;
    }
    //ステージのサイズ（ピクセル）を作成
    static int cookStageSize(int height){
        int count = 0;
        
        while(true){
            if (++count * 80 >= height){
                return --count * 80;
            }
        }
    }
    
}
