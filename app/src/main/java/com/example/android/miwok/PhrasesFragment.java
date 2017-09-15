package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {

                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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


        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_phrases);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {

                if (words.get(position).hasSound()) {

                    releaseMediaPlayer();
                    Log.v("Numbers Activity", "Current word: " + words.get(position));

                    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        // We have audio focus now

                        // Create and setup the {@link MediaPlayer} for the audio resource
                        // associated with current word
                        mMediaPlayer = MediaPlayer.create(getActivity(),
                                words.get(position).getmSoundSrcID());

                        // Start the audio file
                        mMediaPlayer.start();

                        //Setup a listener on the media player, so that we can stop and release the
                        //media player once the sounds has finished playing
                        mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                    }

                } else {
                    Toast.makeText(getActivity(), "No sound provided", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources,
        // because we won't be playing any more sounds.
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
