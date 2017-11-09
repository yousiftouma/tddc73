package com.tddc73.lab1.lab3components;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by Andreas on 2017-11-09.
 */

public class InteractiveSearcher extends AppCompatEditText {

    public InteractiveSearcher(Context context) {
        super(context);
    }

    private void changeText(String newText){
        this.setText(null);
        this.append(newText);
    }
    

}
