package java_17.nested_classes.inner_classes.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;
    
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }
    
    public boolean addSong(String songTitle, double duration){
        Song song = new Song(songTitle, duration);
        if (this.songs.findSong(songTitle) == null) {
            this.songs.add(song);
            return true;
        } else {
            return false;
        }

    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        System.out.println("Maybe the error is addToPlaylist");
        System.out.println(trackNumber + ": " + playlist);
        if (trackNumber <= 0){
            System.out.println("trackNumber <= 0");
            return false;
        } else if (trackNumber - 1 >= this.songs.songs.size()){
            System.out.println("trackNumber >= this.songs.size()");
            return false;
        }
        Song songToAdd = this.songs.findSong(this.songs.songs.get(trackNumber - 1).getTitle());
        if (songToAdd != null) {
            playlist.add(songToAdd);
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        System.out.println("Maybe the error is addToPlaylist2");
        int trackNumber = this.songs.songs.indexOf(this.songs.findSong(title));
        return this.addToPlayList(trackNumber, playlist);
    }

    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song newSong) {
            if (newSong == null) {
                return false;
            }
            if (this.findSong(newSong.getTitle()) == null) {
                this.songs.add(newSong);
                return true;
            }
            return false;
        }

        private Song findSong(int trackNumber) {
            if (trackNumber > songs.size()) {
                return null;
            } 
            return this.songs.get(trackNumber);
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
    }
}
