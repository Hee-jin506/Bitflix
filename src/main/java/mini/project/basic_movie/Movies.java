package mini.project.basic_movie;

import java.util.List;
import mini.project.domain.Genre;
import mini.project.domain.Movie;

public class Movies {
  
  public static void addBasicMovies(List<Movie> movieList) {
    movieList.add(new Movie("어바웃 타임", Genre.로맨스));
    movieList.add(new Movie("이터널 선샤인", Genre.로맨스));
    movieList.add(new Movie("라라랜드", Genre.로맨스));
    movieList.add(new Movie("캐롤", Genre.로맨스));
    movieList.add(new Movie("타이타닉", Genre.로맨스));
    
    movieList.add(new Movie("다크나이트", Genre.액션));
    movieList.add(new Movie("아저씨", Genre.액션));
    movieList.add(new Movie("어벤져스", Genre.액션));
    movieList.add(new Movie("테이큰", Genre.액션));
    movieList.add(new Movie("매드맥스", Genre.액션));
    movieList.add(new Movie("블랙위도우", Genre.액션));
    
    movieList.add(new Movie("인어공주", Genre.가족));
    movieList.add(new Movie("토이스토리", Genre.가족));
    movieList.add(new Movie("마틸다", Genre.가족));
    movieList.add(new Movie("해피 피트", Genre.가족));
    movieList.add(new Movie("피터팬", Genre.가족));
    
    movieList.add(new Movie("주온", Genre.호러));
    movieList.add(new Movie("곤지암", Genre.호러));
    movieList.add(new Movie("미드소마", Genre.호러));
    movieList.add(new Movie("겟아웃", Genre.호러));
    movieList.add(new Movie("알포인트", Genre.호러));
  }

}
