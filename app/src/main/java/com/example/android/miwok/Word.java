package com.example.android.miwok;

/**
 *  {@link Word} represents a vocabulary word that the user wants to learn.
 *  It contains a default translation and a Miwok translation for that word.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImgSrcID = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imgSrcID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImgSrcID = imgSrcID;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImgSrcID() {
        return mImgSrcID;
    }

    public boolean hasImage() {
        return mImgSrcID != NO_IMAGE_PROVIDED;
    }
}
