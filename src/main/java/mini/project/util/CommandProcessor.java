package mini.project.util;

import mini.project.basic_movie.Movies;
import mini.project.domain.Genre;
import mini.project.domain.Member;
import mini.project.domain.Movie;
import mini.project.handler.MemberHandler;
import mini.project.handler.MovieHandler;

public class CommandProcessor {
  public static List<Movie> movieList = new ArrayList<>();
  static {
    Movies.addBasicMovies(movieList);
  }
  public static MovieHandler movieHandler = new MovieHandler(movieList);
  public static List<Member> memberList = new ArrayList<>();
  public static MemberHandler memberHandler = new MemberHandler(memberList, movieHandler);
  public static Member loggedInMember;

  public static void isLoggedOut() throws InterruptedException {
    Screen.bitflixLogo();
    movieHandler.printBest();
    Screen.viewMenu(Screen.BEFORE_LOGIN_PAGE);
    switch (Prompt.inputString("명령> ")) {
      case "회원가입":
        memberHandler.add();
        break;
      case "로그인":
        loggedInMember = memberHandler.logIn();
        break;
      case "관리자":
        isManager();
        break;
      case "종료":
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);;
      default:
        System.out.println("잘못된 명령입니다.");
    }
  }


  static void isManager() {
    while (true) {
      Screen.viewMenu(Screen.MANAGER_PAGE);
      switch (Prompt.inputString("명령>(빈문자열: 뒤로가기) ")) {
        case "회원관리":
          memberHandler.manage();
          break;
        case "영화관리":
          Screen.viewMenu(Screen.MOVIE_MANAGE_PAGE);
          movieHandler.manage();
          break;
        case "종료":
          System.out.println("프로그램을 종료합니다.");
          System.exit(0);
        case "":
          return;
        default:
          System.out.println("잘못된 명령입니다.");
      }
    }
  }

  public static void isLoggedIn() throws InterruptedException {
    Screen.bitflixLogo();
    movieHandler.printGenre(loggedInMember.getFavoriteGenre());
    movieHandler.printBest();
    System.out.println(loggedInMember.getName() + "님 안녕하세요!");
    Screen.viewMenu(Screen.AFTER_LOGIN_PAGE);

    switch (Prompt.inputString("명령> ")) {
      case "로그아웃":
        if (Prompt.inputString("정말 로그아웃 하시겠습니까?(y/N)").equalsIgnoreCase("y"))
          loggedInMember = null;
        break;

      case "영화시청":
        loggedInMember.watch(movieHandler);
        break;
      case "보고싶어요":
        loggedInMember.printToWatchList();
        if (Prompt.inputString("영화를 보시겠습니까?(y/N)").equalsIgnoreCase("y")) {
          loggedInMember.watch(movieHandler);
        }
        break;
      case "장르별 더보기":
        Genre genre = Prompt.inputGenre("로맨스, 액션, 가족, 호러\n장르? ");
        movieHandler.printGenre(genre);
        if (Prompt.inputString("영화를 보시겠습니까?(y/N)").equalsIgnoreCase("y")) {
          loggedInMember.watch(movieHandler);
        }

        break;
      case "인기순 더보기":
        movieHandler.printBest();
        if (Prompt.inputString("영화를 보시겠습니까?(y/N)").equalsIgnoreCase("y")) {
          loggedInMember.watch(movieHandler);
        }
        break;
      case "다시보기":
        loggedInMember.printHistory();
        if (Prompt.inputString("영화를 보시겠습니까?(y/N)").equalsIgnoreCase("y")) {
          loggedInMember.watch(loggedInMember.getWatchedHandler());
        }
        break;
      case "종료":
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);;
      default:
        System.out.println("잘못된 명령입니다.");
    }
  }
}
