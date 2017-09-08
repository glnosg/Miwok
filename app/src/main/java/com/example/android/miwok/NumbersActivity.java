package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> numbersInEnglish = new ArrayList<>();

        numbersInEnglish.add("One");
        numbersInEnglish.add("Two");
        numbersInEnglish.add("Three");
        numbersInEnglish.add("Four");
        numbersInEnglish.add("Five");
        numbersInEnglish.add("Six");
        numbersInEnglish.add("Seven");
        numbersInEnglish.add("Eight");
        numbersInEnglish.add("Nine");
        numbersInEnglish.add("Ten");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(NumbersActivity.this,
                android.R.layout.simple_list_item_1, numbersInEnglish);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}
