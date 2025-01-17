package com.tddc73.lab1.lab2components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import com.tddc73.lab1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Takes some data representation of a list or expandablelist hierarchy and visualizes it in a view.
 * The layer between data and representation.
 * */

public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<ExpandableListViewParentNode> parents;


    public MyExpandableListViewAdapter(Context context, List<ExpandableListViewParentNode> parents) {
        this.context = context;
        this.parents = parents;

    }

    @Override
    public int getGroupCount() {
        return parents.size();
    }

    @Override
    public int getChildrenCount(int parentId) {
        return parents.get(parentId).getChildren().size();
    }

    @Override
    public Object getGroup(int parentId) {
        return parents.get(parentId);
    }

    @Override
    public Object getChild(int parentId, int childId) {
        return parents.get(parentId).getChild(childId);
    }

    @Override
    public long getGroupId(int parentId) {
        return parentId;
    }

    @Override
    public long getChildId(int parentId, int childId) {
        return childId;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /***
     * Defines how a group node is displayed in the list. Inflates an xml
     * to the view if the view is null, otherwise reuses the same view.
     *
     * If the function OnDataSetChanged() is called, this will be called to redraw all nodes.
     * @param parentId
     * @param b
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getGroupView(int parentId, boolean b, View view, ViewGroup viewGroup) {
        final ExpandableListViewParentNode group = (ExpandableListViewParentNode) getGroup(parentId);
        final String listTitle = group.getName();
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.expandable_list_group, null);
        }
        TextView listTitleTextView = view.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return view;
    }

    /***
     * Defines how a child is displayed in the list. Inflates an xml
     * to the view if the view is null, otherwise reuses the same view.
     *
     * If the function OnDataSetChanged() is called, this will be called to redraw all nodes.
     * @param parentId
     * @param childId
     * @param b
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getChildView(int parentId, int childId, boolean b, View view, ViewGroup viewGroup) {
        final ExpandableListViewChildNode expandedListText = (ExpandableListViewChildNode) getChild(parentId, childId);
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.expandable_list_item, null);
        }
        TextView expandedListTextView = view.findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText.getName());
        expandedListTextView.setBackgroundResource(expandedListText.getColor());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

}
