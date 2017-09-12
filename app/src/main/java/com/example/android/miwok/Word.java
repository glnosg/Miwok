package com.example.android.miwok;

/**
 *  {@link Word} represents a vocabulary word that the user wants to learn.
 *  It contains a default translation and a Miwok translation for that word.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImgSrcID = NO_IMAGE_PROVIDED;
    private int mSoundSrcID = NO_SOUND_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;
    private static final int NO_SOUND_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     * @param defaultTranslation
     * @param miwokTranslation
     * @param imgOrSoundSrcID Source ID of image or sound (depending on flag value)
     * @param flag - false when image, true when sound
     */
    public Word(String defaultTranslation, String miwokTranslation, int imgOrSoundSrcID, boolean flag) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;

        if(flag) {
            mSoundSrcID = imgOrSoundSrcID;
        } else {
            mImgSrcID = imgOrSoundSrcID;
        }
    }

    public Word(String defaultTranslation, String miwokTranslation, int imgSrcID, int soundSrcID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImgSrcID = imgSrcID;
        mSoundSrcID = soundSrcID;
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

    public int getmSoundSrcID() {
        return mSoundSrcID;
    }

    public boolean hasSound() {
        return mSoundSrcID != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImgSrcID=" + mImgSrcID +
                ", mSoundSrcID=" + mSoundSrcID +
                '}';
    }
}
