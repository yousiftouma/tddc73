package com.tddc73.lab1.lab2components;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yousif Touma on 2017-11-07.
 */

public class ExpandableListViewParentNode {

    private List<String> children;
    private String name;

    public ExpandableListViewParentNode(String name) {
        this.children = new ArrayList<>();
        this.name = name;
    }

    public void addChild(String child){
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public String getChild(int index){
        return children.get(index);
    }

    public List<String> getChildren() {
        return children;
    }
}
