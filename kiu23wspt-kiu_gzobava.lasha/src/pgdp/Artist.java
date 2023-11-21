package pgdp;

public class Artist {
// attributes
    private String firstName;
    private String lastName;
    private int birthYear;
    private Album[] albums;
    private Song[] singles;

// Constructor
    public Artist(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }
// Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }

    public Song[] getSingles() {
        return singles;
    }

    public void setSingles(Song[] singles) {
        this.singles = singles;
    }

// This method will return the most liked song of the artist.
public Song mostLikedSong() {
    Song mostLiked = null;

    // Check and find the most liked song in singles
    for (int i = 0; i < singles.length; i++) {
        Song single = singles[i];
        if (mostLiked == null || single.getLikes() > mostLiked.getLikes()) {
            mostLiked = single;
        }
    }

    // Check and find the most liked song on each album
    for (int i = 0; i < albums.length; i++) {
        Album album = albums[i];
        Song[] songs = album.getSongs();
        for (int j = 0; j < songs.length; j++) {
            Song song = songs[j];
            if (mostLiked == null || song.getLikes() > mostLiked.getLikes()) {
                mostLiked = song;
            }
        }
    }
    return mostLiked;
}

// This method return least liked songs
Song leastLikedSong(){
    Song leastLiked = null;

    // Check and find the least liked song in singles
    for (int i = 0; i < singles.length; i++) {
        Song single = singles[i];
        if (leastLiked == null || single.getLikes() < leastLiked.getLikes()) {
            leastLiked = single;
        }
    }

    // Check and find the least liked song on each album
    for (int i = 0; i < albums.length; i++) {
        Album album = albums[i];
        for (Song song : album.getSongs()) {
            if (leastLiked == null || song.getLikes() < leastLiked.getLikes()) {
                leastLiked = song;
            }
        }
    }
    return leastLiked;
}

// This method returns the total number of likes for this artist
    int totalLikes(){
        int likes = 0;
        for (int i = 0; i < singles.length; i++) {
            likes += singles[i].getLikes();

        }
        for (int i = 0; i < albums.length; i++) {
            Album album = albums[i];
            Song[] songs = album.getSongs();
            for (int j = 0; j < songs.length; j++) {
                Song song = songs[j];
                likes += song.getLikes();
            }
        }
return likes;
    }

// This method compares two artists.2 Artist objects are considered to be the same, if they have the same first name, last name and birth year.
public boolean isEqual(Artist other) {
    return this.firstName.equals(other.firstName) &&
            this.lastName.equals(other.lastName) &&
            this.birthYear == other.birthYear;
}



}
