package com.tddc73.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class lab12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.lab12);

        TableLayout.LayoutParams tableRowLayoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, 0);
        TableLayout.LayoutParams tableRowElementLayoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TableLayout contentTable = new TableLayout(this);
        contentTable.setLayoutParams(tableRowElementLayoutParams);
        contentTable.setMeasureWithLargestChildEnabled(true);
        contentTable.setColumnStretchable(1, true);

        TableRow nameRow = new TableRow(this);
        nameRow.setLayoutParams(tableRowLayoutParams);
        nameRow.setWeightSum(1f);

        TextView name = new TextView(this);
        name.setLayoutParams(tableRowElementLayoutParams);
        name.setMaxLines(1);
        name.setText("Namn");

        EditText setName = new EditText(this);
        setName.setLayoutParams(tableRowElementLayoutParams);
        setName.setEms(10);
        setName.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

        nameRow.addView(name, new TableRow.LayoutParams(0));
        nameRow.addView(setName, new TableRow.LayoutParams(1));

        TableRow passwordRow = new TableRow(this);
        passwordRow.setLayoutParams(tableRowLayoutParams);
        passwordRow.setWeightSum(1f);

        TextView password = new TextView(this);
        password.setLayoutParams(tableRowElementLayoutParams);
        password.setMaxLines(1);
        password.setText("Lösenord");

        EditText setPassword = new EditText(this);
        setPassword.setLayoutParams(tableRowElementLayoutParams);
        setPassword.setEms(10);
        setPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

        passwordRow.addView(password, new TableRow.LayoutParams(0));
        passwordRow.addView(setPassword, new TableRow.LayoutParams(1));

        TableRow emailRow = new TableRow(this);
        emailRow.setLayoutParams(tableRowLayoutParams);
        emailRow.setWeightSum(1f);

        TextView email = new TextView(this);
        email.setLayoutParams(tableRowElementLayoutParams);
        email.setMaxLines(1);
        email.setText("Epost");

        EditText setEmail = new EditText(this);
        setEmail.setLayoutParams(tableRowElementLayoutParams);
        setEmail.setEms(10);
        setEmail.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

        emailRow.addView(email, new TableRow.LayoutParams(0));
        emailRow.addView(setEmail, new TableRow.LayoutParams(1));

        TableRow ageRow = new TableRow(this);
        ageRow.setLayoutParams(tableRowLayoutParams);
        ageRow.setWeightSum(1f);
        ageRow.setGravity(Gravity.CENTER);

        TextView age = new TextView(this);
        age.setLayoutParams(tableRowElementLayoutParams);
        age.setMaxLines(1);
        age.setText("Ålder");

        SeekBar setAge = new SeekBar(this);
        setAge.setLayoutParams(tableRowElementLayoutParams);

        ageRow.addView(age, new TableRow.LayoutParams(0));
        ageRow.addView(setAge, new TableRow.LayoutParams(1));



        contentTable.addView(nameRow, 0);
        contentTable.addView(passwordRow, 1);
        contentTable.addView(emailRow, 2);
        contentTable.addView(ageRow, 3);
        setContentView(contentTable);
    }
}
