package mini.project.handler;

import mini.project.domain.Genre;
import mini.project.domain.Member;
import mini.project.domain.Movie;
import mini.project.util.Iterator;
import mini.project.util.List;
import mini.project.util.Prompt;
import mini.project.util.Screen;

public class MemberHandler {
  List<Member> memberList;
  MovieHandler movieHandler;

  public MemberHandler(List<Member> memberList, MovieHandler movieHandler) {
    this.memberList = memberList;
    this.movieHandler = movieHandler;
  }

  public void manage() {

    
    switch (Prompt.inputString("입력>(빈문자열:취소) ")) {
      case "회원 추가":
        add();
        break;
      case "회원 삭제":
        delete();
        break;
      case "회원 수정":
        update();
        break;
      case "회원 조회":
        list();
        break;
    }
  }

  //
  // String name;
  // int age;
  // int gender;
  // List<Movie> favoriteGenre;
  // List<Movie> toWatchList;
  //
  public Member add() {
    System.out.println("[회원 등록]");

    Member member = new Member();
    member.setName(Prompt.inputString("이름? "));
    member.setID(Prompt.inputString("아이디? "));
    member.setPassword(Prompt.inputString("비밀번호? "));
    System.out.println("장르 : 로맨스, 액션, 가족, 호러");
    member.setFavoriteGenre(Prompt.inputGenre("좋아하는 장르? "));

    System.out.println("보고싶은 영화");

    while (true) {
      String str = Prompt.inputString("찾으시는 영화의 제목을 입력하세요.(빈문자열: 넘어가기)");
      if (str.length() == 0) {
        break;
      }
      Movie movie = movieHandler.findByTitle(str);
      if (movie == null) {
        System.out.println("찾으시는 영화가 없습니다. 다시 입력해주세요.");
      } else {
        member.getToWatchList().add(movie);
      }
    }
    memberList.add(member);
    return member;
  }

  public void list() {
    System.out.println("[회원 목록]");

    Iterator<Member> iterator = memberList.iterator();
    while (iterator.hasNext()) {
      Member member = iterator.next();
      Iterator<Movie> movieIterator = member.getToWatchList().iterator();
      StringBuilder movies = new StringBuilder();
      while (movieIterator.hasNext()) {
        Movie movie = movieIterator.next();
        if (movies.length() > 0)
          movies.append(",");
        movies.append(movie.getTitle());
      }

      System.out.printf("%s, %s, %s, %s\n", member.getName(), member.getID(),
          member.getFavoriteGenre().toString(), movies.toString());
    }
  }

  public void update() {
    System.out.println("[회원 변경]");
    String ID = Prompt.inputString("아이디? ");
    Member member = findByID(ID);

    if (member == null) {
      System.out.println("해당 아이디의 회원이 없습니다.");
      return;
    }
    String name = Prompt.inputString(String.format("이름(%s)? ", member.getName()));
    String password = Prompt.inputString(String.format("비밀번호(%s)? ", member.getPassword()));
    Genre newFavoriteGenre =
        Prompt.inputGenre(String.format("취향 장르(%s)? ", member.getFavoriteGenre().toString()));
    // toWatchList 변경어떻게 할겨

    String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.setName(name);
    member.setPassword(password);
    member.setFavoriteGenre(newFavoriteGenre);

    // toWatchList 어떻게 할겨

    System.out.println("회원 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    String ID = Prompt.inputString("아이디? ");
    int index = indexOf(ID);

    if (index == -1) {
      System.out.println("해당 아이디의 회원이 없습니다.");
      return;
    }

    String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    memberList.remove(index);
    System.out.println("회원을 삭제하였습니다.");

  }

  public Member findByID(String ID) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getID().equals(ID)) {
        return member;
      }
    }
    return null;
  }

  int indexOf(String ID) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getID().equals(ID)) {
        return i;
      }
    }
    return -1;
  }



  //
  public void printToWatchList(Member member) {
    Screen.logo("To Watch List");
    member.getToWatchHandler().list();
  }

  public void printHistory(Member member) throws InterruptedException {
    Screen.logo("HISTORY");
    member.getWatchedHandler().list();
  }

  public void watch(MovieHandler movieHandler, Member member) throws InterruptedException {
    Movie movie;

    while (true) {
      movie = movieHandler.findByTitle(Prompt.inputString("무슨 영화를 보시겠습니까 ? "));
      if (movie == null) {
        System.out.println("해당 제목의 영화를 찾지 못하였습니다.\n 다시 입력해주세요.");
      } else {
        break;
      }
    }
    Screen.getWatchScreen();
    System.out.print("영화가 시작합니다");
    for (int i = 0; i < 4; i++) {
      Thread.sleep(500);
      System.out.print(".");
    }
    System.out.println();


    System.out.print("영화를 보는 중");


    Screen.getMovieScreen(movie.getGenre());


    for (int i = 0; i < 5; i++) {
      Thread.sleep(500);
      System.out.print(".");
    }
    System.out.println();

    System.out.println("영화가 끝납니다..");

    if (member.getToWatchHandler().findByTitle(movie.getTitle()) != null) {
      member.getToWatchList().remove(member.getToWatchHandler().indexOf(movie.getTitle()));
    }

    movie.setViewCount(movie.getViewCount() + 1);

    member.getWatchedList().add(movie);

    generateFavoriteGenre(member);
  }

  public void generateFavoriteGenre(Member member) {
    int[] genreCount = new int[4];
    for (int i = 0; i < member.getWatchedList().size(); i++) {
      switch (member.getWatchedList().get(i).getGenre()) {
        case 로맨스:
          genreCount[0]++;
          break;
        case 액션:
          genreCount[1]++;
          break;
        case 호러:
          genreCount[2]++;
          break;
        case 가족:
          genreCount[3]++;
      }
    }
    int index = 0;
    int max = genreCount[0];
    for (int i = 0; i < genreCount.length; i++) {
      if (genreCount[i] > max) {
        max = genreCount[i];
        index = i;
      }
    }
    switch (index) {
      case 0:
        member.setFavoriteGenre(Genre.로맨스);
        break;
      case 1:
        member.setFavoriteGenre(Genre.액션);
        break;
      case 2:
        member.setFavoriteGenre(Genre.호러);
        break;
      case 3:
        member.setFavoriteGenre(Genre.가족);
    }
  }


  // 1) 여태 시청한 영화 개수 대비 장르를 계산해서 가장 비중이 높은 장르를 favorite으로 정한다.

  // 2) if (보고싶어요에 있는 영화면)

  // 3) 보고싶어요 리스트에 영화 삭제

  // 4) 영화 조회수 올리기

}
