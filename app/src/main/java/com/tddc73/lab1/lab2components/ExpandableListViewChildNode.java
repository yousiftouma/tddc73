package com.tddc73.lab1.lab2components;

import android.support.annotation.ColorRes;

import com.tddc73.lab1.R;

/**
 * Representation of a childnode in an ExpandableListView
 */

public class ExpandableListViewChildNode {

    private String name;

    private @ColorRes
    int color;

    public ExpandableListViewChildNode(String name) {
        this.name = name;
        setActivatedColor(false);
    }

    public String getName() {
        return name;
    }

    public @ColorRes int getColor() {
        return color;
    }

    public void setColor(@ColorRes int color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    /***
     * Sets the background color of a child based on if it's active or not.
     * @param isActive
     */
    public void setActivatedColor(boolean isActive){
        if(isActive){
            color = R.color.activatedChildColor;
        } else {
            color = android.R.color.transparent;
        }
    }
}
