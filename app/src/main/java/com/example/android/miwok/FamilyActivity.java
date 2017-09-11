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

        words.add(new Word("Father", "әpә", R.drawable.family_father));
        words.add(new Word("Mother", "әṭa", R.drawable.family_mother));
        words.add(new Word("Son", "Angsi", R.drawable.family_son));
        words.add(new Word("Daughter", "Tune", R.drawable.family_daughter));
        words.add(new Word("Older Brother", "Taachi", R.drawable.family_older_brother));
        words.add(new Word("Younger Brother", "Chalitti", R.drawable.family_younger_brother));
        words.add(new Word("Older Sister", "Teṭe", R.drawable.family_older_sister));
        words.add(new Word("Younger Sister", "Kolliti", R.drawable.family_younger_sister));
        words.add(new Word("Grandmother", "Ama", R.drawable.family_grandmother));
        words.add(new Word("Grandfather", "Paapa", R.drawable.family_grandfather));


        WordAdapter adapter = new WordAdapter(FamilyActivity.this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
