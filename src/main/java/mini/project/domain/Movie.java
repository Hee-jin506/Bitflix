package mini.project.domain;

public class Movie {
  private String title;
  private Genre genre;
  private int viewCount;

  public Movie(String title, Genre genre) {
    this.title = title;
    this.genre = genre;
  }

  public Movie() {

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public static Movie valueOfCsv(String record) {
    String[] values = record.split(",");
    Movie movie = new Movie();
    movie.setTitle(values[0]);
    movie.setGenre(Genre.valueOf(values[1]));
    movie.setViewCount(Integer.parseInt(values[2]));
    return movie;
  }

  public String toCsvString() {
    return String.format("%s,%s,%d\n", getTitle(), getGenre(), getViewCount());
  }
}
