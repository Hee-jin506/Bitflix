package mini.project.handler;

import mini.project.domain.Genre;
import mini.project.domain.Movie;
import mini.project.util.ArrayList;
import mini.project.util.Iterator;
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
    System.out.println("[영화 등록]");

    Movie Movie = new Movie();
    Movie.setTitle(Prompt.inputString("영화제목? "));
    Movie.setGenre(Prompt.inputGenre("장르? "));

    movieList.add(Movie);
  }

  public void list() {
    System.out.println("[영화 목록]");

    // 전체 목록을 조회할 때 `Iterator` 객체를 사용한다.
    // 만약 목록의 일부만 조회하면다면 인덱스를 직접 다루는 이전 방식을 사용해야 한다.
    Iterator<Movie> iterator = movieList.iterator();

    while (iterator.hasNext()) {
      Movie movie = iterator.next();
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n", movie.getTitle(), movie.getGenre(),
          movie.getViewCount());
    }

  }

  public void update() {
    System.out.println("[영화 변경]");
    String title = Prompt.inputString("제목? ");
    Movie movie = findByTitle(title);

    if (title == null) {
      System.out.println("해당 제목의 영화가 없습니다.");
      return;
    }

    Genre genre = Prompt.inputGenre(String.format("장르(%s)? ", movie.getGenre()));
    movie.setGenre(genre);
    System.out.println("영화를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[영화 삭제]");
    String title = Prompt.inputString("제목? ");
    int index = indexOf(title);

    if (index == -1) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("영화 삭제를 취소하였습니다.");
      return;
    }

    movieList.remove(index);
    System.out.println("영화를 삭제하였습니다.");
  }

  public Movie findByTitle(String title) {
    for (int i = 0; i < movieList.size(); i++) {
      Movie movie = movieList.get(i);
      if (movie.getTitle() == title) {
        return movie;
      }
    }
    return null;
  }

  public List<Movie> findByGenre(Genre genre) {
    List<Movie> genreList = new ArrayList<>();
    for (int i = 0; i < movieList.size(); i++) {
      Movie movie = movieList.get(i);
      if (movie.getGenre().equals(genre)) {
        genreList.add(movie);
      }
    }
    return genreList;
  }


  private int indexOf(String title) {
    for (int i = 0; i < movieList.size(); i++) {
      Movie movie = movieList.get(i);
      if (movie.getTitle() == title) {
        return i;
      }
    }
    return -1;
  }


  public void printGenre(Genre genre) {
    System.out.println("[장르 목록]");
    Iterator<Movie> iterator = findByGenre(genre).iterator();
    while (iterator.hasNext()) {
      Movie movie = iterator.next();
      System.out.printf("%d, %s\n", movie.getTitle(), movie.getGenre());
    }
  }

  public Movie[] sortViewCount() {
    Movie[] bestArr = (Movie[]) movieList.toArray();
    for (int i = 0; i < bestArr.length; i++) {
      for (int j = 0; j < bestArr.length - i - 1; j++) {
        if (bestArr[j].getViewCount() > bestArr[j + 1].getViewCount()) {
          Movie temp = bestArr[j];
          bestArr[j] = bestArr[j + 1];
          bestArr[j + 1] = temp;
        }
      }
    }
    return bestArr;
  }

  public void printBest() {
    System.out.println("[인기순 목록]");
    Movie[] movies = sortViewCount();
    for (Movie movie : movies) {
      System.out.printf("%d, %s\n", movie.getTitle(), movie.getGenre());
    }
  }
}
