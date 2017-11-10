package com.tddc73.lab1.lab3components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import java.util.List;

/**
 * Created by Yousif Touma on 2017-11-10.
 */

public class PopupList extends View {

    private List<PopupListItem> items;
    private View parent;
    private int itemHeight;
    private int itemWidth;

    public PopupList(Context context, View parent, int itemHeight, int itemWidth) {
        super(context);
        this.parent = parent;
        this.itemHeight = itemHeight;
        this.itemWidth = itemWidth;
    }

    public PopupList(Context context) {
        super(context);
    }

    public void setItems(List<PopupListItem> items) {
        this.items = items;
    }

    public String getListItemName(int clickX, int clickY) {
        if (this.items == null) return null;
        for (PopupListItem item : items) {
            if (item.isWithinBounds(clickX, clickY)){
                return item.getName();
            }
        }
        return null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.items == null) return;
        for (int i = 1; i <= items.size(); i++) {
            PopupListItem item = items.get(i-1);
            item.drawToCanvas(canvas);
        }
    }
}
