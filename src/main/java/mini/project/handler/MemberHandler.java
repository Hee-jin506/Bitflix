package mini.project.handler;

import mini.project.domain.Genre;
import mini.project.domain.Member;
import mini.project.domain.Movie;
import mini.project.util.Iterator;
import mini.project.util.List;
import mini.project.util.Prompt;

public class MemberHandler {
  List<Member> memberList;
  MovieHandler movieHandler;
  
  public MemberHandler(List<Member> memberList, MovieHandler movieHandler) {
    this.memberList = memberList;
    this.movieHandler = movieHandler;
  }
  
  public void manage() {

    switch (Prompt.inputString("회원 추가\n회원 삭제\n회원 수정\n회원 조회\n입력>(빈문자열:취소) ")) {
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
//  String name;
//  int age;
//  int gender;
//  List<Movie> favoriteGenre;
//  List<Movie> toWatchList;
//  
  public void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();
    member.setName(Prompt.inputString("이름? "));
    member.setAge(Prompt.inputInt("나이? "));
    while (true) {
      String gender = Prompt.inputString("성별? ");
      if (gender.equals("여성") || gender.equals("남성")) {
        member.setGender(gender);
        break;
      } else {
        System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
      }
    }
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
        
        System.out.printf("%d, %s, %s, %s\n",
          member.getAge(),
          member.getGender(),
          member.getFavoriteGenre().toString(),
          movies.toString()
          );
    }
  }

  public void update() {
    System.out.println("[회원 변경]");
    String name = Prompt.inputString("이름? ");
    Member member = findByName(name);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    int age = Prompt.inputInt(
        String.format("나이(%d)? ", member.getAge()));
    String gender = Prompt.inputString(
        String.format("성별(%s)? ", member.getGender()));
    Genre newFavoriteGenre = Prompt.inputGenre(
        String.format("취향 장르(%s)? ", member.getFavoriteGenre().toString()));
    // toWatchList 변경어떻게 할겨
    
    String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.setAge(age);
    member.setGender(gender);
    member.setFavoriteGenre(newFavoriteGenre);
    
    // toWatchList 어떻게 할겨
    
    System.out.println("회원 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    String name = Prompt.inputString("이름? ");
    int index = indexOf(name);

    if (index == -1) {
      System.out.println("해당 이름의 회원이 없습니다.");
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

//  public void watch() {
//
//  }

  Member findByName(String name) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getName().equals(name)) {
        return member;
      }
    }
    return null;
  }

  int indexOf(String name) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getName().equals(name)) {
        return i;
      }
    }
    return -1;
  }

  public void printToWatchList() {
    Member member = findByName(Prompt.inputString("이름? "));
    member.getToWatchHandler().list();
  }

//  public void printHistory() {
//
//  }
}
