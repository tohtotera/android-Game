package com.mycompany.myapp;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Ctrl extends App{
    //ユーザ操作
    int userCtrl = Util.CTRL_OUT;
    
    public Ctrl(Env env){
        super(env);
    }
    //初期処理
    public void load(){
        //インスタンスの取得
        LinearLayout ctrl = (LinearLayout)view(R.id.layout_ctrl);
        //コントローラーのサイズを指定
        ctrl.setLayoutParams(new LinearLayout.LayoutParams(env.ctrlSize,env.ctrlSize));
        //それぞれの操作を設定
        loadCtrl(R.id.btn_ctrl_up,Util.UP);
        loadCtrl(R.id.btn_ctrl_left,Util.LEFT);
        loadCtrl(R.id.btn_ctrl_down,Util.DOWN);
        loadCtrl(R.id.btn_ctrl_right,Util.RIGHT);
        loadCtrl(R.id.btn_ctrl_beam,Util.CTRL_BEAM);
        //インスタンス取得
        Button beam = (Button)view(R.id.btn_ctrl_beam);
        //ビームのサイズを指定
        beam.setLayoutParams(new LinearLayout.LayoutParams(env.ctrlSize,env.ctrlSize));
    }
    //コントローラの操作の処理を実装
    void loadCtrl(int id,final int value){
        Button btn = (Button)view(id);
        btn.setOnTouchListener(new OnTouchListener(){
                public boolean onTouch(View v,MotionEvent evt){
                    switch (evt.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            userCtrl = value;
                            break;
                        case MotionEvent.ACTION_UP:
                            userCtrl = Util.CTRL_OUT;
                            break;
                    }
                    return false;
                }
            });
        }
        //ユーザー操作を戻す
        int getUserCtrl(){
            return userCtrl;
        }
}


