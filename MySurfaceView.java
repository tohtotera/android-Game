package com.mycompany.myapp;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.util.*;
import android.view.*;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    //追加
    MainLooper looper;
    //ステージを管理するクラス
    Stage stage;
    //コントローラを管理するクラス
    Ctrl ctrl;
    //背景画像
    Drawable gameBg;
    Callback callback;
  
    
    public MySurfaceView(Context context,AttributeSet attrs){
        super(context,attrs);
        //コールバックに登録
        getHolder().addCallback(this);
    }
    public void surfaceChanged(SurfaceHolder holder,int pf,int w,int h){
        //環境依存値を作成
        Env env = Env.cook(w,h);
        //背景画像の描画
        gameBg = getResources().getDrawable(R.drawable.game_bg);
        gameBg.setBounds(0,0,w,h);
        callback.callback(env);
    }
    //初期表示
    void load(Env env){
        stage = new Stage(env);
        ctrl = new Ctrl(env);
        //Canvasオブジェクトを取得
        Canvas canvas = getHolder().lockCanvas();
        //各種初期表示
        gameBg.draw(canvas);
        stage.load(canvas);
        ctrl.load();
        //Canvasオブジェクトを開放
        getHolder().unlockCanvasAndPost(canvas);
        //メインループを実行
        looper = new MainLooper();
        new Thread(looper).start();
    }
    public void surfaceCreated(SurfaceHolder holder){}
    
    //SurfaceView終了時（メインループ停止処理）
    public void surfaceDestroyed(SurfaceHolder holder){
        //追加
        looper.isRunning = false;
        //リソース開放
        stage.close();
        //別スレッドが終了するまで待機
        Util.sleep(1000);
    }
    
    interface Callback{
        void callback(Env env);
    }
    //ゲームのループ処理を実行
    class MainLooper implements Runnable{
        //ゲーム中実行フラグ
        boolean isRunning;
        
        public void run(){
            isRunning = true;
            
            //メインループ処理
            while (isRunning){
                mainloop();
                Util.sleep(300);
            }
        }
        //繰り返し実行する処理
        void mainloop(){
            if (!isRunning){
                return;
            }
            Canvas canvas = getHolder().lockCanvas();
            //Try-Finally
            try{
    
                if (canvas != null && isRunning){
                    //ユーザ操作内容を取得
                    int userCommand = ctrl.getUserCtrl();
                    //移動処理
                    stage.move(userCommand);
                    //描画処理
                    gameBg.draw(canvas);
                    stage.draw(canvas);
                    stage.onPost();
                }
            }finally{
                //Canvasオブジェクトを開放
                if (canvas != null){
                    getHolder().unlockCanvasAndPost(canvas);
                }
            }
            //Canvasオブジェクトを開放
            if (isRunning){
                getHolder().unlockCanvasAndPost(canvas);
            }
        }
    }
}
