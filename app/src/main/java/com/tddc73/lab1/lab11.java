package com.tddc73.lab1;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

public class lab11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.lab11);
        
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        Button myButton = new Button(this);
        myButton.setText("Knapp");
        myButton.setLayoutParams(lp);

        EditText edit = new EditText(this);
        edit.setText("Text fält");
        edit.setLayoutParams(lp);

        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp2.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        RatingBar rb = new RatingBar(this);
        rb.setLayoutParams(lp2);

        RelativeLayout rl = new RelativeLayout(this);
        rl.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        rl.addView(rb);

        EditText edit2 = new EditText(this);
        edit2.setLayoutParams(lp3);

        LinearLayout myLayout = new LinearLayout(this);
        myLayout.setOrientation(LinearLayout.VERTICAL);
        myLayout.addView(myButton, 0);
        myLayout.addView(edit, 1);
        myLayout.addView(rl, 2);
        myLayout.addView(edit2, 3);
        setContentView(myLayout);
    }
}
