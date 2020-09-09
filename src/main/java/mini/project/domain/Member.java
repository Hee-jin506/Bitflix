package mini.project.domain;

import mini.project.handler.MovieHandler;
import mini.project.util.ArrayList;
import mini.project.util.List;
import mini.project.util.Stack;

public class Member {

  private static final int FEMALE = 0;
  private static final int MALE = 1;

  String name;
  String ID;
  String password;
  Genre favoriteGenre;
  List<Movie> toWatchList = new ArrayList<>();
  MovieHandler toWatchHandler = new MovieHandler(toWatchList);
  List<Movie> watchedList = new Stack<>();
  MovieHandler watchedHandler = new MovieHandler(watchedList);



  public MovieHandler getWatchedHandler() {
    return watchedHandler;
  }

  public List<Movie> getWatchedList() {
    return watchedList;
  }

  public MovieHandler getToWatchHandler() {
    return toWatchHandler;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
