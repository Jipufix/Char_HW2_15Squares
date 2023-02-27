package com.example.charhw2_15squares;

import android.media.AudioAttributes;
import android.media.SoundPool;

public class SoundManager {
    static SoundPool soundPool;
    static int blip;
    static int complete;

    public SoundManager (PuzzleView view){
        //I honestly don't really know what a lot of this does, I just
        //followed the instructions on the Android Studio API for soundPool
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(2)//Allows both audio sources to be played at once
                .setAudioAttributes(audioAttributes)
                .build();

        blip = soundPool.load(view.getContext(), R.raw.blip, 1);
        complete = soundPool.load(view.getContext(), R.raw.complete, 1);
    }//ctor


    /**
     * Plays the sound given a loaded int
     *
     * @param sound The id number of the sound to be played
     */
    public void playSound(int sound) {
        soundPool.play(sound, 1, 1, 1, 0, 1f);
    }//playSound
}