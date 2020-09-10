package mini.project;

import mini.project.util.CommandProcessor;

public class App {


  public static void main(String[] args) throws InterruptedException {

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


