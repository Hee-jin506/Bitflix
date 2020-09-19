package mini.project.handler;

import java.util.Iterator;
import java.util.List;
import mini.project.domain.Genre;
import mini.project.domain.Member;
import mini.project.domain.Movie;
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
    while (true) {
      Screen.viewMenu(Screen.MEMBER_MANAGE_PAGE);
      switch (Prompt.inputString("입력>(빈문자열:취소) ")) {
        case "회원추가":
          add();
          break;
        case "회원삭제":
          delete();
          break;
        case "회원수정":
          update();
          break;
        case "회원조회":
          list();
          break;
        case "":
          return;
        default:
          System.out.println("잘못된 입력입니다.");
      }
    }
  }


  public void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();
    member.setName(Prompt.inputString("이름? "));
    while (true) {
      String id = Prompt.inputString("아이디? ");
      if (id.equals("")) {
        System.out.println("아이디를 입력해주세요.");
        continue;
      }
      if (findByID(id) == null) {
        member.setID(id);
        break;
      }
      System.out.println("이미 사용되고 있는 아이디입니다. 다시 입력해주세요.");
    }
    member.setPassword(Prompt.inputString("비밀번호? "));
    System.out.println("장르 : 로맨스, 액션, 가족, 호러");
    member.setFavoriteGenre(Prompt.inputGenre("좋아하는 장르? "));

    System.out.println("보고싶은 영화?");

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
    // return member;
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

  public Member logIn() {
    System.out.println("아이디와 비밀번호를 입력해주세요. ");
    System.out.println("아이디에 빈 문자열을 입력하시면 취소됩니다.");
    while (true) {
      String ID = Prompt.inputString("아이디: ");
      if (ID.equals(""))
        return null;

      String password = Prompt.inputString("비밀번호: ");

      if (findByID(ID) == null) {
        System.out.println("아이디를 찾을 수 없습니다.");

      } else if (!findByID(ID).getPassword().equals(password)) {
        System.out.println("비밀번호가 틀렸습니다.");
      } else {
        return findByID(ID);
      }
    }
  }



  // 1) 여태 시청한 영화 개수 대비 장르를 계산해서 가장 비중이 높은 장르를 favorite으로 정한다.

  // 2) if (보고싶어요에 있는 영화면)

  // 3) 보고싶어요 리스트에 영화 삭제

  // 4) 영화 조회수 올리기

}
