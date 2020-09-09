package mini.project.handler;

import mini.project.domain.Movie;
import mini.project.util.ArrayList;
import mini.project.util.List;
import mini.project.util.Prompt;

public class MovieHandler {
  static List<Movie> movieList = new ArrayList<>();

  public void manage() {
    switch (Prompt.inputString("영화 추가\n영화 삭제\n 영화 수정\n영화 조회\n입력>(빈문자열:취소) ")) {
      case "영화 추가":
        add();
        break;
      case "영화 삭제":
        delete();
        break;
      case "영화 수정":
        update();
        break;
      case "영화 조회":
        list();
        break;
    }
  }

  public void add() {

  }

  public void list() {

  }

  public void update() {

  }

  public void delete() {

  }

  Movie findByName(String name) {
    return null;
  }

  int indexOf(String name) {
    return -1;
  }

  public void printGenre() {

  }

  public void printBest() {

  }
}
