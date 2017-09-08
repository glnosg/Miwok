package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Create a list of Word class objects
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("Where are you going?", "Minto wuksus"));
        words.add(new Word("What is your name?", "Tinnә oyaase'nә"));
        words.add(new Word("My name is...", "Oyaaset..."));
        words.add(new Word("How are you feeling?", "Michәksәs?"));
        words.add(new Word("I'm feeling good.", "Kuchi achit"));
        words.add(new Word("Are you coming?", "әәnәs'aa?"));
        words.add(new Word("Yes' I'm coming.", "Hәә’ әәnәm"));
        words.add(new Word("I'm coming.", "әәnәm"));
        words.add(new Word("Let's go.", "Yoowutis"));
        words.add(new Word("Come here.", "әnni'nem"));


        WordAdapter adapter = new WordAdapter(PhrasesActivity.this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}
