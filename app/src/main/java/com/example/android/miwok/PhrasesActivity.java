package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Create a list of Word class objects
        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("Where are you going?", "Minto wuksus", R.raw.phrase_where_are_you_going, true));
        words.add(new Word("What is your name?", "Tinnә oyaase'nә", R.raw.phrase_what_is_your_name, true));
        words.add(new Word("My name is...", "Oyaaset...", R.raw.phrase_my_name_is, true));
        words.add(new Word("How are you feeling?", "Michәksәs?", R.raw.phrase_how_are_you_feeling, true));
        words.add(new Word("I'm feeling good.", "Kuchi achit", R.raw.phrase_im_feeling_good, true));
        words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming, true));
        words.add(new Word("Yes' I'm coming.", "Hәә’ әәnәm", R.raw.phrase_yes_im_coming, true));
        words.add(new Word("I'm coming.", "әәnәm", R.raw.phrase_im_coming, true));
        words.add(new Word("Let's go.", "Yoowutis", R.raw.phrase_lets_go, true));
        words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here, true));


        WordAdapter adapter = new WordAdapter(PhrasesActivity.this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {

                if (words.get(position).hasSound()) {

                    releaseMediaPlayer();
                    Log.v("Numbers Activity", "Current word: " + words.get(position));

                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.get(position).getmSoundSrcID());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);

                } else {
                    Toast.makeText(PhrasesActivity.this, "No sound provided", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
