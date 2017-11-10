package com.tddc73.lab1.lab3components;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import java.util.List;

/**
 * Created by Andreas on 2017-11-09.
 */

public class InteractiveSearcher extends AppCompatEditText implements HttpAsyncTaskResponseHandler {

    private final static int ITEMS_TO_SHOW = 10;
    private int searchId;
    private TextWatcher textWatcher;

    public InteractiveSearcher(final Context context) {
        super(context);
        this.searchId = 0;
        this.textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                handleOnTextChanged(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
        this.addTextChangedListener(textWatcher);
    }

    /**
     * Starts off an async task to get data
     * @param searchPhrase phrase to search for
     */
    private void handleOnTextChanged(String searchPhrase){
        String url =
                "http://getnames-getnames.a3c1.starter-us-west-1.openshiftapps.com/getnames" +
                        "/" + searchId + "/" + searchPhrase;
        new HttpAsyncTask(this).execute(url);
        searchId++;
    }

    private void changeText(String newText){
        this.removeTextChangedListener(textWatcher);
        this.setText(null);
        this.append(newText);
        this.addTextChangedListener(textWatcher);
    }


    /**
     * Will handle result of async task when finished
     * @param response response from async task
     */
    @Override
    public void handleResponse(String response) {
        // do something with our response from api
        if (response == null) {
            Log.d("RESPONSE_HANDLER_TEST", "null");
            return;
        }
        Log.d("RESPONSE_HANDLER_TEST", response);
        List<String> names = JsonParser.parseJsonString(response, ITEMS_TO_SHOW);
        for (String name : names){
            Log.d("NAME", name);
        }
        // TODO parse and show response in view using ITEMS_TO_SHOW
    }
}
