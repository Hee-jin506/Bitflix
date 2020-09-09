package mini.project.handler;

import mini.project.domain.Member;
import mini.project.util.ArrayList;
import mini.project.util.List;
import mini.project.util.Prompt;

public class MemberHandler {
  static List<Member> memberList = new ArrayList<>();

  public void manage() {

    switch (Prompt.inputString("회원 추가\n회원 삭제\n 회원 수정\n회원 조회\n입력>(빈문자열:취소) ")) {
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

  public void add() {

  }

  public void list() {


  }

  public void update() {

  }

  public void delete() {

  }

  public void watch() {

  }

  Member findByName(String name) {
    return null;
  }

  int indexOf(String name) {
    return -1;
  }

  public void printToWatchList() {

  }

  public void printHistory() {

  }
}
