package com.tddc73.lab1.lab3components;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.EditText;


/**
 * Created by Andreas on 2017-11-10.
 */

public class PopupListItem {

    private Paint paint;
    private Paint textPaint;
    private String name;

    public PopupListItem(String name) {
        this.name = name;
        paint = new Paint();
        paint.setColor(Color.WHITE);
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
    }

    public void drawToCanvas(Canvas g, int left, int top, int right, int bottom){

        Rect rect = new Rect(left, top, right, bottom);
        g.drawRect(rect, paint);

        float testTextSize = 48f;
        textPaint.setTextSize(testTextSize);
        Rect bounds = new Rect();
        textPaint.getTextBounds(name, 0, name.length(), bounds);
        textPaint.setTextSize(testTextSize * (rect.width() * 0.8f) / bounds.width());

        g.drawText(name, left + 10f, rect.centerY() + bounds.height()/2, textPaint);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
