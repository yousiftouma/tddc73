package com.tddc73.lab1.lab2components;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a parentnode in an ExpandableListView
 */

public class ExpandableListViewParentNode {

    private List<ExpandableListViewChildNode> children;

    private String name;

    public ExpandableListViewParentNode(String name) {
        this.children = new ArrayList<>();
        this.name = name;
    }

    public void addChild(String childName){
        children.add(new ExpandableListViewChildNode(childName));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExpandableListViewChildNode getChild(int index){
        return children.get(index);
    }

    public List<ExpandableListViewChildNode> getChildren() {
        return children;
    }
}
