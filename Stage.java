                                                                       package com.mycompany.myapp;
import android.graphics.*;

public class Stage extends App{
    
    public Stage(Env env){
        super(env);
    }
    public void load(Canvas canvas){
        camera().load(canvas);    
    }
    void move(int userCtrl){
        camera().move(userCtrl);
    }
    public void draw(Canvas canvas){
        camera().draw(canvas);
    }
    //１フレーム終了後に実行
    public void onPost(){
        
    }
    //リソースを開放
    public void close(){
        camera().close();
    }
}
