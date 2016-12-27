package com.mycompany.myapp;

import android.graphics.*;

public class Camera extends App
{
    //カメラが表示する範囲
    Rect cameraRect;
    Paint paint = new Paint();
    //スピード
    int speed;
    //ステージの背景画像クラス
    StageBitmap bg;
    //ユーザ操作
    int userCtrl;
    
    Camera(Env env){
        super(env);
        speed = env.itemSize;
        bg = new StageBitmap(env);
    }
    //初期表示
    void load(Canvas canvas){
        //描画する範囲を作成
        cameraRect = new Rect(0,0,env.stageSize,env.stageSize);
        //ステージの背景画像を作成（Bitmap)
        bg.load(canvas,cameraRect);
        //カメラが写しているステージを描画
        draw(canvas);
    }
   
    public void move(int userCtrl){
        this.userCtrl = userCtrl;
        
        switch (this.userCtrl){
            case Util.UP:
                moveUp();
                break;
            case Util.LEFT:
                moveLeft();
                break;
            case Util.DOWN:
                moveDown();
                break;
            case Util.RIGHT:
                moveRight();
                break;
        }
    }
    void moveLeft(){
        cameraRect.offset(-speed,0);
        bg.offset(cameraRect, -speed, 0);
    }
    void moveRight(){
        cameraRect.offset(speed,0);
        bg.offset(cameraRect,speed,0);
    }
    void moveUp(){
        cameraRect.offset(0,-speed);
        bg.offset(cameraRect, 0, -speed);
    }
    void moveDown(){
        cameraRect.offset(0,speed);
        bg.offset(cameraRect,0,speed);
    }
    //描画処理
    public void draw(Canvas canvas){
        canvas.drawBitmap(bg.bmp,bg.srcRect,env.stageRect,paint);
    }
    public void close(){
        bg.close();
    }
}

