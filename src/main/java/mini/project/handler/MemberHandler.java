package mini.project.handler;

import mini.project.domain.Member;
import mini.project.util.ArrayList;
import mini.project.util.Iterator;
import mini.project.util.List;
import mini.project.util.Prompt;

public class MemberHandler {
  static List<Member> memberList = new ArrayList<>();

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
    member.setToWatchList();
    memberList.add(member);
  }

  public void list() {
    System.out.println("[회원 목록]");

    Iterator<Member> iterator = memberList.iterator();
      while (iterator.hasNext()) {
        Member member = iterator.next();
        System.out.printf("%d, %s, %s, %s, %s\n",
          member.getAge(),
          member.getGender(),
          member.getFavoriteGenre(),
          member.getToWatchList()
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
        String.format("나이(%d)? ", member.getName()));
    String gender = Prompt.inputString(
        String.format("성별(%s)? ", member.getGender()));
    String favoriteGenre = Prompt.inputString(
        String.format("취향 장르(%s)? ", member.getFavoriteGenre()));
    // toWatchList 변경어떻게 할겨
    
    String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.setAge(age);
    member.setGender(gender);
    member.setFavoriteGenre(favoriteGenre);
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

  public void watch() {

  }

  Member findByName(String name) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getName() == name) {
        return member;
      }
    }
    return null;
  }

  int indexOf(String name) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getName() == name) {
        return i;
      }
    }
    return -1;
  }

  public void printToWatchList() {

  }

  public void printHistory() {

  }
}
