package pgdp;

import java.util.ArrayList;
import java.util.Arrays;

public class SpotiJy {
    private Artist[] artists;

    public SpotiJy() {
        this.artists = new Artist[0];
    }

    public Artist[] getArtists() {
        return artists;
    }

//This method adds Artist objects to the list, if they are not already in the list
    void addArtists(Artist[] artists){
        ArrayList<Artist> arrList = new ArrayList<>(Arrays.asList(this.artists));

        for (int i = 0; i < artists.length; i++) {
            Artist artist = artists[i];
            if (!arrList.contains(artist))
                arrList.add(artist);
        }
        this.artists = arrList.toArray(new Artist[0]);
        }

 //This method returns the array of the first name and the last name
 String [] getTopTrendingArtist(){
        Artist topArtist = null;

        Artist[] artist1 = this.artists;
     for (int i = 0; i < artist1.length; i++) {
         Artist artist = artist1[i];
         if (topArtist == null || artist.totalLikes() > topArtist.totalLikes()){
             topArtist = artist;
         }
     }
     return new String[] {topArtist.getFirstName(), topArtist.getLastName()};
 }


//Tis method returns the name of the album with the most total likes - sum of like of all songs in this album. It should compare all albums in all artists.
 String getTopTrendingAlbum(){
    Album topAlbum = null;
    int topAlbumLikes = 0;
    int baseAlbumLikes = 0;

     Artist[] artists1 = this.artists;
     for (int i = 0; i < artists1.length; i++) {
         Artist artist = artists1[i];
         Album[] albums = artist.getAlbums();
         for (int j = 0; j < artists.length; j++) {
             Album album = albums[j];
             Song[] songs = album.getSongs();

             for (int k = 0; k < albums.length; k++) {
                 Song song = songs[k];
                 baseAlbumLikes += song.getLikes();
             }


                 if (topAlbum == null || baseAlbumLikes > topAlbumLikes){
                     topAlbum = album;
                     topAlbumLikes = baseAlbumLikes;
                 }

         }
     }
     assert topAlbum != null;
     return topAlbum.getTitle();
 }

 // This method returns the name of the song with the most likes. It should consider all the songs in all artists albums or singles.
    String getTopTrendingSong(){
        Song x = null;
        Song y = null;

        Artist[] artists1 = this.artists;
        for (int i = 0; i < artists1.length; i++) {
            Artist artist = artists1[i];
            y = artist.mostLikedSong();

            if (x == null || y.getLikes() > x.getLikes())
                x = y;
        }

        return x.getTitle();
    }
}
