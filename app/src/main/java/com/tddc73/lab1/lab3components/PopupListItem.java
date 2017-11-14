package com.tddc73.lab1.lab3components;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


/**
 * A list item to display a string on a canvas
 */
public class PopupListItem {

    private Paint paint;
    private Paint textPaint;
    private String name;
    private Rect rect;
    private int left,top,right,bottom;

    /**
     * Instantiate a list item with its content and position
     * @param name String to display
     * @param left x coordinate of the box left side
     * @param top y coordinate of the box top
     * @param right x coordinate of the box right side
     * @param bottom y coordinate of the box bottom
     */
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

    /**
     * Draws this list item to the canvas by drawing a rectangle and text
     * @param canvas canvas to draw on
     */
    public void drawToCanvas(Canvas canvas){
        canvas.drawRect(rect, paint);

        float testTextSize = 48f;
        textPaint.setTextSize(testTextSize);
        Rect bounds = new Rect();
        textPaint.getTextBounds(name, 0, name.length(), bounds);
        textPaint.setTextSize(testTextSize * (rect.width() * 0.8f) / bounds.width());

        canvas.drawText(name, left + 10f, rect.centerY() + bounds.height()/2, textPaint);

    }

    /**
     * Checks whether given ooordinates is covered by this instance
     * @param x x coordinate
     * @param y y coordinate
     * @return true if instance covers given coordinates.
     */
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
