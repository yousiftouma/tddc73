package com.tddc73.lab1;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.tddc73.lab1.lab2components.ExpandableListViewChildNode;
import com.tddc73.lab1.lab2components.ExpandableListViewParentNode;
import com.tddc73.lab1.lab2components.MyExpandableListViewAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lab2 extends AppCompatActivity {

    private List<ExpandableListViewParentNode> parents;
    private ExpandableListView listView;
    private MyExpandableListViewAdapter listViewAdapter;
    private EditText editText;
    private TextWatcher tw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab2);
        listView = findViewById(R.id.expandList);
        editText = findViewById(R.id.editText5);
        populateExpandableList();

        listViewAdapter = new MyExpandableListViewAdapter(this, parents);
        listView.setAdapter(listViewAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return onExpandableListChildClick(parent, v, groupPosition, childPosition, id);
            }
        });

        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int parentId) {
                onExpandListParentClick(parentId);
            }
        });

        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int parentId) {
                onCollapseListParentClick();
            }
        });
        tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                handleEditText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        editText.addTextChangedListener(tw);

    }

    private void handleEditText(String currentText) {

        if (foundStartsWith(currentText)){
            String[] split = currentText.split("/");
            if(split.length > 1){
                for(ExpandableListViewParentNode parent : parents){
                    if(parent.getName().equals(split[1])){
                        int indexOfParent = parents.indexOf(parent);
                        if (!listView.isGroupExpanded(indexOfParent)){
                            listView.expandGroup(indexOfParent);
                        }
                    }

                    for (ExpandableListViewChildNode child : parent.getChildren()){
                        if(split.length > 2 && child.getName().equals(split[2])){
                            colorIfActivatedChild(child);
                            break;
                        }
                    }
                }
            }
            editText.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            editText.setError(null);
        } else {
            colorIfActivatedChild(null);
            editText.setError("Invalid path!");
            editText.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        }

        listViewAdapter.notifyDataSetChanged();
    }

    private void colorIfActivatedChild(ExpandableListViewChildNode toColor){
        for (ExpandableListViewParentNode parent : parents){
            for (ExpandableListViewChildNode child : parent.getChildren()) {
                child.setActivatedColor(false);
            }
        }

        if(toColor == null) return;

        toColor.setActivatedColor(true);
    }

    private boolean foundStartsWith(String toMatch){

        for (ExpandableListViewParentNode parent : parents){
            for (ExpandableListViewChildNode childName : parent.getChildren()){
                String path = "/" + parent.getName() + "/" + childName.getName();
                if(path.startsWith(toMatch)){
                    return true;
                }
            }
        }
        return false;
    }

    private void onCollapseListParentClick() {
        setSearchText("/");
    }

    private void onExpandListParentClick(int parentId) {
        ExpandableListViewParentNode parentNode = parents.get(parentId);
        String parentString = parentNode.getName();
        setSearchText("/" + parentString + "/");
    }

    private boolean onExpandableListChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        ExpandableListViewParentNode parentNode = parents.get(groupPosition);
        String parentString = parentNode.getName();
        String childString = parentNode.getChild(childPosition).getName();
        colorIfActivatedChild(parentNode.getChild(childPosition));
        listViewAdapter.notifyDataSetChanged();
        setSearchText("/" + parentString + "/" + childString);
        return true;
    }

    private void setSearchText(String text){
        editText.removeTextChangedListener(tw);
        editText.setText(null);
        editText.append(text);
        editText.addTextChangedListener(tw);
    }

    private void populateExpandableList() {
        parents = new ArrayList<>();

        ExpandableListViewParentNode b = new ExpandableListViewParentNode("Animals");
        ExpandableListViewParentNode b1 = new ExpandableListViewParentNode("Animals");
        ExpandableListViewParentNode b2 = new ExpandableListViewParentNode("Pillows");

        b.addChild("Cat");
        b.addChild("Cat");
        b.addChild("Horse");

        b1.addChild("Chocolate");
        b1.addChild("Jam");
        b1.addChild("Vanilla");

        b2.addChild("Soft");
        b2.addChild("Hard");
        b2.addChild("Batman");

        parents.add(b);
        parents.add(b1);
        parents.add(b2);
    }
}
