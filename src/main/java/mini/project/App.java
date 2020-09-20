// - 화면 조합은 스크린에서 할 수 있도록
// - 의존 객체에게 책임 온전히 지우기
// - Handler 클래스 정리
//
//

// MemberHandler 에서 Member의 toWatchList필드를 갖고와서 직접 add하는 모습
// member.getToWatchList().add(movie)

// => MemberHandler에서 Member에게 보고 싶은 영화에 영화를 추가하라고 시키고
// member.addToWatchList(movie);

// Member에서 이 일을 Member에서 온전히 했어야한다.
// public void addToWatchList(Movie movie) {
// getToWatchList().add(movie);
// }
package mini.project;

import mini.project.util.CommandProcessor;

public class App {

  public static void main(String[] args) throws InterruptedException {
    CommandProcessor.loadMovies();
    CommandProcessor.loadMembers();
    // 로그인한 사용자
    CommandProcessor.loggedInMember = null;

    while (true) {
      if (CommandProcessor.loggedInMember == null) {
        CommandProcessor.isLoggedOut();
      } else /* (loggedInMember != null) */ {
        CommandProcessor.isLoggedIn();
      }
    }
  }
}


