package com.tddc73.lab1.lab2components;

import android.support.annotation.ColorRes;

import com.tddc73.lab1.R;

/**
 * Created by Andreas on 11/8/2017.
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

    public void setActivatedColor(boolean isActive){
        if(isActive){
            color = R.color.activatedChildColor;
        } else {
            color = android.R.color.transparent;
        }
    }
}
