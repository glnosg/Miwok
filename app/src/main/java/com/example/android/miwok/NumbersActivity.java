package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Create a list of Word class objects
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("One", "Lutti"));
        words.add(new Word("Two", "Otiiko"));
        words.add(new Word("Three", "Tolookosu"));
        words.add(new Word("Four", "Oyyisa"));
        words.add(new Word("Five", "Massokka"));
        words.add(new Word("Six", "Temmokka"));
        words.add(new Word("Seven", "Kenekaku"));
        words.add(new Word("Eight", "Kawinta"));
        words.add(new Word("Nine", "Wo'e"));
        words.add(new Word("Ten", "Na'aacha"));


        WordAdapter adapter = new WordAdapter(NumbersActivity.this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
