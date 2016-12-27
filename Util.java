package com.mycompany.myapp;

public class Util
{
    static final int CTRL_OUT = -1;
    static final int UP = 0;
    static final int LEFT = 1;
    static final int DOWN = 2;
    static final int RIGHT = 3;
    static final int CTRL_BEAM = 10;
    
    static void sleep(int time){
        try{
            Thread.sleep(time);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
