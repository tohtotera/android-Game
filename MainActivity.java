package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.SurfaceHolder.*;

public class MainActivity extends Activity implements MySurfaceView.Callback
{
    MySurfaceView surfaceView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        surfaceView=(MySurfaceView)findViewById(R.id.surfaceview);
        //コールバックインスタンスにthisを指定
        surfaceView.callback = this;
    }
    public void callback(Env env){
        //Activityに自分を指定
        env.activity = this;
        //カメラを設定
        env.camera = new Camera(env);
        //GameMapにGameMap1を指定
        env.gameMap = new GameMap1(env);
        env.gameMap.load();
        //SurfaceViewをロード（初期表示処理）
        surfaceView.load(env);
    }
}
