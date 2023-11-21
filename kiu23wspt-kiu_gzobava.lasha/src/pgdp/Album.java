package pgdp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Album {

    //attributes
    private  String title;
    private  int releaseYear;
    private Song[] songs;
    private int numberOfSongs;


    //constructor


    //getter methods
    public String getTitle() {
        return this.title;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public Song[] getSongs() {return this.songs;}

    public Album(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }


//method to add songs
int addSongs(Song[] songs){
        if (this.songs == null){
            this.songs = songs;
            return songs.length;
        }
        int count = 0;
        ArrayList<Song> songsList = new ArrayList<>(Arrays.asList(songs));

    for (int i = 0; i < songs.length; i++) {
        Song song = songs[i];

        if (!songsList.contains(song)){
            songsList.add(song);
            count++;
        }
    }
        this.songs = songsList.toArray(new Song[0]);
        return count;

}

//method to return songs in random order;
Song[] shuffle() {
    Song[] shuffledCopy = this.songs.clone();
    Random random = new Random();

    for (int i = shuffledCopy.length - 1; i > 0; i--) {
        int x = random.nextInt(i + 1);

        Song temp = shuffledCopy[x];
        shuffledCopy[x] = shuffledCopy[i];
        shuffledCopy[i] = temp;
    }
    return shuffledCopy;
}

// This method returns the songs sorted by the lexicographical comparison of song title. And by descending order  if isAscending is false.
// I use Selection Sort here

    Song[] sortByTitle(boolean isAscending){
        if (isAscending){

            for (int i = 0; i < songs.length; i++) {
                for (int j = i+1; j < songs.length; j++) {

                    if (songs[i].toString().compareTo(songs[j].toString()) > 0){
                        Song temp = songs[i];
                        songs[i] = songs[j];
                        songs[j] = temp;
                    }
                }
            }
        }
        if (!isAscending){
            for (int i = 0; i < songs.length; i++) {
                for (int j = i+1; j < songs.length; j++) {

                    if (songs[i].getTitle().compareTo(songs[j].getTitle()) < 0){
                        Song temp = songs[i];
                        songs[i] = songs[j];
                        songs[j] = temp;
                    }
                }
            }
        }
        return songs;}

// This method returns the songs sorted by the comparison of song Durations.If isAscending is false, return the songs in descending order.
// I use Bubble Sort here

    Song[] sortByDuration(boolean isAscending){
        if (isAscending) {

        for (int i = 0; i < songs.length - 1; i++) {
            for (int j = 0; j < songs.length - i - 1; j++) {
                if (songs[j].getDuration() > songs[j + 1].getDuration()){
                    Song temp = songs[j];
                    songs[j] = songs[j + 1];
                    songs[j + 1] = temp;

                }
            }
          }
        }

        if (!isAscending){
            for (int i = 0; i < songs.length - 1; i++) {
                for (int j = 0; j < songs.length - i - 1; j++) {
                    if (songs[j].getDuration() < songs[j + 1].getDuration()){
                        Song temp = songs[j];
                        songs[j] = songs[j + 1];
                        songs[j + 1] = temp;

                    }
                }
            }
        }
        return songs;
    }

// This method  returns the songs sorted by the comparison of song release years. if isAscending is false, return the songs in descending order.
// I use Insertion Sort here
      Song[] sortByReleaseYear(boolean isAscending){
        if (isAscending){
            for (int i = 1; i < songs.length; i++) {
                Song temp = songs[i];
                int j = i - 1 ;
                while (j >= 0 && songs[j].getReleaseYear() > temp.getReleaseYear()){
                    songs[j + 1] = songs[j];
                    j--;
                }
                songs[j + 1] = temp;

            }
        }
        if (!isAscending){
            for (int i = 1; i < songs.length; i++) {
                Song temp = songs[i];
                int j = i - 1 ;
                while (j >= 0 && songs[j].getReleaseYear() < temp.getReleaseYear()){
                    songs[j + 1] = songs[j];
                    j--;
                }
                songs[j + 1] = temp;

            }
        }
        return songs;
      }

// This method  returns the songs sorted by the comparison of popularity(likes). if isAscending is false, return the songs in descending order.

Song[] sortByPopularity(boolean isAscending){
        if (isAscending){
mergeSort(songs);}
        if (!isAscending){
mergeSort(songs);
reverseArray(songs);
        }
        return songs;


}

// Merge Sort algorithm
private static void mergeSort(Song[] songs) {
        int length = songs.length;
        if (length <= 1) return;
        int middle = length / 2;
        Song[] leftArray = new Song[middle];
        Song[] rightArray = new Song[length - middle];
        for (int i = 0; i < length; i++) {
            if (i < middle) {
                leftArray[i] = songs[i];
            } else {
                rightArray[i - middle] = songs[i];
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, songs);
    }

private static void merge(Song[] leftArray, Song[] rightArray, Song[] songs){
        int leftLen = songs.length / 2;
        int rightLen = songs.length - leftLen;
        int i = 0; //for original array
        int l = 0; // for left array
        int r = 0; // for right array

    while (l < leftLen && r < rightLen){
        if (leftArray[l].getLikes() < rightArray[r].getLikes()){
            songs[i] = leftArray[l];
            i++;
            l++;
        }
        else {
            songs[i] = rightArray[r];
            i++;
            r++;
        }
    }
    while (l < leftLen){
        songs[i] = leftArray[l];
        i++;
        l++;
    }

    while (r < rightLen){
        songs[i] = rightArray[r];
        i++;
        r++;
    }

}
    private static void reverseArray(Song[] songs) {
        int left = 0;
        int right = songs.length - 1;
        while (left < right) {
            Song temp = songs[left];
            songs[left] = songs[right];
            songs[right] = temp;
            left++;
            right--;
        }

    }
}