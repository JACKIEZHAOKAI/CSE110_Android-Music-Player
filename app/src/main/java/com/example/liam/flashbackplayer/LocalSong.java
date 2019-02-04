package com.example.liam.flashbackplayer;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;

import java.util.ArrayList;

/**
 * This is the class that set up the songs for you, it has song name, fileName, artist of the song
 * , albumname of the song.
 */
public class LocalSong implements Song {

    private String name;
    private String source;
    private String artist;
    private String albumName;
    private int length; //length in milliseconds

    private String id;
    private String playedBy;
    private String url;

    private int preference;
    private int ranking;

    /**
     * Constructor that pass all the songs info and store it to here and can be used after
     *
     * @param name      of the song
     * @param source    of the song
     * @param artist    of the song
     * @param length    of the song
     * @param albumName of the song
     */
    public LocalSong(String name, String source, String artist, int length, String albumName) {
        this.name = name;
        this.source = source;
        this.artist = artist;
        this.length = length;
        this.albumName = albumName;
        String normName = name;
        normName = normName.replaceAll("\\.", "\0");
        normName = normName.replaceAll("\\[", "\0");
        normName = normName.replaceAll("]", "\0");
        normName = normName.replaceAll("#", "\0");
        normName = normName.replaceAll("\\$", "\0");

        this.id = normName + "=" + albumName;

        this.preference = NEUTRAL;
        this.ranking = 0;
        this.playedBy = "";
    }

    public LocalSong(String name, String albumName, String id, String url) {
        this.name = name;
        this.albumName = albumName;
        this.id = id;
        this.url = url;
        this.source = null;
        this.ranking = 0;
        this.playedBy = "";
        this.preference = NEUTRAL;
    }

    /**
     * set the preferenct with the given int
     *
     * @param pref that want to set
     */
    @Override
    public void setPreference(int pref) {
        this.preference = pref;
    }

    /**
     * This can increase the ranking of the song by one
     */
    @Override
    public void increaseRanking() {
        this.ranking++;
    }

    /**
     * Return the songs ranking
     *
     * @return the ranking of the song that call this function
     */
    @Override
    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    /**
     * return the name of the song
     *
     * @return name of the song
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * return the file name of song
     *
     * @return file name of the song
     */
    @Override
    public String getSource() {
        return source;
    }

    /**
     * return the artist of the song
     *
     * @return artist of the song
     */
    @Override
    public String getArtist() {
        return artist;
    }

    /**
     * returnt the length of the song
     *
     * @return length of the song
     */
    @Override
    public int getLength() {
        return length;
    }

    /**
     * retunr the album name of the song
     *
     * @return album name of the song
     */
    @Override
    public String getAlbumName() {
        return albumName;
    }

    /**
     * Get the preference of the song
     *
     * @return song preference
     */
    @Override
    public int getPreference() {
        return preference;
    }

    /**
     * Change the preference of the song to the next possible kind
     */
    @Override
    public void changePreference() {
        switch (this.preference) {
            case (Song.DISLIKE):
                this.preference = Song.NEUTRAL;
                break;
            case (Song.NEUTRAL):
                this.preference = Song.FAVORITE;
                break;
            case (Song.FAVORITE):
                this.preference = Song.DISLIKE;
                break;
            default:
                break;
        }
    }

    @Override
    public void play(MediaPlayer mediaPlayer) {

    }

    @Override
    public int compareTo(@NonNull Object o) {
        Song other = (Song) o;
        return this.name.compareTo(other.getName());
    }

    public LocalSong() {
        // default constructor, just for testing
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(String playedBy) {
        this.playedBy = playedBy;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

