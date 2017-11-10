package com.tddc73.lab1.lab3components;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


/**
 * Created by Andreas on 2017-11-10.
 */

public class PopupListItem {

    private Paint paint;
    private Paint textPaint;
    private String name;
    private Rect rect;
    private int left,top,right,bottom;

    public PopupListItem(String name, int left, int top, int right, int bottom) {
        this.name = name;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.rect = new Rect(left,top,right,bottom);

        paint = new Paint();
        paint.setColor(Color.WHITE);
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
    }

    public void drawToCanvas(Canvas g){
        g.drawRect(rect, paint);

        float testTextSize = 48f;
        textPaint.setTextSize(testTextSize);
        Rect bounds = new Rect();
        textPaint.getTextBounds(name, 0, name.length(), bounds);
        textPaint.setTextSize(testTextSize * (rect.width() * 0.8f) / bounds.width());

        g.drawText(name, left + 10f, rect.centerY() + bounds.height()/2, textPaint);

    }

    public boolean isWithinBounds(int x, int y){
        return rect.contains(x, y);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
