package com.mycompany.myapp;

import android.graphics.*;
import android.graphics.Bitmap;
import android.graphics.drawable.*;
import android.util.*;

public class StageBitmap extends App
{
    //ダンジョンの一部を描画するソースBitmap
    Bitmap bmp;
    //カメラに描画するソースBitmapの範囲
    Rect srcRect;
    
    public StageBitmap(Env env){
        super(env);
    }
    void load(Canvas canvas, Rect cameraRect){
        createBitmap(cameraRect);
    }
    void createBitmap(Rect cameraRect){
        //Bitmapに描画するダンジョンの範囲
        Rect bmpRect = new Rect(cameraX(),
                                cameraY(),
                                cameraX()+env.bmpSize,
                                cameraY()+env.bmpSize);
        //カメラ範囲が中央にくる処理
        bmpRect.offset(-env.stageSize, -env.stageSize);
        //カメラに描画するBitmapの範囲
        srcRect = new Rect(env.stageSize,
                           env.stageSize,
                           env.stageSize * 2,
                           env.stageSize * 2);
        if (bmp != null){
            bmp.recycle();
        }
        //Bitmapの作成
        
        bmp = Bitmap.createBitmap(env.bmpSize,env.bmpSize,
                                  Bitmap.Config.ARGB_4444);
                                  
        Canvas canvas = new Canvas(bmp);
        
        for (int i = 0; i < env.bmpCellSize; i++){
            //ダンジョンのY座標
            int y = bmpRect.top + env.itemSize * i;
            for (int j = 0; j < env.bmpCellSize; j++){
                //ダンジョンのX座標
                int x = bmpRect.left + env.itemSize * j;
                //座標からBitmapに描画する画像を取得
                Drawable img = env.gameMap.getImg(x,y);
                //描画するBitmapの位置
                int _x = env.itemSize * j;
                int _y = env.itemSize * i;
                //描画処理
                img.setBounds(
                                _x,_y,
                                _x + env.itemSize,
                                _y + env.itemSize);
                img.draw(canvas);
            }
        }
    }
    //ソースBitmap範囲を移動
    public void offset(Rect cameraRect, int x, int y){
        srcRect.offset(x,y);
        if (srcRect.top == 0 || srcRect.left == 0 || srcRect.bottom == env.bmpSize || srcRect.right == env.bmpSize){
            //Bitmapを新規作成
            createBitmap(cameraRect);
        }
    }
    void close(){
        if (bmp != null){
            bmp.recycle();
        }
    }
}


