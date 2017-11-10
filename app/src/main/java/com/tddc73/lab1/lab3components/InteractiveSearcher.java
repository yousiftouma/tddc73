package com.tddc73.lab1.lab3components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas on 2017-11-09.
 */

public class InteractiveSearcher extends AppCompatEditText implements HttpAsyncTaskResponseHandler {

    private final static int ITEMS_TO_SHOW = 10;
    private final static int LIST_ITEM_WIDTH = 200;
    private final static int LIST_ITEM_HEIGHT = 125;
    private int searchId;
    private TextWatcher textWatcher;
    private PopupList popupList;

    public InteractiveSearcher(final Context context) {
        super(context);
        setWillNotDraw(false);
        this.popupList = new PopupList(context, this, LIST_ITEM_HEIGHT, LIST_ITEM_WIDTH);
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

    public void handleTouch(int x, int y) {
        String possibleItem = popupList.getListItemName(x, y);
        if (possibleItem != null){
            changeText(possibleItem);
        }
    }

    /**
     * Starts off an async task to get data
     * @param searchPhrase phrase to search for
     */
    private void handleOnTextChanged(String searchPhrase){
        if (searchPhrase.isEmpty()) return;
        String url =
                "http://getnames-getnames.a3c1.starter-us-west-1.openshiftapps.com/getnames" +
                        "/" + searchId + "/" + searchPhrase;
        new HttpAsyncTask(this).execute(url);
        searchId++;
    }

    private void changeText(String newText){
        this.setText(null);
        this.append(newText);
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
        List<PopupListItem> itemsList = new ArrayList<>();
        for (int i = 1; i < names.size() + 1; i++){
            Log.d("NAME", names.get(i-1));
            itemsList.add(new PopupListItem(names.get(i-1), 0, this.getHeight() + (LIST_ITEM_HEIGHT * (i-1)), LIST_ITEM_WIDTH, this.getHeight() + LIST_ITEM_HEIGHT*i));
        }
        this.popupList.setItems(itemsList);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        ((View)getParent()).invalidate();
        super.onDraw(canvas);
        Rect newRect = canvas.getClipBounds();
        newRect.inset(-1 * LIST_ITEM_WIDTH, -1 * LIST_ITEM_WIDTH * ITEMS_TO_SHOW);
        canvas.clipRect (newRect, Region.Op.REPLACE);

        this.popupList.draw(canvas);
    }
}
