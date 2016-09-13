public class CD {
  private String mGenre;
  private String mArtist;
  private String mTitle;
  private int mYear;

  public CD (String genre, String artist, String title, int year){
    mGenre = genre;
    mArtist = artist;
    mTitle = title;
    mYear = year;
  }
  public String getGenre() {
    return mGenre;
  }
  public String getArtist() {
    return mArtist;
  }
  public String getTitle() {
    return mTitle;
  }
  public int getYear() {
    return mYear;
  }
}
