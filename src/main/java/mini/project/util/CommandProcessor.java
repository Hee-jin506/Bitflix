package mini.project.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
import mini.project.domain.Genre;
import mini.project.domain.Member;
import mini.project.domain.Movie;
import mini.project.handler.MemberHandler;
import mini.project.handler.MovieHandler;

public class CommandProcessor {
  public static List<Movie> movieList = new ArrayList<>();
  public static MovieHandler movieHandler = new MovieHandler(movieList);
  public static List<Member> memberList = new ArrayList<>();
  public static MemberHandler memberHandler = new MemberHandler(memberList, movieHandler);
  public static Member loggedInMember;

  private static File movieFile = new File("./data/movie.csv");
  private static File memberFile = new File("./data/member.csv");

  public static void loadMembers() {
    FileReader in = null;
    Scanner dataScan = null;
    try {
      in = new FileReader(memberFile);
      dataScan = new Scanner(in);

      while (true) {
        try {
          String record = dataScan.nextLine();
         
          memberList.add(Member.valueOfCsv(record, movieHandler));

        } catch (NoSuchElementException e) {
          break;
        }
      }
      System.out.printf("회원 %d명을 로딩하였습니다!\n", memberList.size());
    } catch (IOException e) {
      System.out.println("회원 데이터를 로딩하는 중에 에러가 발생하였습니다...");
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }

    }
  }
  
  public static void loadMovies() {
    FileReader in = null;
    Scanner dataScan = null;
    try {
      in = new FileReader(movieFile);
      dataScan = new Scanner(in);

      while (true) {
        try {
          String record = dataScan.nextLine();
          String[] values = record.split(",");
          Movie movie = new Movie();
          movie.setTitle(values[0]);
          movie.setGenre(Genre.valueOf(values[1]));
          movie.setViewCount(Integer.parseInt(values[2]));
          movieList.add(movie);

        } catch (NoSuchElementException e) {
          break;
        }
      }
      System.out.printf("영화 %d개를 로딩하였습니다!\n", movieList.size());
    } catch (IOException e) {
      System.out.println("영화 데이터를 로딩하는 중에 에러가 발생하였습니다...");
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }

    }
  }

  String name;
  String ID;
  String password;
  Genre favoriteGenre;
  List<Movie> toWatchList = new ArrayList<>();
  MovieHandler toWatchHandler = new MovieHandler(toWatchList);
  List<Movie> watchedList = new Stack<>();
  MovieHandler watchedHandler = new MovieHandler(watchedList);
  MovieHandler allMoviesHandler;

  public static void saveMembers() {
    FileWriter out = null;
    try {
      out = new FileWriter(memberFile);
      StringBuilder toWatch = new StringBuilder();
      StringBuilder watched = new StringBuilder();
      for (Member member : memberList) {
        for (int i = 0; i < member.getToWatchList().size(); i++) {
          if (i != 0)
            toWatch.append(":");
          toWatch.append(member.getToWatchList().get(i).getTitle());
        }
        for (int i = 0; i < member.getWatchedList().size(); i++) {
          if (i != 0)
            watched.append(":");
          watched.append(member.getWatchedList().get(i).getTitle());
        }

        String record = String.format("%s,%s,%s,%s,%s,%s\n", member.getName(), member.getID(),
            member.getPassword(), member.getFavoriteGenre(), toWatch.toString(),
            watched.toString());
        out.write(record);
      }
    } catch (IOException e) {
      System.out.println("회원 데이터를 저장하는 중 오류가 발생하였습니다.");
    } finally {
      try {
        out.close();
      } catch (IOException e) {

      }
    }
  }

  public static void saveMovies() {
    FileWriter out = null;
    try {
      out = new FileWriter(movieFile);
      for (Movie movie : movieList) {
        String record =
            String.format("%s,%s,%d\n", movie.getTitle(), movie.getGenre(), movie.getViewCount());
        out.write(record);
      }
      System.out.printf("%d개의 영화를 저장했습니다.", movieList.size());
    } catch (IOException e) {
      System.out.println("영화를 저장하다가 오류가 발생했습니다....");
    } finally {
      try {
        out.close();
      } catch (IOException e) {
      }
    }
  }

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
        saveMovies();
        saveMembers();
        System.exit(0);
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
          saveMovies();
          saveMembers();
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
        saveMovies();
        saveMembers();
        System.exit(0);;
      default:
        System.out.println("잘못된 명령입니다.");
    }
  }
}
