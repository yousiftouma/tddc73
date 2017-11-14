package com.tddc73.lab1.lab3components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import java.util.List;

/**
 * A view to display strings in a list
 */
public class PopupList extends View {

    private List<PopupListItem> items;

    public PopupList(Context context) {
        super(context);
    }

    public void setItems(List<PopupListItem> items) {
        this.items = items;
    }

    /**
     * Gets the name of the item at given coordinates if we can find anything at those coordinates
     * @param clickX x coordinate
     * @param clickY y coordinate
     * @return the string name if we found anything, otherwise null
     */
    public String getListItemName(int clickX, int clickY) {
        if (this.items == null) return null;
        for (PopupListItem item : items) {
            if (item.isWithinBounds(clickX, clickY)){
                return item.getName();
            }
        }
        return null;
    }

    /**
     * Draws each list item to the canvas
     * @param canvas canvas to draw on
     */
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
