package com.tddc73.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.tddc73.lab1.lab2components.ExpandableListViewParentNode;
import com.tddc73.lab1.lab2components.MyExpandableListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lab2 extends AppCompatActivity {

    private List<ExpandableListViewParentNode> parents;
    private ExpandableListView listView;
    private MyExpandableListViewAdapter listViewAdapter;
    private EditText editText;

    private List<String> pathList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab2);
        listView = findViewById(R.id.expandList);
        editText = findViewById(R.id.editText5);
        populateExpandableList();

        listViewAdapter = new MyExpandableListViewAdapter(this, parents);
        pathList = listViewAdapter.getPathsList();
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

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                handleEditText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void handleEditText(String currentText) {
        System.out.println(foundStartsWith(currentText));
    }

    private boolean foundStartsWith(String toMatch){
        for(String path : pathList){
            if(path.startsWith(toMatch)){
                return true;
            }
        }
        return false;
    }

    private void onCollapseListParentClick() {
        editText.setText("/");
    }

    private void onExpandListParentClick(int parentId) {
        ExpandableListViewParentNode parentNode = parents.get(parentId);
        String parentString = parentNode.getName();
        editText.setText("/" + parentString + "/");

    }

    private boolean onExpandableListChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        ExpandableListViewParentNode parentNode = parents.get(groupPosition);
        String parentString = parentNode.getName();
        String childString = parentNode.getChild(childPosition);
        editText.setText("/" + parentString + "/" + childString);
        return true;
    }

    private void populateExpandableList() {
        parents = new ArrayList<>();

        ExpandableListViewParentNode b = new ExpandableListViewParentNode("b");
        ExpandableListViewParentNode b1 = new ExpandableListViewParentNode("b");
        b.addChild("c");
        b1.addChild("d");

        parents.add(b);
        parents.add(b1);
    }
}
