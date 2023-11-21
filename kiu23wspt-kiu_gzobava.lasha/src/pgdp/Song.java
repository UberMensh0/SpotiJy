package pgdp;

public class Song {
    private String title;
    private int releaseYear;
    private int duration;
    private int likes;

    //getter methods
    public String getTitle(){
        return title;
    }

    public int getReleaseYear(){
        return releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public int getLikes() {
        return likes;
    }



    //constructors


    public Song(String title, int releaseYear, int duration, int likes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;
    }

    public Song(String title, int releaseYear, int duration) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = 0;
    }

    public Song(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = 60;
        this.likes = 0;
    }

    //setter methods

   public boolean changeDuration(int newDuration){
        if (newDuration < 0 || newDuration > 720 || newDuration == this.duration){
            return false;
        }

        this.duration = newDuration;
        return true;
   }

   public void like(){

        this.likes++;
   }

   public void unlike(){
        if (this.likes > 0){
            this.likes--;
        }
   }


   public String toString(){
       int durationInMinutes = this.duration / 60;
        return "Title:" + this.title + ",Duration:" + durationInMinutes + "minutes" + ",Release year:" + this.releaseYear +",Likes" + this.likes;
   }




}
