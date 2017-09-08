package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Create a list of Word class objects
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("Father", "әpә"));
        words.add(new Word("Mother", "әṭa"));
        words.add(new Word("Son", "Angsi"));
        words.add(new Word("Daughter", "Tune"));
        words.add(new Word("Older Brother", "Taachi"));
        words.add(new Word("Younger Brother", "Chalitti"));
        words.add(new Word("Older Sister", "Teṭe"));
        words.add(new Word("Younger Sister", "Kolliti"));
        words.add(new Word("Grandmother", "Ama"));
        words.add(new Word("Grandfather", "Paapa"));


        WordAdapter adapter = new WordAdapter(FamilyActivity.this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
