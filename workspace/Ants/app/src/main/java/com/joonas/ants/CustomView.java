package com.joonas.ants;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CustomView extends View {

    public CustomView(Context context){
        super(context);
        setUpPaint();
    }

    private Paint drawPaint;
    private Canvas canvas;

    private void setUpPaint(){
        drawPaint = new Paint();
        drawPaint.setColor(Color.BLUE);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        DisplayMetrics  displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        this.canvas = canvas;
        for (int i = 0; i < 500; i++){
            canvas.drawCircle(i,500,25, drawPaint);

        }

    }
}
