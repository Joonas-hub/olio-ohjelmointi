package com.joonas.ants;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class AnimatedView extends androidx.appcompat.widget.AppCompatImageView {

    private Context mContext;
    int x = -1;
    int y = -1;
    private int xVelocity = 10;
    private int yVelocity= 10;
    private Handler handler;
    private final long FRAME_RATE = 20;
    ArrayList<Ant> ants = new ArrayList();
    int antAmount = 5;
    Paint drawPaint;
    ArrayList<int[]> xyPoints= new ArrayList();
    int[] xyTemp = {0,0};
    Path path;



    public AnimatedView(Context context, AttributeSet attrs){
        super(context, attrs);
        mContext = context;
        handler = new Handler();

        setUpAnts();
        setUpPaint();
    }

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    @Override
    protected void onDraw(Canvas canvas){
        BitmapDrawable image = (BitmapDrawable) mContext.getResources().getDrawable(R.drawable.kuva);
        /*
        if (x < 0 && y < 0){
            x = this.getWidth()/2;
            y = this.getHeight()/2;
        }else{
            x += xVelocity;
            y += yVelocity;
            if((x > this.getWidth() - image.getBitmap().getWidth()) || (x < 0)){
                xVelocity = xVelocity * -1;
            }
            if((y > this.getHeight() - image.getBitmap().getHeight()) || (y < 0)){
                yVelocity = yVelocity * -1;
            }
        }
        */
        for (Ant i : ants){
            int[] array = i.getXY();
            x = array[0];
            y = array[1];
            //xyTemp[0] = x + image.getBitmap().getWidth()/2;
            //xyTemp[1] = y + image.getBitmap().getHeight()/2;
            //xyPoints.add(xyTemp);

            if((x > this.getWidth() - image.getBitmap().getWidth()) || (x < 0)){
                i.xCollision();

            }
            if((y > this.getHeight() - image.getBitmap().getHeight()) || (y < 0)){
                i.yCollision();
            }

            canvas.drawBitmap(image.getBitmap(),x,y,null);
            //canvas.drawCircle(x,y,5, drawPaint);
            //for (int[] j : xyPoints){
              //  canvas.drawCircle(j[0], j[1], 5, drawPaint);
            //}
            canvas.drawPath(path, drawPaint);
            path.moveTo(x+ image.getBitmap().getWidth()/2,y+ image.getBitmap().getHeight()/2);
            path.lineTo(x + image.getBitmap().getWidth()/2,y+ image.getBitmap().getHeight()/2);
            path.close();
        }

        handler.postDelayed(r, FRAME_RATE);
    }

    private void setUpPaint(){
        drawPaint = new Paint();
        drawPaint.setColor(Color.BLUE);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        path = new Path();

    }
    private void setUpAnts(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        for (int i = 0; i < antAmount; i++){
            ants.add(new Ant(screenWidth/2,screenHeight/2));
        }
    }
}
