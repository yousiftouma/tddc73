package com.tddc73.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class lab13 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab13);


        // LayoutParams

        LinearLayout.LayoutParams contentLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams innerContentLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //


        LinearLayout contentLayout = new LinearLayout(this);
        contentLayout.setOrientation(LinearLayout.VERTICAL);
        contentLayout.setLayoutParams(contentLayoutParams);

        // First
        TextView textOne = new TextView(this);
        textOne.setLayoutParams(contentLayoutParams);
        textOne.setGravity(Gravity.CENTER);
        textOne.setText("Hur trivs du på LiU");

        //Second
        LinearLayout innerContentLayoutOne = new LinearLayout(this);
        innerContentLayoutOne.setLayoutParams(innerContentLayoutParams);
        innerContentLayoutOne.setOrientation(LinearLayout.HORIZONTAL);

        CheckBox good = new CheckBox(this);
        good.setLayoutParams(innerContentLayoutParams);
        good.setText("Bra");

        CheckBox veryGood = new CheckBox(this);
        veryGood.setLayoutParams(innerContentLayoutParams);
        veryGood.setText("Mycket Bra");

        CheckBox supergood = new CheckBox(this);
        supergood.setLayoutParams(innerContentLayoutParams);
        supergood.setText("Jättebra");

        innerContentLayoutOne.addView(good);
        innerContentLayoutOne.addView(veryGood);
        innerContentLayoutOne.addView(supergood);

        //Third
        TextView textTwo = new TextView(this);
        textTwo.setLayoutParams(contentLayoutParams);
        textTwo.setGravity(Gravity.CENTER);
        textTwo.setText("Läser du på LiTH");

        //Fourth
        LinearLayout innerContentLayoutTwo = new LinearLayout(this);
        innerContentLayoutTwo.setLayoutParams(innerContentLayoutParams);
        innerContentLayoutTwo.setOrientation(LinearLayout.HORIZONTAL);

        CheckBox yesOne = new CheckBox(this);
        yesOne.setLayoutParams(innerContentLayoutParams);
        yesOne.setText("Ja");

        CheckBox noOne = new CheckBox(this);
        noOne.setLayoutParams(innerContentLayoutParams);
        noOne.setText("Nej");

        
    }
}
