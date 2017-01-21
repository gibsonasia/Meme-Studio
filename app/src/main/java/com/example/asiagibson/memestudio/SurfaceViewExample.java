package com.example.asiagibson.memestudio;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by asiagibson on 1/16/17.
 */
//
//public class SurfaceViewExample extends Activity implements View.OnTouchListener {
//    OurView view;
//    Bitmap ball;
//    float x, y;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        view = new OurView(this);
//        view.setOnTouchListener(this);
//        ball = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
//        x = y = 0;
//        setContentView(view);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        view.pause();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        view.resume();
//    }
//
//
//    private class OurView extends SurfaceView implements Runnable {
//        Thread thread = null;
//        SurfaceHolder holder;
//        boolean isItOk = false;
//
//        public OurView(Context context) {
//            super(context);
//            holder = getHolder();
//        }
//
//
//        public void run() {
//            while (isItOk == true) {
//                //draw
//                if(!holder.getSurface().isValid()){
//                  continue;
//                }
//                Canvas canvas = holder.lockCanvas();
//                canvas.drawARGB(255,150,150,10);
//                canvas.drawBitmap(ball,x -(ball.getWidth()/2) ,y -(ball.getHeight()/2),null);
//                holder.unlockCanvasAndPost(canvas);
//
//
//            }
//        }
//
//        public void pause() {
//            isItOk = false;
//            while (true) {
//                try {
//                    thread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//
//                }
//                break;
//            }
//            thread = null;
//        }
//
//        public void resume() {
//            isItOk = true;
//            thread = new Thread(this);
//            thread.start();
//        }
//    }
//
//    @Override
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        return false;
//    }
//}
