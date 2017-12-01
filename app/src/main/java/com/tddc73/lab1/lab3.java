package com.tddc73.lab1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tddc73.lab1.lab3components.InteractiveSearcher;

public class lab3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab3);

//        LinearLayout ll = new LinearLayout(this);
//        ll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        ll.setOrientation(LinearLayout.VERTICAL);
//        ll.setBackgroundColor(Color.GRAY);
//
//        final InteractiveSearcher editText = new InteractiveSearcher(this);
//        editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        editText.setHint("Search");
//
//        // We need to be able to catch touch events outside of the InteractiveSearcher to be able
//        // to handle clicks on the list of names
//        ll.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                int x = (int)motionEvent.getX();
//                int y = (int)motionEvent.getY();
//                editText.handleTouch(x, y);
//                return false;
//            }
//        });
//
//        ll.addView(editText);
//        setContentView(ll);
    }
}
