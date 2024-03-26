package java_17.list_concepts;

import java.util.ArrayList;
import java.util.LinkedList;

public class ExerciseFortyFive {
    
    public static void main(String[] args) {
        Song song1 = new Song("Baby", 4.02);
        Song song2 = new Song("Child", 3.02);
        Song song3 = new Song("Adult", 2.32);

        System.out.println(song3.toString());

        Album album = new Album("Album", "Artist");
        album.addSong("Baby", 4.02);
        album.addSong("Child", 3.02);
        album.addSong("Adult", 2.32);

        for (Song song : album.songs) {
            System.out.println(song.getTitle());
        }

        LinkedList<Song> playlist = new LinkedList<>();

        album.addToPlayList("Baby", playlist);

        System.out.println(playlist);

        album.addToPlayList(2, playlist);

        System.out.println(playlist);

        album.addToPlayList(2, playlist);
        System.out.println(playlist);
        
    }
}

class Album {
    private String name;
    private String artist;
    public ArrayList<Song> songs;
    
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    
    public boolean addSong(String songTitle, double duration){
        Song song = new Song(songTitle, duration);
        if (this.findSong(songTitle) == null) {
            this.songs.add(song);
            return true;
        } else {
            return false;
        }

    }

    private Song findSong(String title) {
        // System.out.println(title + ": " + this.songs);
        for (Song song : this.songs) {
            if (song.getTitle() == title) {
                // System.out.println("Found song");
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        System.out.println("Maybe the error is addToPlaylist");
        System.out.println(trackNumber + ": " + playlist);
        if (trackNumber <= 0){
            System.out.println("trackNumber <= 0");
            return false;
        } else if (trackNumber - 1 >= this.songs.size()){
            System.out.println("trackNumber >= this.songs.size()");
            return false;
        }
        Song songToAdd = this.findSong(this.songs.get(trackNumber - 1).getTitle());
        if (songToAdd != null) {
            playlist.add(songToAdd);
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        System.out.println("Maybe the error is addToPlaylist2");
        int trackNumber = this.songs.indexOf(this.findSong(title));
        return this.addToPlayList(trackNumber, playlist);
    }
}

class Song {
    private String title;
    private double duration;
    
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    
    @Override
    public String toString() {
        return this.getTitle() + ": " + this.duration;
    }
}