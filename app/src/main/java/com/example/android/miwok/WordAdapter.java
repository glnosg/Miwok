package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by pawel on 08.09.17.
 */

public class WordAdapter extends ArrayAdapter {

    private int mColorID;

   public WordAdapter(Context context, ArrayList objects, int colorID) {
       super(context, -1, objects);
       mColorID = colorID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View myView = convertView;

        if (myView == null) {
            myView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = (Word) getItem(position);

        TextView defaultTranslation = (TextView) myView.findViewById(R.id.list_item_text_bottom);
        defaultTranslation.setText(currentWord.getDefaultTranslation());

        TextView miwokTranslation = (TextView) myView.findViewById(R.id.list_item_text_top);
        miwokTranslation.setText(currentWord.getMiwokTranslation());

        ImageView itemImage = (ImageView) myView.findViewById(R.id.item_image);
        if (currentWord.hasImage()) {
            itemImage.setImageResource(currentWord.getImgSrcID());
        }
        else {
            itemImage.setVisibility(View.GONE);
        }

        View textContainer = myView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorID);
        textContainer.setBackgroundColor(color);

        return myView;
    }
}
