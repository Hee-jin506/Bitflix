package mini.project.domain;

import mini.project.handler.MovieHandler;
import mini.project.util.ArrayList;
import mini.project.util.Iterator;
import mini.project.util.List;
import mini.project.util.Prompt;

public class Member {
  
  private static final int FEMALE = 0;
  private static final int MALE = 1;
  
  String name;
  int age;
  int gender;
  Genre favoriteGenre;
  List<Movie> toWatchList;
  
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
      case "남성":
        this.gender = MALE;
    }
  }
  public String getFavoriteGenre() {
    switch (member.getFavoriteGenre()) {
      case HORROR:
        return "Horror";
      case ACTION:
        return "Action";
      case FAMILY:
        return "Family";
      case ROMANCE:
        return "Romance";
    }
  }
  public void setFavoriteGenre(String favoriteGenre) {
    switch (favoriteGenre) {
      case "Horror":
        this.favoriteGenre = HORROR;
      case "Action":
        this.favoriteGenre = ACTION;
      case "Family":
        this.favoriteGenre = FAMILY;
      case "Romance":
        this.favoriteGenre = ROMANCE;
    }
  }
  public String getToWatchList() {
    StringBuilder toWatchList = new StringBuilder();
    Iterator<Movie> movieIterator = this.toWatchList.iterator();
    while (movieIterator.hasNext()) {
      Movie movie = movieIterator.next();
      if (toWatchList.length() > 0) {
        toWatchList.append(",");
      }
      toWatchList.append(movie);
    }
    return toWatchList.toString(); 
  }
  
//  public List<Movie> getToWatchList() {
//    return toWtachList;
//  }
  
//public String getToWatchList() {
//  return toWatchList().toString();
//}
  
  
  
  public void setToWatchList() {
    List<Movie> toWatchList = new ArrayList<>();
    // 영화 리스트 보여주는 화면 띄우기
    while (true) {
      String str = Prompt.inputString("찾으시는 영화의 제목을 입력하세요.(빈문자열: 넘어가기)");
      if (str.length() == 0) {
        break;
      }
      Movie movie = MovieHandler.findByTitle();
      if (movie == null) {
        System.out.println("찾으시는 영화가 없습니다. 다시 입력해주세요.");
      } else {
        toWatchList.add(movie);
      }
    }  
    this.toWatchList = toWatchList;
  }
  
}
