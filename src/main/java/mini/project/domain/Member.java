package mini.project.domain;

import mini.project.handler.MovieHandler;
import mini.project.util.ArrayList;
import mini.project.util.List;

public class Member {
  
  private static final int FEMALE = 0;
  private static final int MALE = 1;
  
  String name;
  int age;
  int gender;
  Genre favoriteGenre;
  List<Movie> toWatchList = new ArrayList<>();
  MovieHandler toWatchHandler = new MovieHandler(toWatchList);
  
  public MovieHandler getToWatchHandler() {
    return toWatchHandler;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getGender() {
    switch (gender) {
      case FEMALE:
        return "여성";
      default:
        return "남성";
    }
  }
  public void setGender(String gender) {
    switch (gender) {
      case "여성":
        this.gender = FEMALE;
        break;
      case "남성":
        this.gender = MALE;
        break;
    }
  }
  public Genre getFavoriteGenre() {
    return favoriteGenre;
  }
  public void setFavoriteGenre(Genre favoriteGenre) {
    this.favoriteGenre = favoriteGenre;
  }
  public List<Movie> getToWatchList() {
    return toWatchList;
  }
}